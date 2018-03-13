package com.brainyvoyage.algos.heap;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IndexPriorityQueue<Key extends Comparable<Key>> implements Iterable<Integer> {
    private int capacity;       // maximum number of elements on PQ
    private int size;           // number of elements on PQ
    private int[] pq;           // binary heap using 1-based indexing
    private int[] indexOfPq;    // Maintains the index of "keys" in pq.
                                // i.e. indexOfPq[pq[i]] = pq[indexOfPq[i]] = i
    private Key[] keys;         // keys[i] = priority of i

    /**
     * Initializes an empty indexed priority queue with indices between {@code 0}
     * and {@code capacity - 1}.
     *
     * @param capacity the keys on this priority queue are index from {@code 0}
     *             {@code capacity - 1}
     * @throws IllegalArgumentException if {@code capacity < 0}
     */
    @SuppressWarnings("unchecked")
    public IndexPriorityQueue(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException();
        this.capacity = capacity;
        size = 0;
        keys = (Key[]) new Comparable[capacity + 1];         // make this of length capacity??
        pq = new int[capacity + 1];
        indexOfPq = new int[capacity + 1];                   // make this of length capacity??
        for (int i = 0; i <= capacity; i++)
            indexOfPq[i] = -1;
    }

    /**
     * Returns true if this priority queue is empty.
     *
     * @return {@code true} if this priority queue is empty;
     * {@code false} otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Is {@code i} an index on this priority queue?
     *
     * @param i an index
     * @return {@code true} if {@code i} is an index on this priority queue;
     * {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= i < capacity}
     */
    public boolean contains(int i) {
        if (i < 0 || i >= capacity) throw new IllegalArgumentException();
        return indexOfPq[i] != -1;
    }

    /**
     * Returns the number of keys on this priority queue.
     *
     * @return the number of keys on this priority queue
     */
    public int size() {
        return size;
    }

    /**
     * Associates key with index {@code i}.
     *
     * @param i   an index
     * @param key the key to associate with index {@code i}
     * @throws IllegalArgumentException unless {@code 0 <= i < capacity}
     * @throws IllegalArgumentException if there already is an item associated
     *                                  with index {@code i}
     */
    public void insert(int i, Key key) {
        if (i < 0 || i >= capacity) throw new IllegalArgumentException();
        if (contains(i)) throw new IllegalArgumentException("index is already in the priority queue");
        size++;
        indexOfPq[i] = size;
        pq[size] = i;
        keys[i] = key;
        swim(size);
    }

    /**
     * Returns an index associated with a minimum key.
     *
     * @return an index associated with a minimum key
     * @throws NoSuchElementException if this priority queue is empty
     */
    public int minIndex() {
        if (size == 0) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }

    /**
     * Returns a minimum key.
     *
     * @return a minimum key
     * @throws NoSuchElementException if this priority queue is empty
     */
    public Key minKey() {
        if (size == 0) throw new NoSuchElementException("Priority queue underflow");
        return keys[pq[1]];
    }

    /**
     * Removes a minimum key and returns its associated index.
     *
     * @return an index associated with a minimum key
     * @throws NoSuchElementException if this priority queue is empty
     */
    public int delMin() {
        if (size == 0) throw new NoSuchElementException("Priority queue underflow");
        int min = pq[1];
        exch(1, size--);
        sink(1);
        assert min == pq[size + 1];
        indexOfPq[min] = -1;        // delete
        keys[min] = null;    // to help with garbage collection
        pq[size + 1] = -1;        // not needed
        return min;
    }

    /**
     * Returns the key associated with index {@code i}.
     *
     * @param i the index of the key to return
     * @return the key associated with index {@code i}
     * @throws IllegalArgumentException unless {@code 0 <= i < capacity}
     * @throws NoSuchElementException   no key is associated with index {@code i}
     */
    public Key keyOf(int i) {
        if (i < 0 || i >= capacity) throw new IllegalArgumentException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        else return keys[i];
    }

    /**
     * Change the key associated with index {@code i} to the specified value.
     *
     * @param i   the index of the key to change
     * @param key change the key associated with index {@code i} to this key
     * @throws IllegalArgumentException unless {@code 0 <= i < capacity}
     * @throws NoSuchElementException   no key is associated with index {@code i}
     */
    public void changeKey(int i, Key key) {
        if (i < 0 || i >= capacity) throw new IllegalArgumentException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        keys[i] = key;
        swim(indexOfPq[i]);
        sink(indexOfPq[i]);
    }

    /**
     * Change the key associated with index {@code i} to the specified value.
     *
     * @param i   the index of the key to change
     * @param key change the key associated with index {@code i} to this key
     * @throws IllegalArgumentException unless {@code 0 <= i < capacity}
     * @deprecated Replaced by {@code changeKey(int, Key)}.
     */
    @Deprecated
    public void change(int i, Key key) {
        changeKey(i, key);
    }

    /**
     * Decrease the key associated with index {@code i} to the specified value.
     *
     * @param i   the index of the key to decrease
     * @param key decrease the key associated with index {@code i} to this key
     * @throws IllegalArgumentException unless {@code 0 <= i < capacity}
     * @throws IllegalArgumentException if {@code key >= keyOf(i)}
     * @throws NoSuchElementException   no key is associated with index {@code i}
     */
    public void decreaseKey(int i, Key key) {
        if (i < 0 || i >= capacity) throw new IllegalArgumentException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        if (keys[i].compareTo(key) <= 0)
            throw new IllegalArgumentException("Calling decreaseKey() with given argument would not strictly decrease the key");
        keys[i] = key;
        swim(indexOfPq[i]);
    }

    /**
     * Increase the key associated with index {@code i} to the specified value.
     *
     * @param i   the index of the key to increase
     * @param key increase the key associated with index {@code i} to this key
     * @throws IllegalArgumentException unless {@code 0 <= i < capacity}
     * @throws IllegalArgumentException if {@code key <= keyOf(i)}
     * @throws NoSuchElementException   no key is associated with index {@code i}
     */
    public void increaseKey(int i, Key key) {
        if (i < 0 || i >= capacity) throw new IllegalArgumentException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        if (keys[i].compareTo(key) >= 0)
            throw new IllegalArgumentException("Calling increaseKey() with given argument would not strictly increase the key");
        keys[i] = key;
        sink(indexOfPq[i]);
    }

    /**
     * Remove the key associated with index {@code i}.
     *
     * @param i the index of the key to remove
     * @throws IllegalArgumentException unless {@code 0 <= i < capacity}
     * @throws NoSuchElementException   no key is associated with index {@code i}
     */
    public void delete(int i) {
        if (i < 0 || i >= capacity) throw new IllegalArgumentException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        int index = indexOfPq[i];
        exch(index, size--);
        swim(index);
        sink(index);
        keys[i] = null;
        indexOfPq[i] = -1;
    }


    /***************************************************************************
     * General helper functions.
     ***************************************************************************/
    private boolean greater(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        indexOfPq[pq[i]] = i;
        indexOfPq[pq[j]] = j;
    }


    /***************************************************************************
     * Heap helper functions.
     ***************************************************************************/
    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && greater(j, j + 1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }


    /***************************************************************************
     * Iterators.
     ***************************************************************************/

    /**
     * Returns an iterator that iterates over the keys on the
     * priority queue in ascending order.
     * The iterator doesn't implement {@code remove()} since it's optional.
     *
     * @return an iterator that iterates over the keys in ascending order
     */
    public Iterator<Integer> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Integer> {
        // create a new pq
        private IndexPriorityQueue<Key> copy;

        // add all elements to copy of heap
        // takes linear time since already in heap order so no keys move
        public HeapIterator() {
            copy = new IndexPriorityQueue<Key>(pq.length - 1);
            for (int i = 1; i <= size; i++)
                copy.insert(pq[i], keys[pq[i]]);
        }

        public boolean hasNext() {
            return !copy.isEmpty();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMin();
        }
    }
}