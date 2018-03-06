package com.brainyvoyage.algos.graph;

import com.brainyvoyage.datastructure.LinkedList;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class DirectedDfsTest {
    private DigraphTest digraph = new DigraphTest();

    @Test
    public void reachableTest() {
        int source = 1;
        DirectedDfs reachable = new DirectedDfs(digraph.getDigraph(), source);
        int[] expected = {1};
        HashSet<Integer> actual = new HashSet<>();
        for(int i = 0; i < digraph.getDigraph().vertices(); i++) {
            if (reachable.marked(i))
                actual.add(i);
        }
        assertEquals(expected.length, actual.size());
        for (int v : expected) {
            assertTrue(actual.contains(v));
        }

        source = 2;
        int[] expectedWithSource2 = {0, 1, 2, 3, 4, 5};
        actual.clear();
        reachable = new DirectedDfs(digraph.getDigraph(), source);
        for(int i = 0; i < digraph.getDigraph().vertices(); i++) {
            if (reachable.marked(i))
                actual.add(i);
        }
        assertEquals(expectedWithSource2.length, actual.size());
        for (int v : expectedWithSource2) {
            assertTrue(actual.contains(v));
        }


        LinkedList<Integer> sources = new LinkedList<>();
        sources.add(1); sources.add(2); sources.add(6);
        int[] expectedWithMultipleSources = {0, 1, 2, 3, 4, 5, 6, 9, 10, 11, 12};
        actual.clear();
        reachable = new DirectedDfs(digraph.getDigraph(), sources);
        for(int i = 0; i < digraph.getDigraph().vertices(); i++) {
            if (reachable.marked(i))
                actual.add(i);
        }
        assertEquals(expectedWithMultipleSources.length, actual.size());
        for (int v : expectedWithMultipleSources) {
            assertTrue(actual.contains(v));
        }
    }

}