import java.util.List;

public class GraphBuilder {

    public Graph buildGraph(List<Location> locations, List<Edge> roads) {
        Graph graph = new Graph();

        if (locations != null) {
            for (Location location : locations) {
                graph.addNode(location);
            }
        }

        if (roads != null) {
            for (Edge road : roads) {
                graph.addEdge(road);
            }
        }

        return graph;
    }

}

