package com.brainyvoyage.algos.graph;

import com.brainyvoyage.datastructure.DirectedEdge;
import com.brainyvoyage.datastructure.EdgeWeightedDigraph;
import com.brainyvoyage.datastructure.EdgeWeightedDigraphTest;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShortestPathTest {
    private ShortestPath sp = new ShortestPath(EdgeWeightedDigraphTest.weightedDigraph, 0);
    @Test
    public void testShortestPath(){
        EdgeWeightedDigraph digraph = EdgeWeightedDigraphTest.weightedDigraph;
        System.out.print(digraph);
        Iterable<DirectedEdge> path  = sp.pathTo(6);
        for(DirectedEdge edge: path)
            System.out.print(edge + " ");
    }
}