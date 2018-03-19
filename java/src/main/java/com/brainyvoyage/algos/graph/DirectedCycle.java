package com.brainyvoyage.algos.graph;

import com.brainyvoyage.datastructure.Digraph;

import java.util.Stack;

public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;

    public DirectedCycle(Digraph digraph) {
        marked = new boolean[digraph.vertices()];
        onStack = new boolean[digraph.vertices()];
        edgeTo = new int[digraph.vertices()];

        for (int vertex = 0; vertex < digraph.vertices(); vertex++) {
            if (!marked[vertex])
                dfs(digraph, vertex);
        }
    }

    private void dfs(Digraph digraph, int source) {
        onStack[source] = true;
        marked[source] = true;

        for (int connectedVertex : digraph.adj(source)) {
            if (this.hasCycle()) return;
            else if (!marked[connectedVertex]) {
                edgeTo[connectedVertex] = source;
                dfs(digraph, connectedVertex);
            } else if (onStack[connectedVertex]) {
                cycle = new Stack<>();
                for (int vertex = source; vertex != connectedVertex; vertex = edgeTo[vertex])
                    cycle.push(vertex);
                cycle.push(connectedVertex);
                cycle.push(source);
            }
        }
        onStack[source] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
}
