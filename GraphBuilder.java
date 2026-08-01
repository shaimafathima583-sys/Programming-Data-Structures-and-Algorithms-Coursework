import java.util.List;

public class GraphBuilder {


    public Graph buildGraph(List<Location> locations, List<Edge> roads) {

    Graph graph = new Graph();


    // Add nodes
    for(Location location : locations){

        graph.addLocation(location);

    }


    // Add edges
    for(Edge road : roads){

        graph.addRoad(road);

    }


    return graph;
}

}

