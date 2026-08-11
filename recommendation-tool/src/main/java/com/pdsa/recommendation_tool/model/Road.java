package com.pdsa.recommendation_tool.model;

import java.util.Objects;

public class Road<T> {

    private final T destination;
    private final double distance;

    public Road(T destination, double distance) {
        this.destination = destination;
        this.distance = distance;
    }

    public T getDestination() {
        return destination;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Road{destination=" + destination + ", distance=" + distance + "km}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Road<?> road)) return false;
        return Double.compare(road.distance, distance) == 0 && Objects.equals(destination, road.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination, distance);
    }
}
