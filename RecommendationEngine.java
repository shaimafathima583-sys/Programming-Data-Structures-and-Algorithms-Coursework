import java.util.Map;

public class RecommendationEngine {


    private Graph graph;



    public RecommendationEngine(Graph graph) {

        this.graph = graph;

    }



    public void recommendLocations(Location start) {



        // Get shortest distances

        Map<Location,Integer> distances =
                Dijkstra.findShortestPath(graph,start);



        MaxHeap maxHeap = new MaxHeap(100);



        // Calculate final score

        for(Location location : graph.getGraph().keySet()) {



            double businessScore =
                    OpportunityCalculator.calculateScore(location);



            int distance =
                    distances.get(location);



            // Distance penalty

            double finalScore =
                    businessScore - (distance * 0.2);



            maxHeap.insert(location, finalScore);


        }



        System.out.println();
        System.out.println("==============================");
        System.out.println(" TOP EXPANSION LOCATIONS ");
        System.out.println("==============================");



        int rank = 1;



        while(!maxHeap.isEmpty() && rank <= 3) {



            Location location =
                    maxHeap.removeMax();



            double score =
                    OpportunityCalculator.calculateScore(location);



            System.out.println();


            System.out.println(
                    "Rank : " + rank
            );


            System.out.println(
                    "Location : "
                    + location.getName()
            );


            System.out.println(
                    "District : "
                    + location.getDistrict()
            );


            System.out.println(
                    "Province : "
                    + location.getProvince()
            );


            System.out.println(
                    "Opportunity Score : "
                    + score
            );


            System.out.println(
                    "Distance from "
                    + start.getName()
                    + " : "
                    + distances.get(location)
                    + " km"
            );


            rank++;

        }


    }

}
