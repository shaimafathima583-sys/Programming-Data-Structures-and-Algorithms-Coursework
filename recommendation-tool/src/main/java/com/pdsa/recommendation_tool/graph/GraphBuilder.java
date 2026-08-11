package com.pdsa.recommendation_tool.graph;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.ToDoubleBiFunction;

@Service
public class GraphBuilder {

    /** Builds a graph from an explicit list of nodes and known road/edge distances. */
    public <T> Graph<T> buildFromRoads(List<T> nodes, List<RoadDefinition<T>> roads) {
        Graph<T> graph = new Graph<>();
        nodes.forEach(graph::addNode);
        for (RoadDefinition<T> road : roads) {
            graph.addRoad(road.source(), road.destination(), road.distance());
        }
        return graph;
    }

    public <T> Graph<T> buildNearestNeighbour(List<T> nodes, int k, ToDoubleBiFunction<T, T> distanceFn) {
        Graph<T> graph = new Graph<>();
        nodes.forEach(graph::addNode);

        for (T node : nodes) {
            nodes.stream()
                    .filter(other -> !other.equals(node))
                    .sorted((a, b) -> Double.compare(distanceFn.applyAsDouble(node, a), distanceFn.applyAsDouble(node, b)))
                    .limit(k)
                    .forEach(nearest -> graph.addRoad(node, nearest, distanceFn.applyAsDouble(node, nearest)));
        }
        return graph;
    }

    public record RoadDefinition<T>(T source, T destination, double distance) {}
}
