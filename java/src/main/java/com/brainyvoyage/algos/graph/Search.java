package com.brainyvoyage.algos.graph;

public class Search {
    private Graph graph;
    private int source;

    public Search(Graph graph, int sourceVertex) {
        this.graph = graph;
        this.source = sourceVertex;
    }

    public boolean marked(int vertex) {
        Iterable<Integer> connectedVertex = graph.adj(source);
        for (Integer connected: connectedVertex )
            if (connected == vertex) return true;
        return false;
    }

    public int count(){
        int count = 0;
        try {
            Iterable<Integer> connectedVertex = graph.adj(source);
            for (Integer ignored : connectedVertex)
                count++;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return count;
    }
}
