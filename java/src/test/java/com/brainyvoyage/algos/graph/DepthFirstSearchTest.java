package com.brainyvoyage.algos.graph;

import com.brainyvoyage.datastructure.Graph;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

public class DepthFirstSearchTest {

    private Graph graph = new Graph(6);

    @Test
    public void testResource () throws IOException {
        ClassLoader loader = DepthFirstSearchTest.class.getClassLoader();
        InputStream in = loader.getResourceAsStream("com/brainyvoyage/algos/graph");
        BufferedReader rdr = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = rdr.readLine()) != null) {
            System.out.println("file: " + line);
        }
        rdr.close();
    }

    @Test
    public void testDfs(){
        graph.addEdge(0, 5);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(1, 2);
        graph.addEdge(0, 1);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(0, 2);

        System.out.print(graph);
        DepthFirstSearch dfs = new DepthFirstSearch(graph, 0);
        assertEquals(graph.getNumVertices(), dfs.count());
    }

}