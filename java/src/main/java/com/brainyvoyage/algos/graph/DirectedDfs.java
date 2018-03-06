package com.brainyvoyage.algos.graph;

public class DirectedDfs {
    private boolean[] marked;

    public DirectedDfs(Digraph digraph, int source) {
        marked = new boolean[digraph.vertices()];
        dfs(digraph, source);
    }

    public DirectedDfs(Digraph digraph, Iterable<Integer> sources) {
        marked = new boolean[digraph.vertices()];
        for (int source : sources) {
            if (!marked[source])
                dfs(digraph, source);
        }
    }

    private void dfs(Digraph digraph, int source) {
        marked[source] = true;
        for (int connectedVertices : digraph.adj(source)) {
            if (!marked[connectedVertices]) {
                dfs(digraph, connectedVertices);
            }
        }
    }

    public boolean marked(int vertex) {
        return marked[vertex];
    }
}
