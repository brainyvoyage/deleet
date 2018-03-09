package com.brainyvoyage.algos.graph;

import com.brainyvoyage.datastructure.Digraph;

public class TopologicalSort {
    private Iterable<Integer> order;

    public TopologicalSort(Digraph digraph) {
        DirectedCycle cycleFinder = new DirectedCycle(digraph);
        if (!cycleFinder.hasCycle()) {
            DepthFirstOrder dfsOrder = new DepthFirstOrder(digraph);
            order = dfsOrder.reversePost();
        }
    }

    public boolean isDag() {
        return order == null;
    }

    public Iterable<Integer> order() {
        return order;
    }
}
