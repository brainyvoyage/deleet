package com.brainyvoyage.algos.graph;

public class DepthFirstSearch {
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph graph, int source) {
        marked = new boolean[graph.getNumVertices()];
        System.out.print(source + " ");
        dfs(graph, source);
        System.out.println();
    }

    private void dfs(Graph graph, int source) {
        marked[source] = true;
        count++;

        for (int connectedVertices : graph.adj(source)) {
            if (!marked[connectedVertices]) {
                System.out.print(connectedVertices + " ");
                dfs(graph, connectedVertices);
            }
        }
    }

    public boolean marked(int vertex) {
        return marked[vertex];
    }

    public int count() {
        return count;
    }
}
