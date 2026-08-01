import java.util.ArrayList;
import java.util.HashMap;

public class DistrictGraph {

    // Graph using Adjacency List
    // Key = Location
    // Value = List of connected locations (edges)
    private HashMap<Location, ArrayList<Edge>> graph;

    // Constructor
    public DistrictGraph() {
        graph = new HashMap<>();
    }

    // Add a new location (Node) to the graph
    public void addLocation(Location location) {

        if (!graph.containsKey(location)) {
            graph.put(location, new ArrayList<>());
        }

    }

    // Connect two locations with a distance (edge)
    public void addEdge(Location source, Location destination, int distance) {

        // Check whether both locations exist
        if (graph.containsKey(source) && graph.containsKey(destination)) {

            graph.get(source).add(new Edge(destination, distance));

            //two-way roads
            graph.get(destination).add(new Edge(source, distance));
        }

    }

    // Display the graph
    public void displayGraph() {

        for (Location location : graph.keySet()) {

            System.out.println(location + " connects to:");

            ArrayList<Edge> edges = graph.get(location);

            for (Edge edge : edges) {

                System.out.println("   -> " + edge.destination +" (" + edge.distance + " km)"
                );

            }

            System.out.println();

        }

    }

}