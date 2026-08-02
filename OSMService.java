import java.util.List;

public class OSMService {

    private static final double BOX_DEGREES = 0.01; // ~1km half-width

    private final OSMClient osmClient;

    public OSMService(OSMClient osmClient) { this.osmClient = osmClient; }

    public void enrich(List<Loc> locations) {

        for (Loc location : locations) {

            double south = location.getLatitude() - BOX_DEGREES;
            double north = location.getLatitude() + BOX_DEGREES;
            double west = location.getLongitude() - BOX_DEGREES;
            double east = location.getLongitude() + BOX_DEGREES;

            String query = osmClient.buildBoundingBoxQuery(south, west, north, east);
            String responseJson = osmClient.fetchData(query);

            if (responseJson == null || responseJson.isEmpty()) continue;

            int facilityCount = OSMParser.countFacilities(responseJson);
            int roadSegmentCount = OSMParser.countRoadSegments(responseJson);

            location.setFacilitiesScore(OSMParser.toFacilitiesScore(facilityCount, 30));
            location.setRoadAccessibility(OSMParser.toRoadAccessibilityScore(roadSegmentCount, 20));
        }
    }
}