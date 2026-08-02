import java.util.*;

public class Graph {

    private Map<Location, List<Road>> adjacencyList;

    public Graph() {

        adjacencyList = new HashMap<>();

    }

    public void addLocation(Location location) {

        if (!adjacencyList.containsKey(location)) {

            adjacencyList.put(location, new ArrayList<>());

        }

    }

    public void addRoad(Road road) {

        Location source = road.getSource();
        Location destination = road.getDestination();

        adjacencyList.get(source).add(road);

        // Optional: make roads two-way
        Road reverseRoad =
                new Road(destination, source, road.getDistance());

        adjacencyList.get(destination).add(reverseRoad);

    }

    public List<Road> getNeighbours(Location location) {

        return adjacencyList.get(location);

    }

    public void displayGraph() {

        for (Location location : adjacencyList.keySet()) {

            System.out.println(location + " connects to:");

            for (Road road : adjacencyList.get(location)) {

                System.out.println(
                        " -> " +
                        road.getDestination() +
                        " (" +
                        road.getDistance() +
                        " km)"
                );

            }

            System.out.println();

        }

    }

}