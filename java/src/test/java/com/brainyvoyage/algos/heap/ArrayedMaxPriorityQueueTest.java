package com.brainyvoyage.algos.heap;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayedMaxPriorityQueueTest {
    private ArrayedMaxPriorityQueue priorityQueue = new ArrayedMaxPriorityQueue(10);

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
        Integer[] data = {54, 12, 51, 14, 45, 95, 28, 22};
        for (Integer elem: data)
            priorityQueue.insert(elem);
        assertEquals(95, priorityQueue.deleteMax());
        assertEquals(54, priorityQueue.deleteMax());
        assertEquals(51, priorityQueue.deleteMax());
        assertEquals(45, priorityQueue.deleteMax());

        assertEquals(data.length - 4, priorityQueue.size());
        assert(!priorityQueue.isEmpty());
    }
}