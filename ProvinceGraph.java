import java.util.ArrayList;
import java.util.HashMap;

public class ProvinceGraph {

    // Graph using Adjacency List
    // Key = Province
    // Value = List of connected provinces (edges)

    private HashMap<Province, ArrayList<Edge>> graph;


    // Constructor
    public ProvinceGraph() {

        graph = new HashMap<>();

    }


    // Add a new province (Node) to the graph
    public void addProvince(Province province) {

        if (!graph.containsKey(province)) {

            graph.put(province, new ArrayList<>());

        }

    }


    // Connect two provinces with distance (Edge)
    public void addEdge(
            Province source,
            Province destination,
            double distance
    ) {


        // Check whether both provinces exist

        if (graph.containsKey(source)
                &&
            graph.containsKey(destination)) {


            // Add connection source -> destination

            graph.get(source)
                 .add(new Edge(destination, distance));


            // Two-way connection destination -> source

            graph.get(destination)
                 .add(new Edge(source, distance));

        }

    }



    // Display Province Graph
    public void displayGraph() {


        for (Province province : graph.keySet()) {


            System.out.println(
                    province + " connects to:"
            );


            ArrayList<Edge> edges =
                    graph.get(province);



            for (Edge edge : edges) {


                System.out.println(
                        "   -> "
                        + edge.destination
                        + " ("
                        + edge.distance
                        + " km)"
                );

            }


            System.out.println();

        }

    }

}