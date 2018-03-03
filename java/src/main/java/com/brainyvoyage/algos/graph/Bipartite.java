package com.brainyvoyage.algos.graph;

public class Bipartite {
    private boolean[] marked;
    private boolean[] color;
    private boolean isBipartite = true;

    public Bipartite(Graph graph) {
        marked = new boolean[graph.getNumVertices()];
        color = new boolean[graph.getNumVertices()];
        for (int vertex = 0; vertex < graph.getNumVertices(); vertex++) {
            if(!marked[vertex]) dfs(graph, vertex);
        }
    }

    private void dfs(Graph graph, int vertex) {
        marked[vertex] = true;
        for(int connectedVertex : graph.adj(vertex)) {
            if(!marked[connectedVertex]) {
                color[connectedVertex] = !color[vertex];
                dfs(graph, connectedVertex);
            }
            else if(color[connectedVertex] == color[vertex]) isBipartite = false;
        }
    }

    public boolean isBipartite() { return isBipartite; }
}
