public class MinHeap {

    private Location[] locations;
    private int[] distances;
    private int size;

    public MinHeap(int capacity) {
        locations = new Location[capacity];
        distances = new int[capacity];
        size = 0;
    }

    // Insert into heap
    public void insert(Location location, int distance) {

        locations[size] = location;
        distances[size] = distance;

        int current = size;

        while (current > 0 &&
                distances[current] < distances[(current - 1) / 2]) {

            // Swap distance
            int tempDistance = distances[current];
            distances[current] = distances[(current - 1) / 2];
            distances[(current - 1) / 2] = tempDistance;

            // Swap location
            Location tempLocation = locations[current];
            locations[current] = locations[(current - 1) / 2];
            locations[(current - 1) / 2] = tempLocation;

            current = (current - 1) / 2;
        }

        size++;
    }

    // Remove minimum
    public Location removeMin() {

        if (size == 0)
            return null;

        Location minLocation = locations[0];

        locations[0] = locations[size - 1];
        distances[0] = distances[size - 1];

        size--;

        heapify(0);

        return minLocation;
    }

    private void heapify(int index) {

        int smallest = index;

        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size && distances[left] < distances[smallest]) {
            smallest = left;
        }

        if (right < size && distances[right] < distances[smallest]) {
            smallest = right;
        }

        if (smallest != index) {

            int tempDistance = distances[index];
            distances[index] = distances[smallest];
            distances[smallest] = tempDistance;

            Location tempLocation = locations[index];
            locations[index] = locations[smallest];
            locations[smallest] = tempLocation;

            heapify(smallest);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }
}