package com.pdsa.recommendation_tool.model;

public class Location {

    private String name;
    private String district;
    private String province;

    private int population;
    private double purchasingPower;
    private double competitionLevel;
    private double facilitiesScore;

    private double latitude;
    private double longitude;

    private double roadAccessibility;
    private double customerDensity;

    public Location(String name, String district, String province,
                    int population, double purchasingPower,
                    double competitionLevel, double facilitiesScore,
                    double latitude, double longitude,
                    double roadAccessibility, double customerDensity) {

        this.name = name;
        this.district = district;
        this.province = province;
        this.population = population;
        this.purchasingPower = purchasingPower;
        this.competitionLevel = competitionLevel;
        this.facilitiesScore = facilitiesScore;
        this.latitude = latitude;
        this.longitude = longitude;
        this.roadAccessibility = roadAccessibility;
        this.customerDensity = customerDensity;
    }

    public String getName() {
        return name;
    }

    public String getDistrict() {
        return district;
    }

    public String getProvince() {
        return province;
    }

    public int getPopulation() {
        return population;
    }

    public double getPurchasingPower() {
        return purchasingPower;
    }

    public double getCompetitionLevel() {
        return competitionLevel;
    }

    public double getFacilitiesScore() {
        return facilitiesScore;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getRoadAccessibility() {
        return roadAccessibility;
    }

    public double getCustomerDensity() {
        return customerDensity;
    }

    public void setFacilitiesScore(double facilitiesScore) {
        this.facilitiesScore = facilitiesScore;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Location)) {
            return false;
        }

        Location location = (Location) o;
        return name.equals(location.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}