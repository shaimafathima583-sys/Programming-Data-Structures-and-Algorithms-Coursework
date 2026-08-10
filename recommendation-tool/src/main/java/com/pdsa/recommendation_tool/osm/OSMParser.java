package com.pdsa.recommendation_tool.osm;

import java.util.ArrayList;
import java.util.List;

public class OSMParser {

    public static class OSMPlace {

        private String name;
        private String type;
        private double latitude;
        private double longitude;

        public OSMPlace(
                String name,
                String type,
                double latitude,
                double longitude) {

            this.name = name;
            this.type = type;
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public double getLatitude() {
            return latitude;
        }

        public double getLongitude() {
            return longitude;
        }
    }

    public List<OSMPlace> parse(String json) {

        List<OSMPlace> places = new ArrayList<>();

        List<String> elements =
                MiniJsonParser.extractElements(json);

        for (String element : elements) {

            String latitudeText =
                    MiniJsonParser.getValue(
                            element,
                            "lat"
                    );

            String longitudeText =
                    MiniJsonParser.getValue(
                            element,
                            "lon"
                    );

            if (latitudeText == null
                    || longitudeText == null) {

                continue;
            }

            double latitude;
            double longitude;

            try {

                latitude =
                        Double.parseDouble(latitudeText);

                longitude =
                        Double.parseDouble(longitudeText);

            } catch (NumberFormatException e) {

                continue;
            }

            String name =
                    MiniJsonParser.getValue(
                            element,
                            "name"
                    );

            String type =
                    MiniJsonParser.getValue(
                            element,
                            "amenity"
                    );

            if (type == null) {

                type =
                        MiniJsonParser.getValue(
                                element,
                                "shop"
                        );
            }

            if (type == null) {
                type = "unknown";
            }

            if (name == null) {
                name = "Unnamed";
            }

            OSMPlace place =
                    new OSMPlace(
                            name,
                            type,
                            latitude,
                            longitude
                    );

            places.add(place);
        }

        return places;
    }
}