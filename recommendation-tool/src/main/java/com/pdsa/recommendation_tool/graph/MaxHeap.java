import java.util.ArrayList;
import java.util.List;

public class MaxHeap {

    private final List<Node> heap;

    public static class Node {

        public int vertex;
        public double score;

        public Node(int vertex, double score) {
            this.vertex = vertex;
            this.score = score;
        }
    }

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    public void insert(int vertex, double score) {
        Node newNode = new Node(vertex, score);
        heap.add(newNode);
        siftUp(heap.size() - 1);
    }

    public Node extractMax() {

        if (heap.isEmpty()) {
            return null;
        }

        Node maxNode = heap.get(0);
        Node lastNode = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, lastNode);
            siftDown(0);
        }

        return maxNode;
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

            if (heap.get(index).score <= heap.get(parentIndex).score) {
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
            int largest = index;

            if (leftChild < size &&
                    heap.get(leftChild).score > heap.get(largest).score) {
                largest = leftChild;
            }

            if (rightChild < size &&
                    heap.get(rightChild).score > heap.get(largest).score) {
                largest = rightChild;
            }

            if (largest == index) {
                break;
            }

            swap(index, largest);
            index = largest;
        }
    }

    private void swap(int first, int second) {

        Node temp = heap.get(first);
        heap.set(first, heap.get(second));
        heap.set(second, temp);
    }
}