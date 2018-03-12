package com.brainyvoyage.algos.graph;

import com.brainyvoyage.datastructure.EdgeWeightedDigraph;

public class ShortestPath {
    private double[] distanceTo;
    private int[] edgeTo;
    private boolean[] marked;

    public ShortestPath(EdgeWeightedDigraph digraph, int source) {
        distanceTo = new double[digraph.getNumVertices()];
        edgeTo = new int[digraph.getNumVertices()];
        marked = new boolean[digraph.getNumVertices()];

        for(int i = 0; i < digraph.getNumVertices(); i++) {
            distanceTo[i] = Double.POSITIVE_INFINITY;
        }
    }
}
