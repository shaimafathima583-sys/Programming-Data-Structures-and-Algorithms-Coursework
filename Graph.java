import java.util.*;

public class Graph {

    private Map<Location, List<Road>> adjacencyList;


    public Graph(){

        adjacencyList = new HashMap<>();

    }


    // Add a location/node
    public void addLocation(Location location){

        adjacencyList.put(location, new ArrayList<>());

    }


    // Add a connection/edge
    public void addRoad(Road road){

        Location source = road.getSource();

        adjacencyList.get(source).add(road);

    }


    // Get neighbouring roads
    public List<Road> getNeighbours(Location location){

        return adjacencyList.get(location);

    }


    // Display graph (for testing)
    public void displayGraph(){

        for(Location location : adjacencyList.keySet()){

            System.out.println(location + " --> ");

            for(Road road : adjacencyList.get(location)){

                System.out.println(
                    road.getDestination()
                );
            }

        }

    }

}