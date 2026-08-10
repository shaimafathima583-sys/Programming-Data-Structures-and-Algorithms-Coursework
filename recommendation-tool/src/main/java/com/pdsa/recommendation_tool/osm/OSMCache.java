package com.pdsa.recommendation_tool.osm;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class OSMCache {

    private static final String CACHE_DIRECTORY = "src/main/resources/osm-cache";
    private static final int DEFAULT_TTL_DAYS = 30;

    public OSMCache() {
        createCacheDirectory();
    }

    private void createCacheDirectory() {
        try {
            Files.createDirectories(Paths.get(CACHE_DIRECTORY));
        } catch (IOException e) {
            System.out.println("Could not create OSM cache directory.");
        }
    }

    public String getCacheKey(double latitude, double longitude, int radius) {

        double roundedLat = Math.round(latitude * 100.0) / 100.0;
        double roundedLng = Math.round(longitude * 100.0) / 100.0;

        return roundedLat + "_" + roundedLng + "_" + radius;
    }

    private Path getCacheFile(double latitude,double longitude,int radius) {
        String key = getCacheKey(latitude, longitude, radius);
        return Paths.get(CACHE_DIRECTORY, key + ".json");
    }

    public boolean exists(double latitude,double longitude,int radius) {
        return Files.exists(getCacheFile(latitude, longitude, radius));
    }

    public boolean isValid(double latitude,double longitude,int radius) {
        Path file = getCacheFile(latitude, longitude, radius);

        if (!Files.exists(file)) {
            return false;
        }
        try {

            Instant modifiedTime = Files.getLastModifiedTime(file).toInstant();
            Instant expiryTime = modifiedTime.plus(DEFAULT_TTL_DAYS, ChronoUnit.DAYS);
            return Instant.now().isBefore(expiryTime);
        } catch (IOException e) {
            return false;
        }
    }

    public String read(double latitude, double longitude,int radius) {
        
        Path file = getCacheFile(latitude, longitude, radius);
        try {
            return Files.readString(file,StandardCharsets.UTF_8);

        } catch (IOException e) {
            System.out.println("Could not read OSM cache: " + file);
            return null;
        }
    }

    public void save(double latitude,double longitude,int radius,String json) {
        Path file = getCacheFile(latitude,longitude,radius);

        try {
            Files.writeString(file,json,StandardCharsets.UTF_8);
            System.out.println("OSM data cached: " + file);
        } catch (IOException e) {
            System.out.println("Could not save OSM cache.");
        }
    }
}