package com.pdsa.recommendation_tool.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.pdsa.recommendation_tool.model.Location;
import com.pdsa.recommendation_tool.osm.GeoUtils;

public class NearestNeighbourGraphBuilder {

    private NearestNeighbourGraphBuilder() {
    }

    public static Graph<Location> build(List<Location> locations, int k) {

        Graph<Location> graph = new Graph<>();

        for (Location location : locations) {
            graph.addNode(location);
        }

        for (Location current : locations) {

            List<Location> others = new ArrayList<>();
            for (Location candidate : locations) {
                if (!candidate.equals(current)) {
                    others.add(candidate);
                }
            }

            others.sort(Comparator.comparingDouble(other ->
                    GeoUtils.calculateDistance(
                            current.getLatitude(), current.getLongitude(),
                            other.getLatitude(), other.getLongitude()
                    )
            ));

            int limit = Math.min(k, others.size());

            for (int i = 0; i < limit; i++) {
                Location neighbour = others.get(i);
                double distance = GeoUtils.calculateDistance(
                        current.getLatitude(), current.getLongitude(),
                        neighbour.getLatitude(), neighbour.getLongitude()
                );
                graph.addRoad(current, neighbour, distance);
            }
        }

        return graph;
    }
}