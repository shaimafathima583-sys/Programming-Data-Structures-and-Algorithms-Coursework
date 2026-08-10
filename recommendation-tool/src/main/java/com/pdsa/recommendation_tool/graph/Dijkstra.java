package com.pdsa.recommendation_tool.graph;

import java.util.*;

public class Dijkstra {

    public static class Location {
        private int id;
        private String name;

        public Location(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static class Edge {
        private Location destination;
        private double weight;

        public Edge(Location destination, double weight) {
            this.destination = destination;
            this.weight = weight;
        }

        public Location getDestination() {
            return destination;
        }

        public double getWeight() {
            return weight;
        }
    }

    private Map<Location, List<Edge>> adjacencyList = new HashMap<>();

    public void addLocation(Location location) {
        adjacencyList.putIfAbsent(location, new ArrayList<>());
    }

    public void addEdge(Location source, Location destination, double weight) {
        adjacencyList.get(source).add(new Edge(destination, weight));
    }

    public Set<Location> getLocations() {
        return adjacencyList.keySet();
    }

    public List<Edge> getNeighbors(Location location) {
        return adjacencyList.getOrDefault(location, new ArrayList<>());
    }
}