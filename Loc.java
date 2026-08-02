public class Loc {

    private String name;
    private String district;
    private String province;

    private int population;
    private double purchasingPower;   // e.g. average disposable income index
    private double competitionLevel;  // 0 (no competition) - 10 (saturated)
    private double facilitiesScore;   // 0 - 10, derived from nearby schools/hospitals/malls etc.
    private double roadAccessibility; // 0 - 10, derived from road density / OSM data
    private double customerDensity;   // people per km^2 in the trade area

    private int numberOfBusinesses;
    private double averageIncome;

    private double latitude;
    private double longitude;

    public Loc(String name, String district, String province,
                     int population, double purchasingPower, double competitionLevel,
                     double facilitiesScore, double roadAccessibility, double customerDensity,
                     int numberOfBusinesses, double averageIncome,
                     double latitude, double longitude) {

        this.name = name;
        this.district = district;
        this.province = province;
        this.population = population;
        this.purchasingPower = purchasingPower;
        this.competitionLevel = competitionLevel;
        this.facilitiesScore = facilitiesScore;
        this.roadAccessibility = roadAccessibility;
        this.customerDensity = customerDensity;
        this.numberOfBusinesses = numberOfBusinesses;
        this.averageIncome = averageIncome;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Lightweight constructor, useful when only coordinates are known
    public Loc(String name, double latitude, double longitude) {
        this(name, "", "", 0, 0, 0, 0, 0, 0, 0, 0, latitude, longitude);
    }

    public String getName() { return name; }
    public String getDistrict() { return district; }
    public String getProvince() { return province; }

    public int getPopulation() { return population; }
    public double getPurchasingPower() { return purchasingPower; }
    public double getCompetitionLevel() { return competitionLevel; }
    public double getFacilitiesScore() { return facilitiesScore; }
    public double getRoadAccessibility() { return roadAccessibility; }
    public double getCustomerDensity() { return customerDensity; }

    public int getNumberOfBusinesses() { return numberOfBusinesses; }
    public double getAverageIncome() { return averageIncome; }

    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }

    public void setFacilitiesScore(double facilitiesScore) { this.facilitiesScore = facilitiesScore; }
    public void setRoadAccessibility(double roadAccessibility) { this.roadAccessibility = roadAccessibility; }

    @Override
    public String toString() { return name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Loc)) return false;
        return name.equals(((Loc) o).name);
    }

    @Override
    public int hashCode() { return name.hashCode(); }
}