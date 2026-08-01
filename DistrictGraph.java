package graph;

import model.*;

import java.util.*;

public class DistrictGraph {

    private String districtName;

    private Map<Location, List<Edge>> graph;

    public DistrictGraph(String districtName) {

        this.districtName = districtName;
        graph = new HashMap<>();

    }

    public void addLocation(Location location) {

        graph.putIfAbsent(location, new ArrayList<>());

    }

    public void connectLocations(Location source,
                                 Location destination,
                                 double distance) {

        graph.get(source).add(new Edge(destination, distance));
        graph.get(destination).add(new Edge(source, distance));

    }

    public void displayGraph() {

        System.out.println("\nDistrict : " + districtName);

        for (Location location : graph.keySet()) {

            System.out.println("\n" + location.getName());

            for (Edge edge : graph.get(location)) {

                System.out.println("   -> "
                        + edge.getDestination().getName()
                        + " ("
                        + edge.getDistance()
                        + " km)");

            }

        }

    }

}
