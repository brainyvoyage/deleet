package com.brainyvoyage.algos.graph;

import com.brainyvoyage.datastructure.Graph;
import org.junit.Test;

import static org.junit.Assert.*;

public class BreadthFirstPathsTest {
    private final Graph graph;
    private final BreadthFirstPaths bfsPath;
    private String pathString(Iterable<Integer> path, Integer source) {
        StringBuilder sb = new StringBuilder();

        for (Integer vertex : path) {
            if (vertex == 0) break;
            sb.append(vertex + "-");
        }
        sb.append(source);
        return sb.reverse().toString();
    }
    public BreadthFirstPathsTest() {
        graph = new Graph(7);
        graph.addEdge(0, 5);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(1, 2);
        graph.addEdge(0, 1);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(0, 2);

        bfsPath = new BreadthFirstPaths(graph, 0);
        System.out.print(graph);
    }

    @Test
    public void testPath() {
        assert (bfsPath.hasPathTo(3));
        assert (!bfsPath.hasPathTo(6));
    }

    @Test
    public void testPathTo() {
        Iterable<Integer> path = bfsPath.pathTo(5);
        assertNotEquals(null, path);

        System.out.println(pathString(path, 0));
        path = bfsPath.pathTo(6);
        assertEquals(null, path);
    }
}