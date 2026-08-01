public class Main {

     public static void main(String[] args) {

        // Create District Graph
        DistrictGraph colomboDistrict = new DistrictGraph();


        // Create Locations (Nodes)
        Location colombo = new Location("Colombo", "Colombo", 750000, 1.5, 0.8, 0.9);
        Location pettah = new Location("Pettah", "Colombo", 50000, 1.2, 0.7, 0.8);
        Location maradana = new Location("Maradana", "Colombo", 100000, 1.3, 0.6, 0.7);
        Location dehiwala = new Location("Dehiwala", "Colombo", 200000, 1.4, 0.5, 0.6); 


        // Add Locations to Graph
        colomboDistrict.addLocation(colombo);
        colomboDistrict.addLocation(pettah);
        colomboDistrict.addLocation(maradana);
        colomboDistrict.addLocation(dehiwala);


        // Add Roads (Edges)
        colomboDistrict.addEdge(colombo, pettah, 2);
        colomboDistrict.addEdge(colombo, maradana, 3);
        colomboDistrict.addEdge(pettah, dehiwala, 8);
        colomboDistrict.addEdge(maradana, dehiwala, 6);


        // Display Graph
        colomboDistrict.displayGraph();

    }
    
}
