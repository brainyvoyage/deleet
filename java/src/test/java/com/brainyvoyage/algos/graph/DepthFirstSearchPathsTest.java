package com.brainyvoyage.algos.graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class DepthFirstSearchPathsTest {
    private final Graph graph;
    private final DepthFirstSearchPaths dfsPath;

    public DepthFirstSearchPathsTest() {
        graph = new Graph(7);
        graph.addEdge(0, 5);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(1, 2);
        graph.addEdge(0, 1);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(0, 2);

        dfsPath = new DepthFirstSearchPaths(graph, 0);
        System.out.print(graph);
    }

    @Test
    public void testPath() {
        assert (dfsPath.hasPathTo(3));
        assert (!dfsPath.hasPathTo(6));
    }

    @Test
    public void testPathTo() {
        Iterable<Integer> path = dfsPath.pathTo(5);
        assertNotEquals(null, path);
        StringBuilder sb = new StringBuilder();

        for (Integer vertex : path) {
            if (vertex == 0) break;
            sb.append(vertex + "-");
        }
        sb.append("0");
        System.out.println(sb.reverse().toString());
        path = dfsPath.pathTo(6);
        assertEquals(null, path);
    }

}