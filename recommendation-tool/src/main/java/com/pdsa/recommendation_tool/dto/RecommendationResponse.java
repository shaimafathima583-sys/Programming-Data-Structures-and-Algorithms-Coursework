package com.pdsa.recommendation_tool.dto;

public class RecommendationResponse {

    private String currentLocation;
    private String currentProvince;

    private String recommendedProvince;
    private double provinceScore;
    private double provinceDistance;

    private String recommendedDistrict;
    private double districtScore;
    private double districtDistance;


    public RecommendationResponse(
            String currentLocation,
            String currentProvince,
            String recommendedProvince,
            double provinceScore,
            double provinceDistance,
            String recommendedDistrict,
            double districtScore,
            double districtDistance) {

        this.currentLocation = currentLocation;
        this.currentProvince = currentProvince;
        this.recommendedProvince = recommendedProvince;
        this.provinceScore = provinceScore;
        this.provinceDistance = provinceDistance;
        this.recommendedDistrict = recommendedDistrict;
        this.districtScore = districtScore;
        this.districtDistance = districtDistance;
    }


    public String getCurrentLocation() {
        return currentLocation;
    }

    public String getCurrentProvince() {
        return currentProvince;
    }

    public String getRecommendedProvince() {
        return recommendedProvince;
    }

    public double getProvinceScore() {
        return provinceScore;
    }

    public double getProvinceDistance() {
        return provinceDistance;
    }

    public String getRecommendedDistrict() {
        return recommendedDistrict;
    }

    public double getDistrictScore() {
        return districtScore;
    }

    public double getDistrictDistance() {
        return districtDistance;
    }
}