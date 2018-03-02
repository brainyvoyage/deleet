package com.brainyvoyage.algos.graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchTest {
    private Graph graph = new Graph(13);
    private Search search = new Search(graph, 0);


    @Test
    public void testConnected() {
        graph.addEdge(0, 5);
        graph.addEdge(4, 3);
        graph.addEdge(0, 1);
        graph.addEdge(9, 12);
        graph.addEdge(6, 4);
        graph.addEdge(5, 4);
        graph.addEdge(0, 2);
        graph.addEdge(11, 12);
        graph.addEdge(9, 10);
        graph.addEdge(0, 6);
        graph.addEdge(7, 8);
        graph.addEdge(9, 11);
        graph.addEdge(5, 3);
        assertNotEquals(search.count(), graph.getNumVertices());
    }
}