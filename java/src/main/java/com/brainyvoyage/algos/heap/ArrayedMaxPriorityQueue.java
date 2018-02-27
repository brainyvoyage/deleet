package com.brainyvoyage.algos.heap;

public class ArrayedMaxPriorityQueue<Key extends Comparable<Key>> {
    private Key[] priorityQueue;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public ArrayedMaxPriorityQueue(int capacity) {
        // index 0 is unused and heap located between 1 - N
        this.priorityQueue = (Key[]) new Comparable[capacity + 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void insert(Key key) {
        priorityQueue[++size] = key;
        bottomUpReHeapify(size);
    }

    public Key deleteMax() {
        Key max = priorityQueue[1];
        swap(1, size--);
        priorityQueue[size + 1] = null;
        topBottomHeapify(1);
        return max;
    }

    private void bottomUpReHeapify(int index) {
        int parentIndex = parent(index);
        while (index > 1 && lessThan(parentIndex, index)) {
            swap(parentIndex, index);
            index = parentIndex;
            parentIndex = parent(index);
        }
    }

    private void topBottomHeapify(int index) {
        int leftChild = leftChild(index);
        while(leftChild <= size) {
            int swapIndex = leftChild;
            int rightChild = rightChild(index);
            if (leftChild < size && lessThan(leftChild, rightChild))
                swapIndex = rightChild;
            if (!lessThan(index, swapIndex)) break;
            swap(index, swapIndex);
            index = swapIndex;
        }
    }

    private void swap(int from, int to) {
        Key temp = priorityQueue[to];
        priorityQueue[to] = priorityQueue[from];
        priorityQueue[from] = temp;
    }

    private boolean lessThan(int lhs, int rhs) {
        return priorityQueue[lhs].compareTo(priorityQueue[rhs]) < 0;
    }

    private int leftChild(int index) {
        return 2 * index;
    }

    private int rightChild(int index) {
        return 2 * index + 1;
    }

    private int parent(int index) {
        return index/2;
    }
}
