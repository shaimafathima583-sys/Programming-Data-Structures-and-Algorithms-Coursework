package com.pdsa.recommendation_tool.service;

import com.pdsa.recommendation_tool.model.Location;
import com.pdsa.recommendation_tool.osm.OSMCache;
import com.pdsa.recommendation_tool.osm.OSMClient;

public class OSMEnrichment {

    private final OSMClient osmClient;
    private final OSMCache osmCache;

    private static final int SEARCH_RADIUS = 5000;

    public OSMEnrichment() {

        this.osmClient = new OSMClient();
        this.osmCache = new OSMCache();
    }

    public String getOSMData(Location location) {

        double latitude = location.getLatitude();
        double longitude = location.getLongitude();

        // 1. Check persistent cache
        if (osmCache.isValid(
                latitude,
                longitude,
                SEARCH_RADIUS)) {

            System.out.println(
                    "Using cached OSM data for "
                    + location.getName()
            );

            return osmCache.read(
                    latitude,
                    longitude,
                    SEARCH_RADIUS
            );
        }

        // 2. Cache missing or expired
        System.out.println(
                "Fetching OSM data for "
                + location.getName()
        );

        String json = osmClient.fetchData(
                latitude,
                longitude,
                SEARCH_RADIUS
        );

        // 3. Save for future runs
        if (json != null) {

            osmCache.save(
                    latitude,
                    longitude,
                    SEARCH_RADIUS,
                    json
            );
        }

        return json;
    }
}