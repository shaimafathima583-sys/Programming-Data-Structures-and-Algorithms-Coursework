public class Location {

    String name;
    String district;

    int population;
    double purchasingPower;
    double competition;
    double facilities;

    double latitude;
    double longitude;

    public Location(String name, String district,double latitude,double longitude,int population,double purchasingPower,double competition,double facilities) {

        this.name = name;
        this.district = district;
        this.latitude = latitude;
        this.longitude = longitude;
        this.population = population;
        this.purchasingPower = purchasingPower;
        this.competition = competition;
        this.facilities = facilities;
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
    
     public double getLatitude(){
        return latitude;
    }


    public double getLongitude(){
        return longitude;
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
}