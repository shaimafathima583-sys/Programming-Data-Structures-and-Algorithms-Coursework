public class Main {

    public static void main(String[] args) {


        // Create Province Graph
        ProvinceGraph sriLankaGraph = new ProvinceGraph();



        // ==========================
        // Create Provinces (Nodes)
        // ==========================

        Province western = new Province(
                "Western Province",
                6200000
        );


        Province central = new Province(
                "Central Province",
                2700000
        );


        Province southern = new Province(
                "Southern Province",
                2500000
        );


        Province northern = new Province(
                "Northern Province",
                1100000
        );



        // ==========================
        // Add Provinces to Graph
        // ==========================

        sriLankaGraph.addProvince(western);

        sriLankaGraph.addProvince(central);

        sriLankaGraph.addProvince(southern);

        sriLankaGraph.addProvince(northern);



        // ==========================
        // Add Connections (Edges)
        // ==========================

        sriLankaGraph.addEdge(
                western,
                central,
                120
        );


        sriLankaGraph.addEdge(
                western,
                southern,
                160
        );


        sriLankaGraph.addEdge(
                central,
                northern,
                280
        );


        sriLankaGraph.addEdge(
                southern,
                central,
                190
        );



        // ==========================
        // Display Province Graph
        // ==========================

        System.out.println(
                "===== SRI LANKA PROVINCE GRAPH ====="
        );


        sriLankaGraph.displayGraph();



        // ==========================
        // Display Province Details
        // ==========================

        System.out.println(
                "===== PROVINCE DETAILS ====="
        );


        western.displayDetails();

        System.out.println();

        central.displayDetails();

        System.out.println();

        southern.displayDetails();

        System.out.println();

        northern.displayDetails();


    }

}