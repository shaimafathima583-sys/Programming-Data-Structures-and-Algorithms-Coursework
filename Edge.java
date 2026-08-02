public class Edge {

    Location destination;
    double distance;


    public Edge(Location destination, double distance){

        this.destination = destination;
        this.distance = distance;

    }

    public Location getDestination() {
        return destination;
    }

    public double getDistance() {
        return distance;
    }
}