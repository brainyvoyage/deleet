package com.brainyvoyage.datastructure;

import org.junit.Test;

import static org.junit.Assert.*;

public class EdgeWeightedGraphTest {
    private double totalWeight = 0.0;
    private String data = "4 5 0.35\n" +
            "4 7 0.37\n" +
            "5 7 0.28\n" +
            "0 7 0.16\n" +
            "1 5 0.32\n" +
            "0 4 0.38\n" +
            "2 3 0.17\n" +
            "1 7 0.19\n" +
            "0 2 0.26\n" +
            "1 2 0.36\n" +
            "1 3 0.29\n" +
            "2 7 0.34\n" +
            "6 2 0.40\n" +
            "3 6 0.52\n" +
            "6 0 0.58\n" +
            "6 4 0.93";
    private EdgeWeightedGraph ewg;

    public EdgeWeightedGraphTest() {
        ewg = new EdgeWeightedGraph(8);
        String[] edgeData = data.split("\n");
        for (String ed : edgeData) {
            String[] edComponent = ed.split(" ");
            Edge e = new Edge(Integer.parseInt(edComponent[0]), Integer.parseInt(edComponent[1]), Double.parseDouble(edComponent[2]));
            this.totalWeight += Double.parseDouble(edComponent[2]);
            ewg.addEdge(e);
        }
    }

    @Test
    public void testWeightedGraph() {
        System.out.println(ewg);
        assertEquals(8, ewg.getNumVertices());
        assertEquals(16, ewg.getNumEdges());
        double weight = 0.0;
        for(int vertex = 0; vertex < ewg.getNumVertices(); vertex++) {
            for (Edge connectedVertices : ewg.adj(vertex)) {
                weight += connectedVertices.weight();
            }
        }
        assertEquals(totalWeight, weight/ 2.0, 0.00000001);
    }

}