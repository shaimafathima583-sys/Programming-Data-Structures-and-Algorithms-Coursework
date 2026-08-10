import java.util.ArrayList;
import java.util.List;

public class MinHeap {

    private final List<Node> heap;

    public static class Node {
        public int vertex;
        public double distance;

        public Node(int vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    public MinHeap() {
        heap = new ArrayList<>();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    public void insert(int vertex, double distance) {
        Node newNode = new Node(vertex, distance);
        heap.add(newNode);
        siftUp(heap.size() - 1);
    }

    public Node extractMin() {

        if (heap.isEmpty()) {
            return null;
        }

        Node minNode = heap.get(0);

        Node lastNode = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, lastNode);
            siftDown(0);
        }

        return minNode;
    }

    public Node peek() {

        if (heap.isEmpty()) {
            return null;
        }

        return heap.get(0);
    }

    private void siftUp(int index) {

        while (index > 0) {

            int parentIndex = (index - 1) / 2;

            if (heap.get(index).distance >=
                    heap.get(parentIndex).distance) {
                break;
            }

            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void siftDown(int index) {

        int size = heap.size();

        while (true) {

            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;

            int smallest = index;

            if (leftChild < size &&
                    heap.get(leftChild).distance <
                    heap.get(smallest).distance) {

                smallest = leftChild;
            }

            if (rightChild < size &&
                    heap.get(rightChild).distance <
                    heap.get(smallest).distance) {

                smallest = rightChild;
            }

            if (smallest == index) {
                break;
            }

            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int first, int second) {

        Node temp = heap.get(first);
        heap.set(first, heap.get(second));
        heap.set(second, temp);
    }
}