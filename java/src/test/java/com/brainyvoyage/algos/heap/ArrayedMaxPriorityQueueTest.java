package com.brainyvoyage.algos.heap;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayedMaxPriorityQueueTest {
    private int capacity = 10;
    private ArrayedMaxPriorityQueue priorityQueue = new ArrayedMaxPriorityQueue(capacity);

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
        Integer[] data = {-3, 54, 12, 51, 14, 45, 95, 28, 22, 11, 9, 7, 3};
        for (Integer elem: data)
            priorityQueue.insert(elem);
        priorityQueue.show();
        assertEquals(45, priorityQueue.deleteMax());
        assertEquals(28, priorityQueue.deleteMax());
        assertEquals(22, priorityQueue.deleteMax());
        assertEquals(14, priorityQueue.deleteMax());

        assertEquals(capacity - 4, priorityQueue.size());
        assert(!priorityQueue.isEmpty());
    }
}