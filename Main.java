public class Main {

    public static void main(String[] args) {


        // ============================
        // 1. Create District Graph
        // ============================

        DistrictGraph colomboDistrict = new DistrictGraph();



        // ============================
        // 2. Create Locations
        // ============================

        Location colombo = new Location(
                "Colombo Fort",
                "Colombo",
                750000,
                1.5,
                0.8,
                0.9
        );


        Location pettah = new Location(
                "Pettah",
                "Colombo",
                500000,
                1.3,
                0.9,
                0.8
        );


        Location maradana = new Location(
                "Maradana",
                "Colombo",
                300000,
                1.2,
                0.6,
                0.7
        );


        Location dehiwala = new Location(
                "Dehiwala",
                "Colombo",
                600000,
                1.4,
                0.5,
                0.85
        );


        // ============================
        // 3. Add Locations to Graph
        // ============================

        colomboDistrict.addLocation(colombo);
        colomboDistrict.addLocation(pettah);
        colomboDistrict.addLocation(maradana);
        colomboDistrict.addLocation(dehiwala);



        // ============================
        // 4. Add Roads (Edges)
        // ============================

        colomboDistrict.addEdge(colombo, pettah, 2);

        colomboDistrict.addEdge(colombo, maradana, 3);

        colomboDistrict.addEdge(pettah, dehiwala, 8);

        colomboDistrict.addEdge(maradana, dehiwala, 6);



        // ============================
        // 5. Display Graph
        // ============================

        System.out.println("===== Colombo District Graph =====");

        colomboDistrict.displayGraph();



        // ============================
        // 6. Test Opportunity Score
        // ============================

        OpportunityCalculator calculator = new OpportunityCalculator();


        System.out.println("\n===== Opportunity Scores =====");


        System.out.println(
                colombo.getName() 
                + " Score : "
                + calculator.calculateScore(colombo)
        );


        System.out.println(
                pettah.getName()
                + " Score : "
                + calculator.calculateScore(pettah)
        );


        System.out.println(
                maradana.getName()
                + " Score : "
                + calculator.calculateScore(maradana)
        );


        System.out.println(
                dehiwala.getName()
                + " Score : "
                + calculator.calculateScore(dehiwala)
        );

    }

}