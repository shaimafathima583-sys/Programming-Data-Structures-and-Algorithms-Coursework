public class Location {

    String name;
    String district;

    int population;
    double purchasingPower;
    double competition;
    double facilities;
    double latitude;
    double longitude;

    public Location(String name, String district, double latitude, double longitude, int population, double purchasingPower, double competition, double facilities) {
    

        this.name = name;
        this.district = district;
        this.population = population;
        this.purchasingPower = purchasingPower;
        this.competition = competition;
        this.facilities = facilities;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public String toString(){
        return name;
    }

    public String getName() {
        return name;
    }

    public String getDistrict() {
        return district;
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

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void displayDetails() {

    System.out.println("Location Details");
    System.out.println("------------------------");

    System.out.println("Name              : " + name);
    System.out.println("District          : " + district);
    System.out.println("Population        : " + population);

    System.out.println("Purchasing Power  : " + purchasingPower);
    System.out.println("Competition Level : " + competition);
    System.out.println("Facilities Score  : " + facilities);

    System.out.println("Latitude          : " + latitude);
    System.out.println("Longitude         : " + longitude);

    System.out.println("------------------------");
}
}