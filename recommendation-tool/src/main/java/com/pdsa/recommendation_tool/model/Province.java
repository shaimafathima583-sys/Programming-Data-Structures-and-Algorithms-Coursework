package com.pdsa.recommendation_tool.model;

public class Province {

    private String name;

    private int population;
    private double purchasingPower;
    private double facilitiesScore;
    private double competitionLevel;

    public Province(String name,
                    int population,
                    double purchasingPower,
                    double facilitiesScore,
                    double competitionLevel) {

        this.name = name;
        this.population = population;
        this.purchasingPower = purchasingPower;
        this.facilitiesScore = facilitiesScore;
        this.competitionLevel = competitionLevel;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public double getPurchasingPower() {
        return purchasingPower;
    }

    public double getFacilitiesScore() {
        return facilitiesScore;
    }

    public double getCompetitionLevel() {
        return competitionLevel;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Province)) return false;

        Province province = (Province) o;
        return name.equals(province.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}