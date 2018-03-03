package com.brainyvoyage.algos.graph;


import org.junit.Test;

public class DigraphTest {
    private Digraph digraph;

    public DigraphTest() {
        digraph = new Digraph(13);
        digraph.addEdge(4, 2);
        digraph.addEdge(2, 3);
        digraph.addEdge(3, 2);
        digraph.addEdge(6, 0);
        digraph.addEdge(0, 1);
        digraph.addEdge(2, 0);
        digraph.addEdge(11, 12);
        digraph.addEdge(12, 9);
        digraph.addEdge(9, 10);
        digraph.addEdge(9, 11);
        digraph.addEdge(8, 9);
        digraph.addEdge(10, 12);
        digraph.addEdge(11, 4);
        digraph.addEdge(4, 3);
        digraph.addEdge(3, 5);
        digraph.addEdge(7, 8);
        digraph.addEdge(8, 7);
        digraph.addEdge(5, 4);
        digraph.addEdge(0, 5);
        digraph.addEdge(6, 4);
        digraph.addEdge(6, 9);
        digraph.addEdge(7, 6);
    }

    @Test
    public void testDigraph() {
        System.out.print(digraph);
    }
}