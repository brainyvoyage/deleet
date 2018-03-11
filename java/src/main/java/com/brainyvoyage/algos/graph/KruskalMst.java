package com.brainyvoyage.algos.graph;

import com.brainyvoyage.algos.heap.ArrayedPriorityQueue;
import com.brainyvoyage.datastructure.*;

public class KruskalMst {
    private Queue<Edge> mst;

    public KruskalMst(EdgeWeightedGraph edgeWeightedGraph) {
        UnionFind uf = new UnionFind(edgeWeightedGraph.getNumVertices());
        mst = new Queue<>();
        ArrayedPriorityQueue<Edge> minPq = new ArrayedPriorityQueue<>(edgeWeightedGraph.getNumEdges(),
                edgeWeightedGraph.edges(),
                false);

        while (!minPq.isEmpty() && mst.size() < edgeWeightedGraph.getNumVertices() - 1) {
            Edge edge = minPq.delete();
            int vertex = edge.either();
            int otherVertex = edge.other(vertex);
            if (uf.connected(vertex, otherVertex)) continue;
            uf.union(vertex, otherVertex);
            mst.enqueue(edge);
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
