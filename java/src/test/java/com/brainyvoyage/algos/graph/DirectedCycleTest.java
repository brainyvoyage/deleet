package com.brainyvoyage.algos.graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class DirectedCycleTest {

    private DigraphTest digraph = new DigraphTest();
    @Test
    public void hasCycle() {
        DirectedCycle directedCycle = new DirectedCycle(digraph.getDigraph());
        assertEquals(true, directedCycle.hasCycle());


        System.out.println(digraph.getDigraph());
        System.out.println();

        for (int x : directedCycle.cycle()) {
            System.out.print(x + " <- ");
        }
    }

}