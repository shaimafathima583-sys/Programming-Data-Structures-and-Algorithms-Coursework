package com.pdsa.recommendation_tool.osm;

import java.util.ArrayList;
import java.util.List;

public class MiniJsonParser {

    public static List<String> extractElements(String json) {

        List<String> elements = new ArrayList<>();

        if (json == null || json.isEmpty()) {
            return elements;
        }

        int elementsStart = json.indexOf("\"elements\"");

        if (elementsStart == -1) {
            return elements;
        }

        int arrayStart = json.indexOf("[", elementsStart);
        int arrayEnd = json.lastIndexOf("]");

        if (arrayStart == -1 || arrayEnd == -1) {
            return elements;
        }

        String elementsJson =
                json.substring(arrayStart + 1, arrayEnd);

        int objectStart = -1;
        int braceCount = 0;

        for (int i = 0; i < elementsJson.length(); i++) {

            char character = elementsJson.charAt(i);

            if (character == '{') {

                if (braceCount == 0) {
                    objectStart = i;
                }

                braceCount++;

            } else if (character == '}') {

                braceCount--;

                if (braceCount == 0 && objectStart != -1) {

                    String object =
                            elementsJson.substring(
                                    objectStart,
                                    i + 1
                            );

                    elements.add(object);

                    objectStart = -1;
                }
            }
        }

        return elements;
    }

    public static String getValue(
            String json,
            String key) {

        String searchKey = "\"" + key + "\"";

        int keyPosition = json.indexOf(searchKey);

        if (keyPosition == -1) {
            return null;
        }

        int colonPosition =
                json.indexOf(":", keyPosition);

        if (colonPosition == -1) {
            return null;
        }

        int valueStart = colonPosition + 1;

        while (valueStart < json.length()
                && Character.isWhitespace(
                json.charAt(valueStart))) {

            valueStart++;
        }

        if (valueStart >= json.length()) {
            return null;
        }

        // String value
        if (json.charAt(valueStart) == '"') {

            int valueEnd =
                    json.indexOf(
                            "\"",
                            valueStart + 1
                    );

            if (valueEnd == -1) {
                return null;
            }

            return json.substring(
                    valueStart + 1,
                    valueEnd
            );
        }

        // Number / boolean / other simple value
        int valueEnd = valueStart;

        while (valueEnd < json.length()
                && json.charAt(valueEnd) != ','
                && json.charAt(valueEnd) != '}') {

            valueEnd++;
        }

        return json.substring(
                valueStart,
                valueEnd
        ).trim();
    }
}