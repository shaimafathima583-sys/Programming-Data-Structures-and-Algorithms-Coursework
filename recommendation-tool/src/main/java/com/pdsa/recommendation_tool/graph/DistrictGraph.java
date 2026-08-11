package com.pdsa.recommendation_tool.graph;

import com.pdsa.recommendation_tool.model.Edge;
import com.pdsa.recommendation_tool.model.Location;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DistrictGraph {

    // Stores each district and its connected districts
    private Map<String, List<Edge<String>>> adjacencyList;

    // Constructor
    public DistrictGraph() {
        adjacencyList = new LinkedHashMap<>();
    }

    // Add a district to the graph
    public void addDistrict(String district) {

        if (!adjacencyList.containsKey(district)) {
            adjacencyList.put(district, new ArrayList<>());
        }
    }

    // Add a connection between two districts
    public void addRoad(
            String source,
            String destination,
            double distance) {

        // Add both districts first
        addDistrict(source);
        addDistrict(destination);

        // Add destination to source's list
        adjacencyList.get(source).add(
                new Edge<>(destination, distance)
        );

        // Add source to destination's list
        adjacencyList.get(destination).add(
                new Edge<>(source, distance)
        );
    }

    // Get neighbouring districts
    public List<Edge<String>> getNeighbours(String district) {

        if (adjacencyList.containsKey(district)) {
            return adjacencyList.get(district);
        }

        return new ArrayList<>();
    }

    // Get all districts
    public Set<String> getAllDistricts() {
        return adjacencyList.keySet();
    }

    // Check whether a district exists
    public boolean contains(String district) {
        return adjacencyList.containsKey(district);
    }

    // Get number of districts
    public int size() {
        return adjacencyList.size();
    }

    // Get the complete adjacency list
    public Map<String, List<Edge<String>>> getAdjacencyList() {
        return adjacencyList;
    }

    // Display the district graph
    public void display() {

        System.out.println("========== DISTRICT GRAPH ==========");

        for (String district : adjacencyList.keySet()) {

            System.out.print(district + " -> ");

            List<Edge<String>> connections =
                    adjacencyList.get(district);

            for (Edge<String> edge : connections) {

                System.out.print(
                        edge.getDestination()
                        + " (" + edge.getWeight() + " km), "
                );
            }

            System.out.println();
        }

        System.out.println("====================================");
    }

    // Create a district graph for a selected province
    public static DistrictGraph createForProvince(
            String province,
            List<Location> locations) {

        DistrictGraph graph = new DistrictGraph();

        // Check every location
        for (Location location : locations) {

            // Check whether the location belongs
            // to the selected province
            if (location.getProvince().equalsIgnoreCase(province)) {

                // Get the district of that location
                String district = location.getDistrict();

                // Add the district to the graph
                graph.addDistrict(district);
            }
        }

        return graph;
    }
}