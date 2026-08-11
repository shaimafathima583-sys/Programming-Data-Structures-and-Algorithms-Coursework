package com.pdsa.recommendation_tool.graph;

public class MinHeap<T> {

    private T[] items;
    private double[] distances;
    private int size;

    // Constructor
    @SuppressWarnings("unchecked")
    public MinHeap(int capacity) {
        items = (T[]) new Object[capacity];
        distances = new double[capacity];
        size = 0;
    }

    // Check whether heap is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Insert an item with its distance
    public void insert(T item, double distance) {

        if (size == items.length) {
            grow();
        }

        items[size] = item;
        distances[size] = distance;

        int current = size;

        // Move the item upward
        while (current > 0) {

            int parent = (current - 1) / 2;

            // Parent is already smaller
            if (distances[parent] <= distances[current]) {
                break;
            }

            // Swap with parent
            swap(current, parent);

            current = parent;
        }

        size++;
    }

    // Remove and return the item with the smallest distance
    public T removeMin() {

        if (isEmpty()) {
            return null;
        }

        T minItem = items[0];

        // Move the last item to the root
        items[0] = items[size - 1];
        distances[0] = distances[size - 1];

        size--;

        // Fix the heap
        heapifyDown(0);

        return minItem;
    }

    // Move an item downward until the heap is correct
    private void heapifyDown(int index) {

        while (true) {

            int left = 2 * index + 1;
            int right = 2 * index + 2;

            int smallest = index;

            // Check left child
            if (left < size &&
                    distances[left] < distances[smallest]) {

                smallest = left;
            }

            // Check right child
            if (right < size &&
                    distances[right] < distances[smallest]) {

                smallest = right;
            }

            // Current item is already the smallest
            if (smallest == index) {
                break;
            }

            // Swap with the smaller child
            swap(index, smallest);

            // Continue from the new position
            index = smallest;
        }
    }

    // Swap two items and their distances
    private void swap(int first, int second) {

        T tempItem = items[first];
        items[first] = items[second];
        items[second] = tempItem;

        double tempDistance = distances[first];
        distances[first] = distances[second];
        distances[second] = tempDistance;
    }

    // Increase the size of the arrays
    @SuppressWarnings("unchecked")
    private void grow() {

        T[] newItems = (T[]) new Object[items.length * 2];
        double[] newDistances = new double[distances.length * 2];

        for (int i = 0; i < size; i++) {
            newItems[i] = items[i];
            newDistances[i] = distances[i];
        }

        items = newItems;
        distances = newDistances;
    }
}