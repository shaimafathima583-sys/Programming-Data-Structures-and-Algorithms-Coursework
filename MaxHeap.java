public class MaxHeap {


    private Location[] locations;
    private double[] scores;

    private int size;



    public MaxHeap(int capacity) {

        locations = new Location[capacity];

        scores = new double[capacity];

        size = 0;

    }



    // Insert location with score

    public void insert(Location location, double score) {


        locations[size] = location;

        scores[size] = score;


        int current = size;



        // Move upward

        while(current > 0 &&
              scores[current] > scores[(current-1)/2]) {



            // Swap scores

            double tempScore = scores[current];

            scores[current] = scores[(current-1)/2];

            scores[(current-1)/2] = tempScore;



            // Swap locations

            Location tempLocation = locations[current];

            locations[current] = locations[(current-1)/2];

            locations[(current-1)/2] = tempLocation;



            current = (current-1)/2;

        }


        size++;

    }





    // Remove highest score

    public Location removeMax() {


        if(size == 0)

            return null;



        Location maxLocation = locations[0];



        locations[0] = locations[size-1];

        scores[0] = scores[size-1];



        size--;



        heapify(0);



        return maxLocation;

    }





    // Restore heap property

    private void heapify(int index) {



        int largest = index;



        int left = 2 * index + 1;

        int right = 2 * index + 2;



        if(left < size &&
           scores[left] > scores[largest]) {


            largest = left;

        }



        if(right < size &&
           scores[right] > scores[largest]) {


            largest = right;

        }



        if(largest != index) {



            double tempScore = scores[index];

            scores[index] = scores[largest];

            scores[largest] = tempScore;



            Location tempLocation = locations[index];

            locations[index] = locations[largest];

            locations[largest] = tempLocation;



            heapify(largest);

        }

    }



    public boolean isEmpty(){

        return size == 0;

    }

}