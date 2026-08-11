package com.pdsa.recommendation_tool.graph;

import com.pdsa.recommendation_tool.model.Road;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Graph<T> {

    private final Map<T, List<Road<T>>> adjacencyList = new LinkedHashMap<>();

    public void addNode(T node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addRoad(T source, T destination, double distance) {
        addRoad(source, destination, distance, true);
    }

    public void addRoad(T source, T destination, double distance, boolean bidirectional) {
        addNode(source);
        addNode(destination);
        adjacencyList.get(source).add(new Road<>(destination, distance));
        if (bidirectional) {
            adjacencyList.get(destination).add(new Road<>(source, distance));
        }
    }

    public List<Road<T>> getNeighbours(T node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    public Set<T> getAllNodes() {
        return adjacencyList.keySet();
    }

    public boolean contains(T node) {
        return adjacencyList.containsKey(node);
    }

    public int size() {
        return adjacencyList.size();
    }

    public Graph<T> filter(Predicate<T> keepNode, BiPredicate<T, T> keepRoad) {
        Graph<T> filtered = new Graph<>();
        for (T node : adjacencyList.keySet()) {
            if (!keepNode.test(node)) continue;
            filtered.addNode(node);
            for (Road<T> road : adjacencyList.get(node)) {
                T dest = road.getDestination();
                if (keepNode.test(dest) && keepRoad.test(node, dest)) {
                    // roads are already bidirectional in the source graph, so add one-way here to avoid doubling up
                    filtered.addRoad(node, dest, road.getDistance(), false);
                }
            }
        }
        return filtered;
    }

    public void display() {
        for (T node : adjacencyList.keySet()) {
            System.out.println(node + " connects to:");
            for (Road<T> road : adjacencyList.get(node)) {
                System.out.println("  -> " + road.getDestination() + " (" + road.getDistance() + " km)");
            }
        }
    }

    public Map<T, List<Road<T>>> getAdjacencyList() {
        return adjacencyList;
    }
}
