package com.pdsa.recommendation_tool.service;

public class DistanceCalculator {

    // Earth's radius in kilometres
    private static final double EARTH_RADIUS_KM = 6371.0;

    /**
     * Calculates the geographical distance between two
     * latitude/longitude coordinates using the Haversine formula.
     *
     * @return distance in kilometres
     */
    public static double calculateDistance(
            double latitude1,
            double longitude1,
            double latitude2,
            double longitude2) {

        // Convert latitude and longitude from degrees to radians
        double lat1 = Math.toRadians(latitude1);
        double lat2 = Math.toRadians(latitude2);

        double deltaLatitude =
                Math.toRadians(latitude2 - latitude1);

        double deltaLongitude =
                Math.toRadians(longitude2 - longitude1);

        // Haversine formula
        double a =
                Math.sin(deltaLatitude / 2)
                        * Math.sin(deltaLatitude / 2)
                + Math.cos(lat1)
                        * Math.cos(lat2)
                        * Math.sin(deltaLongitude / 2)
                        * Math.sin(deltaLongitude / 2);

        double c =
                2 * Math.atan2(
                        Math.sqrt(a),
                        Math.sqrt(1 - a)
                );

        // Calculate distance in kilometres
        double distance =
                EARTH_RADIUS_KM * c;

        // Round to 2 decimal places
        return Math.round(distance * 100.0) / 100.0;
    }
}