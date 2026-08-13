package com.pdsa.recommendation_tool.dto;

import java.util.List;

public class RecommendationResponse {

    private String currentLocation;
    private double locationLatitude;
    private double locationLongitude;
    private String currentProvince;

    private String recommendedProvince;
    private double provinceScore;
    private double provinceDistance;

    private String recommendedDistrict;
    private double districtScore;
    private double districtDistance;
    private List<PlaceDto> nearbyPlaces;

    private String recommendedLocation;
    private double locationScore;
    private double locationDistance;
    
    public RecommendationResponse(String currentLocation,String currentProvince,String recommendedProvince,double provinceScore,double provinceDistance,String recommendedDistrict,
        double districtScore, double districtDistance,String recommendedLocation, double locationScore, double locationDistance,double locationLatitude, double locationLongitude,List<PlaceDto> nearbyPlaces) {

        this.currentLocation = currentLocation;
        this.currentProvince = currentProvince;
        this.recommendedProvince = recommendedProvince;
        this.provinceScore = provinceScore;
        this.provinceDistance = provinceDistance;
        this.recommendedDistrict = recommendedDistrict;
        this.districtScore = districtScore;
        this.districtDistance = districtDistance;
        this.recommendedLocation = recommendedLocation;
        this.locationScore = locationScore;
        this.locationDistance = locationDistance;
        this.nearbyPlaces = nearbyPlaces;
        this.locationLatitude = locationLatitude;
        this.locationLongitude = locationLongitude;
    }
    

    public String getRecommendedLocation() { return recommendedLocation; }
    public double getLocationScore() { return locationScore; }
    public double getLocationDistance() { return locationDistance; }
    public double getLocationLatitude() { return locationLatitude; }
    public double getLocationLongitude() { return locationLongitude; }

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
    public List<PlaceDto> getNearbyPlaces() {
    return nearbyPlaces;
}
}