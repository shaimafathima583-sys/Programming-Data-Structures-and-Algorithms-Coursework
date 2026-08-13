package com.pdsa.recommendation_tool.service;

import com.pdsa.recommendation_tool.data.ExcelDataLoader;
import com.pdsa.recommendation_tool.graph.Dijkstra;
import com.pdsa.recommendation_tool.graph.DistrictGraph;
import com.pdsa.recommendation_tool.graph.MaxHeap;
import com.pdsa.recommendation_tool.graph.ProvinceGraph;
import com.pdsa.recommendation_tool.model.Edge;
import com.pdsa.recommendation_tool.model.Location;
import com.pdsa.recommendation_tool.model.Province;
import com.pdsa.recommendation_tool.dto.RecommendationResponse;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecommendationService {

    private final ExcelDataLoader excelDataLoader;
    private final OSMEnrichment osmEnrichment;

    public RecommendationService(ExcelDataLoader excelDataLoader, OSMEnrichment osmEnrichment) {
    this.excelDataLoader = excelDataLoader;
    this.osmEnrichment = osmEnrichment;
}

    public RecommendationResponse getRecommendation(
            String currentLocationName) {

       
        // 1. LOAD EXCEL DATA
       

        List<Location> locations =
                excelDataLoader.loadLocations("locations.xlsx");


        
        // 2. FIND CURRENT LOCATION
       

        Location currentLocation = null;

        for (Location location : locations) {

            if (location.getName()
                    .equalsIgnoreCase(currentLocationName)) {

                currentLocation = location;
                break;
            }
        }

        if (currentLocation == null) {

            System.out.println(
                    "Location not found: "
                            + currentLocationName
            );

            return null;
        }


        String currentProvince =
                currentLocation.getProvince();

        System.out.println(
                "Current Location: "
                        + currentLocation.getName()
        );

        System.out.println(
                "Current Province: "
                        + currentProvince
        );


        
        // 3. CREATE PROVINCES
       

        Map<String, Province> provinceMap =
                createProvinces(locations);


        
        // 4. CREATE PROVINCE GRAPH
       

        ProvinceGraph provinceGraph =
                new ProvinceGraph();

        List<Province> provinces =
                new ArrayList<>(
                        provinceMap.values()
                );

        for (Province province : provinces) {

            provinceGraph.addProvince(province);
        }


       
        // 5. CONNECT PROVINCES
       

        for (int i = 0; i < provinces.size(); i++) {

            for (int j = i + 1;
                 j < provinces.size();
                 j++) {

                Province first =
                        provinces.get(i);

                Province second =
                        provinces.get(j);

                double distance =
                        DistanceCalculator.calculateDistance(
                                first.getLatitude(),
                                first.getLongitude(),
                                second.getLatitude(),
                                second.getLongitude()
                        );

                provinceGraph.addEdge(
                        first,
                        second,
                        distance
                );

                provinceGraph.addEdge(
                        second,
                        first,
                        distance
                );
            }
        }


        
        // 6. DIJKSTRA FOR PROVINCES
       

        Province startProvince =
                provinceMap.get(currentProvince);

        Dijkstra<Province> provinceDijkstra =
                new Dijkstra<>();

        Map<Province, Double> provinceDistances =
                provinceDijkstra.findShortestDistances(
                        provinceGraph.getAdjacencyList(),
                        startProvince
                );


       
        // 7. RANK PROVINCES
       

        MaxHeap provinceHeap =
                new MaxHeap();

        for (int i = 0;
             i < provinces.size();
             i++) {

            Province province =
                    provinces.get(i);

            // Do NOT recommend the current province.
            // This is a market expansion system.

            if (province.getName()
                    .equalsIgnoreCase(currentProvince)) {

                continue;
            }

            double opportunity =
                    OpportunityCalculator
                            .calculateScore(province);

            double distance =
                    provinceDistances.get(province);

            double finalScore =
                    opportunity
                            - (distance * 0.01);

            provinceHeap.insert(
                    i,
                    finalScore
            );

            System.out.println(
                    province.getName()
                            + " | Opportunity: "
                            + opportunity
                            + " | Distance: "
                            + String.format(
                                    "%.2f",
                                    distance
                            )
                            + " km | Final Score: "
                            + String.format(
                                    "%.2f",
                                    finalScore
                            )
            );
        }


        
        // 8. BEST PROVINCE
       

        MaxHeap.Node bestProvinceNode =
                provinceHeap.extractMax();

        Province bestProvince =
                provinces.get(
                        bestProvinceNode.vertex
                );

        double bestProvinceScore =
                bestProvinceNode.score;

        double bestProvinceDistance =
                provinceDistances.get(
                        bestProvince
                );

        System.out.println();

        System.out.println(
                "========== RECOMMENDED PROVINCE =========="
        );

        System.out.println(
                "Province: "
                        + bestProvince.getName()
        );

        System.out.println(
                "Final Score: "
                        + String.format(
                                "%.2f",
                                bestProvinceScore
                        )
        );

        System.out.println(
                "Distance: "
                        + String.format(
                                "%.2f",
                                bestProvinceDistance
                        )
                        + " km"
        );


        
        // 9. CREATE DISTRICT GRAPH
      

        DistrictGraph districtGraph =
                DistrictGraph.createForProvince(
                        bestProvince.getName(),
                        locations
                );


        
        // 10. CREATE DISTRICT CENTERS
       

        Map<String, Location> districtCenters =
                calculateDistrictCenters(
                        locations,
                        bestProvince.getName()
                );

        List<String> districts =
                new ArrayList<>(
                        districtCenters.keySet()
                );


        
        // 11. CONNECT DISTRICTS
        

        for (int i = 0;
             i < districts.size();
             i++) {

            for (int j = i + 1;
                 j < districts.size();
                 j++) {

                String firstDistrict =
                        districts.get(i);

                String secondDistrict =
                        districts.get(j);

                Location firstLocation =
                        districtCenters.get(
                                firstDistrict
                        );

                Location secondLocation =
                        districtCenters.get(
                                secondDistrict
                        );

                double distance =
                        DistanceCalculator.calculateDistance(
                                firstLocation.getLatitude(),
                                firstLocation.getLongitude(),
                                secondLocation.getLatitude(),
                                secondLocation.getLongitude()
                        );

                districtGraph.addRoad(
                        firstDistrict,
                        secondDistrict,
                        distance
                );
            }
        }


        
        // 12. CONNECT CURRENT LOCATION
        // TO RECOMMENDED PROVINCE
        


        String currentNode =
                "__CURRENT_LOCATION__";


        for (String district : districts) {

            Location districtCenter =
                    districtCenters.get(district);

            double distance =
                    DistanceCalculator.calculateDistance(
                            currentLocation.getLatitude(),
                            currentLocation.getLongitude(),
                            districtCenter.getLatitude(),
                            districtCenter.getLongitude()
                    );

            districtGraph.addRoad(
                    currentNode,
                    district,
                    distance
            );
        }


       
        // 13. DIJKSTRA FOR DISTRICTS
        

        Dijkstra<String> districtDijkstra =
                new Dijkstra<>();

        Map<String, List<Edge<String>>> districtGraphData =
                convertDistrictGraph(
                        districtGraph
                );

        Map<String, Double> shortestDistrictDistances =
                districtDijkstra.findShortestDistances(
                        districtGraphData,
                        currentNode
                );


        
        // 14. GET LOCATIONS IN RECOMMENDED PROVINCE
      

        System.out.println();

        System.out.println(
                "========== DISTRICT SCORES =========="
        );

        List<Location> districtLocations =
                new ArrayList<>();

        for (Location location : locations) {

            if (location.getProvince()
                    .equalsIgnoreCase(
                            bestProvince.getName()
                    )) {

                districtLocations.add(location);
            }
        }


       
        // 15. GROUP LOCATIONS BY DISTRICT
        

        Map<String, List<Location>> groupedDistricts =
                new HashMap<>();

        for (Location location :
                districtLocations) {

            groupedDistricts
                    .computeIfAbsent(
                            location.getDistrict(),
                            key -> new ArrayList<>()
                    )
                    .add(location);
        }


        
        // 16. RANK DISTRICTS
        

        MaxHeap districtHeap =
                new MaxHeap();

        List<String> districtNames =
                new ArrayList<>(
                        groupedDistricts.keySet()
                );


        for (int i = 0;
             i < districtNames.size();
             i++) {

            String district =
                    districtNames.get(i);

            List<Location> districtData =
                    groupedDistricts.get(district);


            
            // CALCULATE AVERAGE OPPORTUNITY
           

            double averageScore = 0;

            for (Location location :
                    districtData) {

                averageScore +=
                        OpportunityCalculator
                                .calculateScore(location);
            }

            averageScore =
                    averageScore /
                            districtData.size();


          
            // GET DISTANCE
            

            double distance =
                    shortestDistrictDistances
                            .getOrDefault(
                                    district,
                                    Double.POSITIVE_INFINITY
                            );


          
            // FINAL DISTRICT SCORE
           

            double finalScore =
                    averageScore
                            - (distance * 0.01);


            finalScore =
                    Math.round(
                            finalScore * 100.0
                    ) / 100.0;


            System.out.println(
                    district
                            + " | Opportunity: "
                            + String.format(
                                    "%.2f",
                                    averageScore
                            )
                            + " | Distance: "
                            + String.format(
                                    "%.2f",
                                    distance
                            )
                            + " km | Final Score: "
                            + String.format(
                                    "%.2f",
                                    finalScore
                            )
            );


            districtHeap.insert(
                    i,
                    finalScore
            );
        }


        
        // 17. BEST DISTRICT
        

        MaxHeap.Node bestDistrictNode =
                districtHeap.extractMax();

        String bestDistrict =
                districtNames.get(
                        bestDistrictNode.vertex
                );

        double bestDistrictScore =
                bestDistrictNode.score;

        double bestDistrictDistance =
                shortestDistrictDistances.get(
                        bestDistrict
                );


        System.out.println();

        System.out.println(
                "========== RECOMMENDED DISTRICT =========="
        );

        System.out.println(
                "Province: "
                        + bestProvince.getName()
        );

        System.out.println(
                "District: "
                        + bestDistrict
        );

        System.out.println(
                "Final Score: "
                        + String.format(
                                "%.2f",
                                bestDistrictScore
                        )
        );

        System.out.println(
                "Distance: "
                        + String.format(
                                "%.2f",
                                bestDistrictDistance
                        )
                        + " km"
        );


        
        // 18. RETURN RESPONSE TO FRONTEND
       

        return new RecommendationResponse(
                currentLocation.getName(),
                currentProvince,
                bestProvince.getName(),
                bestProvinceScore,
                bestProvinceDistance,
                bestDistrict,
                bestDistrictScore,
                bestDistrictDistance
        );
    }


    
    // CREATE PROVINCES FROM LOCATIONS
    

    private Map<String, Province> createProvinces(
            List<Location> locations) {

        Map<String, List<Location>> grouped =
                new HashMap<>();


        for (Location location : locations) {

            grouped
                    .computeIfAbsent(
                            location.getProvince(),
                            key -> new ArrayList<>()
                    )
                    .add(location);
        }


        Map<String, Province> provinces =
                new HashMap<>();


        for (Map.Entry<String, List<Location>> entry :
                grouped.entrySet()) {

            String provinceName =
                    entry.getKey();

            List<Location> data =
                    entry.getValue();


            int population = 0;

            double purchasing = 0;
            double facilities = 0;
            double competition = 0;

            double latitude = 0;
            double longitude = 0;


            for (Location location : data) {

                population +=
                        location.getPopulation();

                purchasing +=
                        location.getPurchasingPower();

                facilities +=
                        location.getFacilities();

                competition +=
                        location.getCompetition();

                latitude +=
                        location.getLatitude();

                longitude +=
                        location.getLongitude();
            }


            int count =
                    data.size();


            provinces.put(
                    provinceName,
                    new Province(
                            provinceName,
                            population,
                            purchasing / count,
                            facilities / count,
                            competition / count,
                            latitude / count,
                            longitude / count
                    )
            );
        }

        return provinces;
    }


    
    // CALCULATE DISTRICT CENTERS
    

    private Map<String, Location> calculateDistrictCenters(
            List<Location> locations,
            String province) {

        Map<String, List<Location>> grouped =
                new HashMap<>();


        for (Location location : locations) {

            if (location.getProvince()
                    .equalsIgnoreCase(province)) {

                grouped
                        .computeIfAbsent(
                                location.getDistrict(),
                                key -> new ArrayList<>()
                        )
                        .add(location);
            }
        }


        Map<String, Location> centers =
                new HashMap<>();


        for (Map.Entry<String, List<Location>> entry :
                grouped.entrySet()) {

            List<Location> data =
                    entry.getValue();


            double latitude = 0;
            double longitude = 0;


            for (Location location : data) {

                latitude +=
                        location.getLatitude();

                longitude +=
                        location.getLongitude();
            }


            latitude /=
                    data.size();

            longitude /=
                    data.size();


            Location center =
                    new Location(
                            entry.getKey(),
                            entry.getKey(),
                            province,
                            0,
                            0,
                            0,
                            0,
                            0,
                            0,
                            0,
                            0,
                            latitude,
                            longitude
                    );


            centers.put(
                    entry.getKey(),
                    center
            );
        }

        return centers;
    }


    
    // CONVERT DISTRICT GRAPH
    // TO DIJKSTRA FORMAT
   

    private Map<String, List<Edge<String>>> convertDistrictGraph(
            DistrictGraph graph) {

        return graph.getAdjacencyList();
    }
}