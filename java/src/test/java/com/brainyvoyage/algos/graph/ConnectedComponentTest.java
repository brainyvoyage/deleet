package com.brainyvoyage.algos.graph;

import com.brainyvoyage.datastructure.Graph;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConnectedComponentTest {
    private Graph graph;
    private ConnectedComponent cc;

    public ConnectedComponentTest() {
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

        cc = new ConnectedComponent(graph);
        System.out.println(graph);

    }

    @Test
    public void testCC() {
        assertEquals(3, cc.numConnectedComponent());
        assert (cc.connected(0, 4));
        assert (!cc.connected(2, 12));
        assert (!cc.connected(7, 10));
    }

}