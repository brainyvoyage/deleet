package com.brainyvoyage.algos.graph;

import com.brainyvoyage.datastructure.DirectedEdge;
import com.brainyvoyage.datastructure.EdgeWeightedDigraph;
import com.brainyvoyage.datastructure.EdgeWeightedDigraphTest;
import com.brainyvoyage.datastructure.Queue;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

public class ShortestPathTest {
    private ShortestPath sp = new ShortestPath(EdgeWeightedDigraphTest.weightedDigraph, 0);
    @Test
    public void testShortestPath(){
        EdgeWeightedDigraph digraph = EdgeWeightedDigraphTest.weightedDigraph;
        System.out.print(digraph);
        Stack<DirectedEdge> path  = sp.pathTo(6);
        System.out.println(String.format("Source = %d, Destination = %d", 0, 6));
        double totalWeight = 0.0;
        while (!path.isEmpty()){
            DirectedEdge edge = path.pop();
            totalWeight += edge.weight();
            System.out.print(edge + " ");
        }
        System.out.println();
        System.out.println(String.format("Path Weight = %.2f", totalWeight));

    }
}
