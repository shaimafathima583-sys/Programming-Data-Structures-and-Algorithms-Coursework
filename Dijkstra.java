import java.util.*;

public class Dijkstra {


    public static Map<Location, Integer> findShortestPath(
            Graph graph,
            Location start) {


        Map<Location, Integer> distances = new HashMap<>();


        // Set all distances as infinity
        for(Location location : graph.getGraph().keySet()) {

            distances.put(location, Integer.MAX_VALUE);

        }


        // Starting location distance = 0
        distances.put(start,0);



        MinHeap heap = new MinHeap(100);


        heap.insert(start,0);



        while(!heap.isEmpty()) {


            Location current = heap.removeMin();



            int currentDistance = distances.get(current);



            // Check all connected roads

            for(Edge edge : graph.getGraph().get(current)) {


                Location neighbour = edge.getDestination();


                int newDistance =
                        currentDistance + edge.getDistance();



                // If shorter path found

                if(newDistance < distances.get(neighbour)) {


                    distances.put(neighbour,newDistance);


                    heap.insert(neighbour,newDistance);

                }

            }

        }


        return distances;

    }

}