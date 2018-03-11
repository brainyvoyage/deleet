package com.brainyvoyage.algos.graph;

import com.brainyvoyage.datastructure.Digraph;
import org.junit.Test;


public class TopologicalSortTest {
    private Digraph digraph;

    public TopologicalSortTest() {
        digraph = new Digraph(13);
        digraph.addEdge(2, 3);
        digraph.addEdge(0, 6);
        digraph.addEdge(0, 1);
        digraph.addEdge(2, 0);
        digraph.addEdge(11, 12);
        digraph.addEdge(9, 12);
        digraph.addEdge(9, 10);
        digraph.addEdge(9, 11);
        digraph.addEdge(3, 5);
        digraph.addEdge(8, 7);
        digraph.addEdge(5, 4);
        digraph.addEdge(0, 5);
        digraph.addEdge(6, 4);
        digraph.addEdge(6, 9);
        digraph.addEdge(7, 6);
    }

    @Test
    public void testTopologicalSort() {
        System.out.println(digraph);
        DirectedCycle cycleFinder = new DirectedCycle(digraph);
        assert (!cycleFinder.hasCycle());
        TopologicalSort ts = new TopologicalSort(digraph);
        Iterable<Integer> order = ts.order();
        for (int x : order) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

}