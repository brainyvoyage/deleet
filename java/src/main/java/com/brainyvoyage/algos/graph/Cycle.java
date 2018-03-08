package com.brainyvoyage.algos.graph;

import com.brainyvoyage.datastructure.Graph;

public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph graph) {
        marked = new boolean[graph.getNumVertices()];
        for (int vertex = 0; vertex < graph.getNumVertices(); vertex++) {
            if (!marked[vertex]) {
                marked[vertex] = true;
                dfs(graph, vertex, vertex);
            }
        }
    }

    private void dfs(Graph graph, int vertex1, int vertex2) {
        marked[vertex1] = true;
        for (int connectedVertex : graph.adj(vertex1)) {
            if (!marked[connectedVertex]) {
                dfs(graph, connectedVertex, vertex2);
            } else if (vertex1 != vertex2) hasCycle = true;
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}
