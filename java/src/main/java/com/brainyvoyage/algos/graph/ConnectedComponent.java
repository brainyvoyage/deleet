package com.brainyvoyage.algos.graph;

import com.brainyvoyage.datastructure.Graph;

public class ConnectedComponent {
    private boolean[] marked;
    private int[] id;
    private int component;

    public ConnectedComponent(Graph graph) {
        marked = new boolean[graph.getNumVertices()];
        id = new int[graph.getNumVertices()];

        for (int vertex = 0; vertex < graph.getNumVertices(); vertex++) {
            if (!marked[vertex]) {
                marked[vertex] = true;
                dfs(graph, vertex);
                component++;
            }
        }
    }

    public boolean connected(int vertex1, int vertex2) {
        return id[vertex1] == id[vertex2];
    }

    private void dfs(Graph graph, int source) {
        marked[source] = true;
        id[source] = component;
        for (int connectedVertex : graph.adj(source)) {
            if (!marked[connectedVertex]) {
                dfs(graph, connectedVertex);
            }
        }
    }

    public int numConnectedComponent() {
        return component;
    }

    public int id(int vertex) {
        return id[vertex];
    }
}
