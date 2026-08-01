
public class Edge {

    Province destination;
    double distance;


    // Constructor
    public Edge(Province destination, double distance) {

        this.destination = destination;
        this.distance = distance;

    }


    // Getter for destination province
    public Province getDestination() {

        return destination;

    }


    // Getter for distance
    public double getDistance() {

        return distance;

    }

}