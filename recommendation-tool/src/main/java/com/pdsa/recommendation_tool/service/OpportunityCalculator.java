package com.pdsa.recommendation_tool.service;

import com.pdsa.recommendation_tool.model.Location;
import com.pdsa.recommendation_tool.model.Province;
import com.pdsa.recommendation_tool.graph.MaxHeap;

import java.util.ArrayList;
import java.util.List;

public class OpportunityCalculator {

    // Calculate score for a Location
    public static double calculateScore(Location location) {

        double populationScore =
                (location.getPopulation() / 150000.0) * 10;

        double purchasingScore =
                location.getPurchasingPower();

        double facilitiesScore =
                location.getFacilities();

        double competitionScore =
                location.getCompetition();

        double score =
                (populationScore * 0.30)
                + (purchasingScore * 0.35)
                + (facilitiesScore * 0.25)
                - (competitionScore * 0.10);

        return Math.round(score * 100.0) / 100.0;
    }

    // Calculate score for a Province
    public static double calculateScore(Province province) {

        double populationScore =
                (province.getPopulation() / 2500000.0) * 10;

        double purchasingScore =
                province.getPurchasingPower();

        double facilitiesScore =
                province.getFacilitiesScore();

        double competitionScore =
                province.getCompetitionLevel();

        double score =
                (populationScore * 0.30)
                + (purchasingScore * 0.35)
                + (facilitiesScore * 0.25)
                - (competitionScore * 0.10);

        return Math.round(score * 100.0) / 100.0;
    }

    // Rank Locations using MaxHeap
    public static void rankLocations(List<Location> locations) {

        MaxHeap maxHeap = new MaxHeap();

        // Insert every location and its score into MaxHeap
        for (int i = 0; i < locations.size(); i++) {

            double score = calculateScore(locations.get(i));

            maxHeap.insert(i, score);
        }

        // Create a new list for ranked locations
        List<Location> rankedLocations = new ArrayList<>();

        // Extract highest score first
        while (!maxHeap.isEmpty()) {

            MaxHeap.Node node = maxHeap.extractMax();

            Location location = locations.get(node.vertex);

            rankedLocations.add(location);
        }

        // Replace original list with ranked list
        locations.clear();
        locations.addAll(rankedLocations);
    }

    // Rank Provinces using MaxHeap
    public static void rankProvinces(List<Province> provinces) {

        MaxHeap maxHeap = new MaxHeap();

        // Insert every province and its score into MaxHeap
        for (int i = 0; i < provinces.size(); i++) {

            double score = calculateScore(provinces.get(i));

            maxHeap.insert(i, score);
        }

        // Create a new list for ranked provinces
        List<Province> rankedProvinces = new ArrayList<>();

        // Extract highest score first
        while (!maxHeap.isEmpty()) {

            MaxHeap.Node node = maxHeap.extractMax();

            Province province = provinces.get(node.vertex);

            rankedProvinces.add(province);
        }

        // Replace original list with ranked list
        provinces.clear();
        provinces.addAll(rankedProvinces);
    }
}