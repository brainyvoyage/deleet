package com.brainyvoyage.algos.graph;

import com.brainyvoyage.algos.heap.IndexPriorityQueue;
import com.brainyvoyage.datastructure.DirectedEdge;
import com.brainyvoyage.datastructure.EdgeWeightedDigraph;

import java.util.Stack;

public class ShortestPath {
    private double[] distanceTo;
    private DirectedEdge[] edgeTo;
    private IndexPriorityQueue<Double> pq;

    public ShortestPath(EdgeWeightedDigraph digraph, int source) {
        distanceTo = new double[digraph.getNumVertices()];
        edgeTo = new DirectedEdge[digraph.getNumVertices()];
        pq = new IndexPriorityQueue<>(digraph.getNumVertices());

        for(int i = 0; i < digraph.getNumVertices(); i++) {
            distanceTo[i] = Double.POSITIVE_INFINITY;
        }

        distanceTo[source] = 0.0;

        pq.insert(source, 0.0);
        while (!pq.isEmpty())
            relax(digraph, pq.delMin());
    }

    private void relax(EdgeWeightedDigraph digraph, int vertex) {
        for (DirectedEdge edge : digraph.adj(vertex)) {
            int w = edge.to();
            if (distanceTo[w] > distanceTo[vertex] + edge.weight()) {
                distanceTo[w] = distanceTo[vertex] + edge.weight();
                edgeTo[w] = edge;

                if (pq.contains(w)) pq.changeKey(w, distanceTo[w]);
                else pq.insert(w, distanceTo[w]);
            }
        }

    }

    public boolean hasPathTo(int vertex){
        return distanceTo[vertex] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int vertex) {
        if(!hasPathTo(vertex)) return null;
        Stack<DirectedEdge> path = new Stack<>();
        for(DirectedEdge edge = edgeTo[vertex]; edge != null; edge = edgeTo[edge.from()]){
            path.add(edge);
        }
        return path;
    }

    public double distTo(int vertex) {
        return distanceTo[vertex];
    }
}
