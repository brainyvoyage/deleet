package com.brainyvoyage.algos.graph;

import org.junit.Test;

public class BipartiteTest {

    @Test
    public void isBipartite() {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        System.out.println(graph);
        Bipartite bipartite = new Bipartite(graph);
        assert (bipartite.isBipartite());

        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        bipartite = new Bipartite(graph);
        System.out.println(graph);
        assert (!bipartite.isBipartite());
    }
}