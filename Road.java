public class Road {

    private Location source;
    private Location destination;
    private double distance;

    public Road(Location source, Location destination, double distance) {
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
