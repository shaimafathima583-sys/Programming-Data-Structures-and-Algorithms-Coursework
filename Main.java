public class Main {

    public static void main(String[] args) {


        // =====================================
        // 1. Create District Graph
        // =====================================

        DistrictGraph colomboDistrict = new DistrictGraph();



        // =====================================
        // 2. Create Locations (Nodes)
        // =====================================

        Location colomboFort = new Location(
                "Colombo Fort",
                "Colombo",
                750000,
                1.5,
                0.8,
                0.9,
                6.9344,
                79.8428
        );


        Location pettah = new Location(
                "Pettah",
                "Colombo",
                500000,
                1.3,
                0.9,
                0.8,
                6.9360,
                79.8500
        );


        Location maradana = new Location(
                "Maradana",
                "Colombo",
                300000,
                1.2,
                0.6,
                0.7,
                6.9271,
                79.8650
        );


        Location dehiwala = new Location(
                "Dehiwala",
                "Colombo",
                600000,
                1.4,
                0.5,
                0.85,
                6.8528,
                79.8650
        );



        // =====================================
        // 3. Add Locations to Graph
        // =====================================

        colomboDistrict.addLocation(colomboFort);

        colomboDistrict.addLocation(pettah);

        colomboDistrict.addLocation(maradana);

        colomboDistrict.addLocation(dehiwala);



        // =====================================
        // 4. Add Roads (Edges)
        // =====================================

        colomboDistrict.addEdge(
                colomboFort,
                pettah,
                2
        );


        colomboDistrict.addEdge(
                colomboFort,
                maradana,
                3
        );


        colomboDistrict.addEdge(
                pettah,
                dehiwala,
                8
        );


        colomboDistrict.addEdge(
                maradana,
                dehiwala,
                6
        );



        // =====================================
        // 5. Display Graph
        // =====================================

        System.out.println(
                "\n===== DISTRICT ROAD GRAPH ====="
        );

        colomboDistrict.displayGraph();




        // =====================================
        // 6. Display Location Details
        // =====================================

        System.out.println(
                "\n===== LOCATION DETAILS ====="
        );


        colomboFort.displayDetails();

        System.out.println();

        pettah.displayDetails();

        System.out.println();

        maradana.displayDetails();

        System.out.println();

        dehiwala.displayDetails();




        // =====================================
        // 7. Opportunity Score Calculation
        // =====================================

        OpportunityCalculator calculator =
                new OpportunityCalculator();



        System.out.println(
                "\n===== OPPORTUNITY SCORES ====="
        );


        System.out.println(
                colomboFort.getName()
                + " Score : "
                + calculator.calculateScore(colomboFort)
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