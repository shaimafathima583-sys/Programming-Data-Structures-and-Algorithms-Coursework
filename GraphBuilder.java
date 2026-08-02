import java.util.List;

public class GraphBuilder {


    public Graph buildGraph(List<Location> locations, List<Road> roads) {

    Graph graph = new Graph();

    // Add nodes
    for(Location location : locations){

        graph.addLocation(location);

    }


    // Add edges
    for(Road road : roads){

        graph.addRoad(road);

    }


    return graph;
}

}

