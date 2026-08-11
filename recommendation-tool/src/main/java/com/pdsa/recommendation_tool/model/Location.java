package com.pdsa.recommendation_tool.model;

public class Location {

    private String name;
    private String district;
    private String province;

    private int population;
    private double purchasingPower;
    private double competition;
    private double facilities;

    private double roadAccess;
    private double customerDensity;

    private int numBusinesses;
    private double avgIncome;

    private double latitude;
    private double longitude;

    public Location(
            String name,
            String district,
            String province,
            int population,
            double purchasingPower,
            double competition,
            double facilities,
            double roadAccess,
            double customerDensity,
            int numBusinesses,
            double avgIncome,
            double latitude,
            double longitude) {

        this.name = name;
        this.district = district;
        this.province = province;
        this.population = population;
        this.purchasingPower = purchasingPower;
        this.competition = competition;
        this.facilities = facilities;
        this.roadAccess = roadAccess;
        this.customerDensity = customerDensity;
        this.numBusinesses = numBusinesses;
        this.avgIncome = avgIncome;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public double getCompetition() {
        return competition;
    }

    public double getFacilities() {
        return facilities;
    }

    public double getRoadAccess() {
        return roadAccess;
    }

    public double getCustomerDensity() {
        return customerDensity;
    }

    public int getNumBusinesses() {
        return numBusinesses;
    }

    public double getAvgIncome() {
        return avgIncome;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return name + " (" + district + ", " + province + ")";
    }
}