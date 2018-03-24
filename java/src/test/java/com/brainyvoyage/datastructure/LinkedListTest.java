package com.brainyvoyage.datastructure;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void iterator() {
    }

    @Test
    public void add() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        int first= list.getHead();
        int last = list.getLast();
        assertEquals(5, first);
        assertEquals(5, last);
        assertEquals(1, list.size());

        list.add(10);

        first= list.getHead();
        last = list.getLast();
        assertEquals(10, first);
        assertEquals(5, last);
        assertEquals(2, list.size());
    }

    @Test
    public void append() {
        LinkedList<Integer> list = new LinkedList<>();
        assert (list.isEmpty());
        list.append(5);
        assert(! list.isEmpty());
        int first= list.getHead();
        int last = list.getLast();
        assertEquals(5, first);
        assertEquals(5, last);
        assertEquals(1, list.size());

        list.append(10);

        first= list.getHead();
        last = list.getLast();
        assertEquals(5, first);
        assertEquals(10, last);
        assertEquals(2, list.size());
    }

}