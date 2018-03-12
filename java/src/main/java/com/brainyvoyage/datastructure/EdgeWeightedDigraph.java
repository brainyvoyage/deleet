package com.brainyvoyage.datastructure;


public class EdgeWeightedDigraph {
    private LinkedList<DirectedEdge>[] adjacencyList;
    private int numVertices;
    private int numEdges;

    @SuppressWarnings("unchecked")
    public EdgeWeightedDigraph(int capacity) {
        this.numVertices = capacity;
        this.numEdges = 0;
        adjacencyList = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(DirectedEdge edge) {
        adjacencyList[edge.from()].add(edge);
        this.numEdges++;
    }

    public Iterable<DirectedEdge> adj(int vertex) {
        return adjacencyList[vertex];
    }

    public Iterable<DirectedEdge> edges() {
        LinkedList<DirectedEdge> allEdges = new LinkedList<>();
        for (int i = 0; i < numVertices; i++) {
            for (DirectedEdge e : adj(i))
                allEdges.add(e);
        }
        return allEdges;
    }

    public String toString() {
        StringBuilder repr = new StringBuilder();
        repr.append(numVertices + " vertices, " + numEdges + " edges");
        repr.append(System.lineSeparator());
        for (int vertex = 0; vertex < numVertices; vertex++) {
            repr.append(vertex + ": ");
            for (DirectedEdge edge : adj(vertex)) repr.append(edge + " ");
            repr.append(System.lineSeparator());
        }
        return repr.toString();
    }

    public int getNumVertices() {
        return numVertices;
    }

    public int gettNumEdges() {
        return this.numEdges;
    }
}
