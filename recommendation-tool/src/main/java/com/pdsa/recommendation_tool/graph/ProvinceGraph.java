package com.pdsa.recommendation_tool.graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.pdsa.recommendation_tool.model.Edge;
import com.pdsa.recommendation_tool.model.Province;

public class ProvinceGraph {

    // Adjacency list:
    // Province -> list of connected provinces
    private final Map<Province, List<Edge<Province>>> adjacencyList;

    // Constructor
    public ProvinceGraph() {
        adjacencyList = new HashMap<>();
    }

    // Add a province to the graph
    public void addProvince(Province province) {

        if (province != null && !adjacencyList.containsKey(province)) {
            adjacencyList.put(province, new ArrayList<>());
        }
    }

    // Add a connection between two provinces
    public void addEdge(Province source, Province destination, double weight) {

        if (source == null || destination == null) {
            return;
        }

        // Make sure both provinces are in the graph
        addProvince(source);
        addProvince(destination);

        // Add connection from source to destination
        adjacencyList.get(source).add(
                new Edge<>(destination, weight)
        );
    }

    // Get neighbouring provinces
    public List<Edge<Province>> getNeighbours(Province province) {

        if (province == null || !adjacencyList.containsKey(province)) {
            return new ArrayList<>();
        }

        return adjacencyList.get(province);
    }

    // Get all provinces
    public List<Province> getProvinces() {
        return new ArrayList<>(adjacencyList.keySet());
    }

    // Check whether a province exists
    public boolean containsProvince(Province province) {
        return adjacencyList.containsKey(province);
    }

    // Get the complete adjacency list
    public Map<Province, List<Edge<Province>>> getAdjacencyList() {
        return adjacencyList;
    }

    // Display the graph
    public void displayGraph() {

        for (Map.Entry<Province, List<Edge<Province>>> entry
                : adjacencyList.entrySet()) {

            Province province = entry.getKey();

            System.out.print(province.getName() + " -> ");

            for (Edge<Province> edge : entry.getValue()) {

                System.out.print(
                        edge.getDestination().getName()
                                + " ("
                                + edge.getWeight()
                                + "), "
                );
            }

            System.out.println();
        }
    }
}
