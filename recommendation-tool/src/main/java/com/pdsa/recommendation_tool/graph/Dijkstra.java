package com.pdsa.recommendation_tool.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.pdsa.recommendation_tool.model.Edge;

public class Dijkstra<T> {

    // Find shortest distances from the starting node
    public Map<T, Double> findShortestDistances(
            Map<T, List<Edge<T>>> graph,
            T start) {

        // Stores the shortest known distance
        Map<T, Double> distances = new HashMap<>();

        // Stores nodes that have already been processed
        Set<T> visited = new HashSet<>();

        // MinHeap stores nodes according to their distance
        MinHeap<T> minHeap = new MinHeap<>(10);

        // Initially, every node has infinite distance
        for (T node : graph.keySet()) {
            distances.put(node, Double.POSITIVE_INFINITY);
        }

        // Distance from start to itself is 0
        distances.put(start, 0.0);

        // Add starting node to MinHeap
        minHeap.insert(start, 0.0);

        // Continue until there are no more nodes
        while (!minHeap.isEmpty()) {

            // Get node with smallest distance
            T current = minHeap.removeMin();

            // Skip if already processed
            if (visited.contains(current)) {
                continue;
            }

            // Mark current node as visited
            visited.add(current);

            // Get neighbouring nodes
            List<Edge<T>> neighbours = graph.get(current);

            // If there are no neighbours, continue
            if (neighbours == null) {
                continue;
            }

            // Check each neighbour
            for (Edge<T> edge : neighbours) {

                T neighbour = edge.getDestination();

                double weight = edge.getWeight();

                // Calculate distance through current node
                double newDistance =
                        distances.get(current) + weight;

                // If new distance is shorter
                if (newDistance < distances.get(neighbour)) {

                    // Update shortest distance
                    distances.put(neighbour, newDistance);

                    // Add neighbour to MinHeap
                    minHeap.insert(neighbour, newDistance);
                }
            }
        }

        return distances;
    }
}