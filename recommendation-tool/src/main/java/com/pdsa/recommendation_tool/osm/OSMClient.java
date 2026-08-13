package com.pdsa.recommendation_tool.osm;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OSMClient {

    private static final String OVERPASS_URL = "https://overpass-api.de/api/interpreter";
    private final HttpClient httpClient;

    public OSMClient() {
        httpClient = HttpClient.newHttpClient();
    }

    public String fetchData(double latitude, double longitude,int radius) {

        String query = buildQuery(latitude,longitude,radius);

        try {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(OVERPASS_URL))
                    .header("Content-Type","application/x-www-form-urlencoded")
                    .header("User-Agent","PDSA-Recommendation-Tool")
                    .POST(HttpRequest.BodyPublishers.ofString("data=" + URLEncoder
                    .encode(query, StandardCharsets.UTF_8)))
                    .build();

            HttpResponse<String> response =httpClient.send(request,HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                  return response.body();
            } else {
                System.out.println( "OSM request failed. Status: " + response.statusCode());
                System.out.println("Response body: " + response.body()); 
                return null;
            }

        } catch (IOException | InterruptedException e) {

            System.out.println(
                    "Error while connecting to Overpass API: "
                    + e.getMessage()
            );

            return null;
        }
    }

    private String buildQuery(double latitude,
                              double longitude,
                              int radius) {

        return "[out:json];"
                + "("

                // Schools
                + "node[\"amenity\"=\"school\"]"
                + "(around:"
                + radius + ","
                + latitude + ","
                + longitude + ");"

                // Hospitals
                + "node[\"amenity\"=\"hospital\"]"
                + "(around:"
                + radius + ","
                + latitude + ","
                + longitude + ");"

                // Banks
                + "node[\"amenity\"=\"bank\"]"
                + "(around:"
                + radius + ","
                + latitude + ","
                + longitude + ");"

                // Supermarkets
                + "node[\"shop\"=\"supermarket\"]"
                + "(around:"
                + radius + ","
                + latitude + ","
                + longitude + ");"

                // Restaurants
                + "node[\"amenity\"=\"restaurant\"]"
                + "(around:"
                + radius + ","
                + latitude + ","
                + longitude + ");"

                // Cafes
                + "node[\"amenity\"=\"cafe\"]"
                + "(around:"
                + radius + ","
                + latitude + ","
                + longitude + ");"
                // Pharmacies
                + "node[\"amenity\"=\"pharmacy\"] (around:" + radius + "," + latitude + "," + longitude + ");"

                // ATMs
                + "node[\"amenity\"=\"atm\"] (around:" + radius + "," + latitude + "," + longitude + ");"

                // Fuel stations
                + "node[\"amenity\"=\"fuel\"] (around:" + radius + "," + latitude + "," + longitude + ");"

                + ");"
                + "out;";
    }
}