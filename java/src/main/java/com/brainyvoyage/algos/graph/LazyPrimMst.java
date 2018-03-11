package com.brainyvoyage.algos.graph;

import com.brainyvoyage.datastructure.Edge;
import com.brainyvoyage.datastructure.Queue;
import com.brainyvoyage.datastructure.EdgeWeightedGraph;
import com.brainyvoyage.algos.heap.ArrayedPriorityQueue;


public class LazyPrimMst {
    private boolean[] marked;
    private Queue<Edge> mst;
    private ArrayedPriorityQueue<Edge> minPq;

    public LazyPrimMst(EdgeWeightedGraph edgeWeightedGraph) {
        marked = new boolean[edgeWeightedGraph.getNumVertices()];
        mst = new Queue<>();
        int numOfVertices = edgeWeightedGraph.getNumVertices();
        int maxNumberOfEdges = numOfVertices * (numOfVertices - 1) /2;
        minPq = new ArrayedPriorityQueue<>(maxNumberOfEdges, false);
        visit(edgeWeightedGraph, 0);
        while (!minPq.isEmpty()) {
            Edge e = minPq.delete();
            int vertex = e.either();
            int otherVertex = e.other(vertex);
            if (marked[vertex] && marked[otherVertex]) continue;
            mst.enqueue(e);
            if (!marked[vertex]) visit(edgeWeightedGraph, vertex);
            if (!marked[otherVertex]) visit(edgeWeightedGraph, otherVertex);
        }
    }

    private void visit(EdgeWeightedGraph edgeWeightedGraph, int vertex) {
        marked[vertex] = true;
        for (Edge edge : edgeWeightedGraph.adj(vertex)) {
            if (!marked[edge.other(vertex)])
                minPq.insert(edge);
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        double totalWeight = 0.0;
        for (Edge edge : mst) {
            totalWeight += edge.weight();
        }
        return totalWeight;
    }
}