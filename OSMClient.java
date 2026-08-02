import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class OSMClient {

    private final String overpassURL;
    private final HttpClient httpClient;

    public OSMClient() {
        this.overpassURL = "https://overpass-api.de/api/interpreter";
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(15))
                .build();
    }

    public String fetchData(String query) {

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(overpassURL))
                    .timeout(Duration.ofSeconds(30))
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .POST(HttpRequest.BodyPublishers.ofString("data=" + query))
                    .build();

            HttpResponse<String> response =
                    httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                System.err.println("Overpass API returned status " + response.statusCode());
                return "";
            }
            return response.body();

        } catch (IOException | InterruptedException e) {
            System.err.println("Failed to fetch OSM data: " + e.getMessage());
            Thread.currentThread().interrupt();
            return "";
        }
    }

    public String buildBoundingBoxQuery(double south, double west, double north, double east) {
        return "[out:json][timeout:25];"
                + "("
                + "way[\"highway\"](" + south + "," + west + "," + north + "," + east + ");"
                + "node[\"amenity\"](" + south + "," + west + "," + north + "," + east + ");"
                + "node[\"shop\"](" + south + "," + west + "," + north + "," + east + ");"
                + ");"
                + "out body geom;";
    }
}