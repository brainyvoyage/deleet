package com.brainyvoyage.algos.heap;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayedPriorityQueueTest {
    private int capacity = 10;
    private ArrayedPriorityQueue priorityQueue = new ArrayedPriorityQueue(capacity);
    private ArrayedPriorityQueue minPq = new ArrayedPriorityQueue(capacity, false);
    private final Integer[] data = {-3, 54, 12, 51, 14, 45, 95, 28, 22, 11, 9, 7, 300, 1};

    @Test
    public void isEmpty() {
        assertEquals(true, priorityQueue.isEmpty());
    }

    @Test
    public void size() {
        assertEquals(0, priorityQueue.size());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void insertDelete() {

        for (Integer elem : data)
            priorityQueue.insert(elem);
        priorityQueue.show();

        assertEquals(45, priorityQueue.delete());
        assertEquals(28, priorityQueue.delete());
        assertEquals(22, priorityQueue.delete());
        assertEquals(14, priorityQueue.delete());

        assertEquals(capacity - 4, priorityQueue.size());
        assert (!priorityQueue.isEmpty());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testMinPq() {
        for (Integer elem : data)
            minPq.insert(elem);
        minPq.show();
        assertEquals(11, minPq.delete());
        assertEquals(12, minPq.delete());
        assertEquals(14, minPq.delete());
        assertEquals(22, minPq.delete());
        minPq.show();
        assertEquals(capacity - 4, minPq.size());
        assert (!minPq.isEmpty());
    }
}