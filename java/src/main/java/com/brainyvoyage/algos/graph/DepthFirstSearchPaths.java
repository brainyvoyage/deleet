package com.brainyvoyage.algos.graph;

import java.util.Stack;

public class DepthFirstSearchPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int source;

    public DepthFirstSearchPaths(Graph graph, int source) {
        marked = new boolean[graph.getNumVertices()];
        edgeTo = new int[graph.getNumVertices()];
        this.source = source;
        dfs(graph, source);
    }

    private void dfs(Graph graph, int vertex) {
        marked[vertex] = true;
        for (int connectedVertex : graph.adj(vertex)) {
            if (!marked[connectedVertex]) {
                edgeTo[connectedVertex] = vertex;
                dfs(graph, connectedVertex);
            }
        }
    }

    public boolean hasPathTo(int vertex) {
        return marked[vertex];
    }

    public Iterable<Integer> pathTo(int vertex) {
        if (!marked[vertex]) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = vertex; x != source; x = edgeTo[x])
            path.push(x);
        return path;
    }
}
