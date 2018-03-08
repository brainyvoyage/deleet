package com.brainyvoyage.datastructure;

public class EdgeWeightedGraph {
    private final int numVertices;
    private int numEdges;

    private LinkedList<Edge>[] adjacencyList;

    @SuppressWarnings("unchecked")
    public EdgeWeightedGraph(final int vertexCapacity) {
        this.numVertices = vertexCapacity;
        this.numEdges = 0;
        adjacencyList = (LinkedList<Edge>[]) new LinkedList[vertexCapacity];
        for (int i = 0; i < numVertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public int getNumVertices() {
        return numVertices;
    }

    public int getNumEdges() {
        return numEdges;
    }

    public void addEdge(Edge edge) {
        int v1 = edge.either();
        int v2 = edge.other(v1);

        this.adjacencyList[v1].add(edge);
        this.adjacencyList[v2].add(edge);

        this.numEdges++;
    }

    public Iterable<Edge> adj(int vertex) {
        return adjacencyList[vertex];
    }

    public static int degree(Graph graph, int vertex) {
        int degree = 0;
        for (int vert : graph.adj(vertex)) degree++;
        return degree;
    }

    public static int maxDegree(Graph graph) {
        int max = 0;
        for (int vertex = 0; vertex < graph.getNumVertices(); vertex++) {
            int degree = degree(graph, vertex);
            if (degree > max) max = degree;
        }
        return max;
    }

    public static int avgDegree(Graph graph) {
        return 2 * graph.getNumEdges() / graph.getNumVertices();
    }



    @Override
    public String toString() {
        StringBuilder repr = new StringBuilder();
        repr.append(numVertices + " vertices, " + numEdges + " edges");
        repr.append(System.lineSeparator());
        for (int vertex = 0; vertex < numVertices; vertex++) {
            repr.append(vertex + ": ");
            for (Edge connectedVertex : adj(vertex)) repr.append(connectedVertex + " ");
            repr.append(System.lineSeparator());
        }
        return repr.toString();
    }
}
