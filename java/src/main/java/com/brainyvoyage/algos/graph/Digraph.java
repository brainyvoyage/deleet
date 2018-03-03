package com.brainyvoyage.algos.graph;

import com.brainyvoyage.datastructure.LinkedList;

public class Digraph {
    private int vertices;
    private int edges;
    private LinkedList<Integer>[] adjacencyList;

    @SuppressWarnings("unchecked")
    public Digraph(int capacity) {
        vertices = capacity;
        adjacencyList = new LinkedList[capacity];
        for(int i = 0; i < capacity; i++)
            adjacencyList[i] = new LinkedList<>();
    }

    public void addEdge(int from, int to) {
        adjacencyList[from].add(to);
        edges++;
    }

    public Iterable<Integer> adj(int vertex) {
        return  adjacencyList[vertex];
    }
    public int vertices(){ return vertices; }
    public int edges() { return edges; }

    public Digraph reverse() {
        Digraph reversed = new Digraph(this.vertices);
        for(int vertex = 0; vertex < this.vertices; vertex++) {
            for(int connectedVertex : adj(vertex))
                reversed.addEdge(connectedVertex, vertex);
        }
        return reversed;
    }
}
