import java.util.*;

public class NearestGraphBuilder {

    public Graph build(List<Location> locations, int neighboursPerNode) {

        Graph graph = new Graph();

        for (Location location : locations) graph.addLocation(location);

        for (Location from : locations) {

            List<Location> others = new ArrayList<>(locations);
            others.remove(from);

            others.sort(Comparator.comparingDouble(to ->
                    GeoUtils.haversineKm(from.getLatitude(), from.getLongitude(),
                            to.getLatitude(), to.getLongitude())));

            int limit = Math.min(neighboursPerNode, others.size());

            for (int i = 0; i < limit; i++) {
                Location to = others.get(i);
                double distance = GeoUtils.haversineKm(
                        from.getLatitude(), from.getLongitude(),
                        to.getLatitude(), to.getLongitude());

                graph.addRoad(new Road(from, to, distance));
            }
        }
        return graph;
    }
}