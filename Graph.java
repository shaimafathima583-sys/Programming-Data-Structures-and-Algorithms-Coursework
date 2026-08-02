import java.util.*;

public class Graph {

    private Map<Location, List<Road>> adjacencyList;

    public Graph() { 
        adjacencyList = new HashMap<>(); 
    }

    public void addLocation(Location location) {

        adjacencyList.putIfAbsent(location, new ArrayList<>());
    }

    public void addRoad(Road road) {

        Location source = road.getSource();
        Location destination = road.getDestination();

        addLocation(source);
        addLocation(destination);

        adjacencyList.get(source).add(road);

        // Roads are two-way by default
        Road reverseRoad = new Road(destination, source, road.getDistance());
        adjacencyList.get(destination).add(reverseRoad);
    }

    public List<Road> getNeighbours(Location location) {
        return adjacencyList.getOrDefault(location, Collections.emptyList());
    }

    public Map<Location, List<Road>> getGraph() {
         return adjacencyList; 
        }

    public void displayGraph() {
        for (Location location : adjacencyList.keySet()) {
            System.out.println(location + " connects to:");
            for (Road road : adjacencyList.get(location)) {
                System.out.println(" -> " + road.getDestination() + " (" + road.getDistance() + " km)");
            }
            System.out.println();
        }
    }
}