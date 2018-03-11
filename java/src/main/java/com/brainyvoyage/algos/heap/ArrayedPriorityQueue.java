package com.brainyvoyage.algos.heap;

public class ArrayedPriorityQueue<Key extends Comparable<Key>> {
    Key[] priorityQueue;
    protected int size = 0;
    private boolean maxPq;
    @SuppressWarnings("unchecked")
    public ArrayedPriorityQueue(int capacity) {
        // index 0 is unused and heap located between 1 - N
        this.priorityQueue = (Key[]) new Comparable[capacity + 1];
        this.maxPq = true;
    }

    @SuppressWarnings("unchecked")
    public ArrayedPriorityQueue(int capacity, boolean maxPq) {
        this(capacity);
        this.maxPq = maxPq;
    }

    public ArrayedPriorityQueue(int capacity, Iterable<Key> items, boolean maxPq) {
        this(capacity);
        this.maxPq = maxPq;
        for(Key key: items) {
            insert(key);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void insert(Key key) {
        if (size < priorityQueue.length - 1) {
            priorityQueue[++size] = key;
            bottomUpReHeapify(size);
        } else if(compare(key, priorityQueue[1])) {

            System.out.println(String.format
                    ("Queue at full capacity. Deleting %s key = %s",
                            maxPq ? "max" : "min",
                            delete().toString())
            );
            priorityQueue[++size] = key;
            bottomUpReHeapify(size);
        } else {
            System.out.println(String.format
                    ("The input %s is %s than %s. Ignoring the input",
                            key, maxPq ? "larger" : "smaller",
                            priorityQueue[1])
            );
        }
    }

    public Key delete() {
        Key max = priorityQueue[1];
        swap(1, size--);
        priorityQueue[size + 1] = null;
        topBottomHeapify(1);
        return max;
    }

    void bottomUpReHeapify(int index) {
        int parentIndex = parent(index);
        while (index > 1 && compare(parentIndex, index)) {
            swap(parentIndex, index);
            index = parentIndex;
            parentIndex = parent(index);
        }
    }

    void topBottomHeapify(int index) {
        while(leftChild(index) <= size) {
            // Initially choose left child as to check if
            // it violates the heap property
            int swapIndex = leftChild(index);

            // Figure out if to swap with left or right child
            int rightChild = rightChild(index);
            if (swapIndex < size && compare(swapIndex, rightChild))
                swapIndex = rightChild;

            // Compare with the parent to see if larger child is
            // violating the heap property, break if it doesn't
            if (!compare(index, swapIndex)) break;

            // Swap child and parent
            swap(index, swapIndex);
            index = swapIndex;
        }
    }


    void swap(int from, int to) {
        Key temp = priorityQueue[to];
        priorityQueue[to] = priorityQueue[from];
        priorityQueue[from] = temp;
    }

    protected boolean compare(int lhs, int rhs) {
        return this.maxPq ?
                priorityQueue[lhs].compareTo(priorityQueue[rhs]) < 0 :
                priorityQueue[lhs].compareTo(priorityQueue[rhs]) > 0;
    }

    protected boolean compare(Key lhs, Key rhs) {
        return this.maxPq ?
                lhs.compareTo(rhs) < 0 :
                lhs.compareTo(rhs) > 0;
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

    public void show(){
        for(int i = 1; i <= size; i++){
            System.out.print(priorityQueue[i] + " ");
        }
        System.out.println();
    }
}
