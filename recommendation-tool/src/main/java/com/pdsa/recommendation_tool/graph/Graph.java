package com.pdsa.recommendation_tool.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Minimal Graph implementation expected by Dijkstra.
 */
public class Graph {

	private final Map<Location, List<Edge>> adj = new HashMap<>();

	public void addLocation(Location location) {
		adj.computeIfAbsent(location, k -> new ArrayList<>());
	}

	public void addEdge(Location from, Location to, double weight) {
		addLocation(from);
		addLocation(to);
		adj.get(from).add(new Edge(to, weight));
	}

	public List<Location> getLocations() {
		return new ArrayList<>(adj.keySet());
	}

	public List<Edge> getNeighbors(Location location) {
		List<Edge> list = adj.get(location);
		return list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
	}

	public static class Location {
		private final int id;
		private final String name;

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

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Location location = (Location) o;
			return id == location.id;
		}

		@Override
		public int hashCode() {
			return Integer.hashCode(id);
		}
	}

	public static class Edge {
		private final Location destination;
		private final double weight;

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
}

