import java.util.*;

public class Graph {

    private Map<Location, List<Edge>> adjacencyList;


    public Graph(){

        adjacencyList = new HashMap<>();

    }


    // Add loc node
    public void addLocation(Location location){

        adjacencyList.put(location, new ArrayList<>());

    }


    // Add edge
    public void addRoad(Edge road){

        Location source = road.getSource();

        adjacencyList.get(source).add(road);

    }


    // Get neighbour roads
    public List<Edge> getNeighbours(Location location){

        return adjacencyList.get(location);

    }


    // Display graph (for testing)
    public void displayGraph(){

        for(Location location : adjacencyList.keySet()){

            System.out.println(location + " --> ");

            for(Edge edge : adjacencyList.get(location)){

                System.out.println(
                    edge.getDestination()
                );
            }

        }

    }

}