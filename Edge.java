public class Edge {

    Location source;
    Location destination;
    double distance;


    public Edge(Location source, Location destination, double distance) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
    }

    public Location getSource() {
        return source;
    }

    public Location getDestination() {
        return destination;
    }

    public double getDistance() {
        return distance;
    }
}