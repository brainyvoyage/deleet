package com.brainyvoyage.datastructure;


public class Graph {
    private final int numVertices;
    private int numEdges;

    private LinkedList<Integer>[] adjacencyList;

    @SuppressWarnings("unchecked")
    public Graph(final int vertexCapacity) {
        this.numVertices = vertexCapacity;
        this.numEdges = 0;
        adjacencyList = (LinkedList<Integer>[]) new LinkedList[vertexCapacity];
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

    public void addEdge(int vertex1, int vertex2) {
        try {
            adjacencyList[vertex1].add(vertex2);
            adjacencyList[vertex2].add(vertex1);
            numEdges++;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public Iterable<Integer> adj(int vertex) {
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

    public static int numberOfSelfLoops(Graph graph) {
        int count = 0;
        for (int vertex = 0; vertex < graph.getNumVertices(); vertex++) {
            for (int connectedVertex : graph.adj(vertex))
                if (vertex == connectedVertex) count++;
            return count / 2;
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder repr = new StringBuilder();
        repr.append(numVertices + " vertices, " + numEdges + " edges");
        repr.append(System.lineSeparator());
        for (int vertex = 0; vertex < numVertices; vertex++) {
            repr.append(vertex + ": ");
            for (int connectedVertex : adj(vertex)) repr.append(connectedVertex + " ");
            repr.append(System.lineSeparator());
        }
        return repr.toString();
    }
}
