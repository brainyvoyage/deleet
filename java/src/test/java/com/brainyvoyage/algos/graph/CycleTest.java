package com.brainyvoyage.algos.graph;

import com.brainyvoyage.datastructure.Graph;
import org.junit.Test;

public class CycleTest {
    private Graph graph;
    private Cycle cycle;
    public CycleTest() {
        graph = new Graph(13);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 5);
        graph.addEdge(0, 6);

        graph.addEdge(3, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);
        graph.addEdge(4, 5);

        graph.addEdge(7, 8);

        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(9, 12);

        graph.addEdge(11, 12);
        cycle = new Cycle(graph);
    }

    @Test
    public void hasCycle() {
        System.out.print(cycle.hasCycle());
        assert (cycle.hasCycle());
    }
}