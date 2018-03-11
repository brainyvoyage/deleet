package com.brainyvoyage.algos.graph;

import com.brainyvoyage.datastructure.Edge;
import com.brainyvoyage.datastructure.EdgeWeightedGraph;
import com.brainyvoyage.datastructure.EdgeWeightedGraphTest;
import org.junit.Test;

import static org.junit.Assert.*;

public class KruskalMstTest {

    private EdgeWeightedGraph ewg = new EdgeWeightedGraphTest().getEwg();
    private KruskalMst mst = new KruskalMst(ewg);

    @Test
    public void testMst() {
        for(Edge e : mst.edges()) {
            System.out.print(String.format("<%s> ", e));
        }
        System.out.println();

        assertEquals(1.81, mst.weight(), 0.00001);
    }
}