package com.pdsa.recommendation_tool;

import com.pdsa.recommendation_tool.graph.Dijkstra;
import com.pdsa.recommendation_tool.graph.ProvinceGraph;
import com.pdsa.recommendation_tool.model.Province;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecommendationToolApplication {

    public static void main(String[] args) {

        SpringApplication.run(
                RecommendationToolApplication.class,
                args
        );

        // =========================
        // 1. Create Provinces
        // =========================

        Province western = new Province(
                "Western",
                6200000,
                85,
                90,
                75,
                6.9271,
                80.8612
        );

        Province central = new Province(
                "Central",
                2700000,
                70,
                80,
                50,
                7.2906,
                80.6337
        );

        Province southern = new Province(
                "Southern",
                2500000,
                65,
                75,
                45,
                6.0535,
                80.2210
        );

        Province eastern = new Province(
                "Eastern",
                1800000,
                60,
                70,
                40,
                7.8731,
                81.7718
        );

        // =========================
        // 2. Create Province Graph
        // =========================

        ProvinceGraph graph = new ProvinceGraph();

        graph.addProvince(western);
        graph.addProvince(central);
        graph.addProvince(southern);
        graph.addProvince(eastern);

        // =========================
        // 3. Add Province Connections
        // =========================

        graph.addEdge(western, central, 115);
        graph.addEdge(western, southern, 160);

        graph.addEdge(central, eastern, 250);
        graph.addEdge(southern, eastern, 300);

        // =========================
        // 4. Display Province Graph
        // =========================

        System.out.println();
        System.out.println("========== PROVINCE GRAPH ==========");

        graph.displayGraph();

        System.out.println("====================================");

        // =========================
        // 5. Run Dijkstra
        // =========================

        Dijkstra<Province> dijkstra = new Dijkstra<>();

        Map<Province, Double> distances =
                dijkstra.findShortestDistances(
                        graph.getAdjacencyList(),
                        western
                );

        // =========================
        // 6. Display Shortest Paths
        // =========================

        System.out.println();
        System.out.println(
                "===== SHORTEST DISTANCES FROM WESTERN ====="
        );

        for (Map.Entry<Province, Double> entry
                : distances.entrySet()) {

            System.out.println(
                    entry.getKey().getName()
                            + " : "
                            + entry.getValue()
                            + " km"
            );
        }

        System.out.println(
                "==========================================="
        );
    }
}