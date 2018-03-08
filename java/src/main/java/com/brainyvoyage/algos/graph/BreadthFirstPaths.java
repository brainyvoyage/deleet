package com.brainyvoyage.algos.graph;

import com.brainyvoyage.datastructure.Graph;
import com.brainyvoyage.datastructure.Queue;

import java.util.Stack;

public class BreadthFirstPaths {

    private boolean[] marked;
    private int[] edgeTo;
    private final Integer source;

    /**
     * @param graph
     * @param source
     */
    public BreadthFirstPaths(Graph graph, int source) {
        marked = new boolean[graph.getNumVertices()];
        edgeTo = new int[graph.getNumVertices()];
        this.source = source;
        bfs(graph, source);
    }

    private void bfs(Graph graph, int source) {
        marked[source] = true;
        Queue<Integer> visitingQueue = new Queue<>();
        visitingQueue.enqueue(source);
        while (!visitingQueue.isEmpty()) {
            Integer vertex = visitingQueue.dequeue();
            for (int connectedVertices : graph.adj(vertex)) {
                if (!marked[connectedVertices]) {
                    visitingQueue.enqueue(connectedVertices);
                    edgeTo[connectedVertices] = vertex;
                    marked[connectedVertices] = true;
                }
            }
        }
    }

    /**
     * @param vertex
     * @return
     */
    public boolean hasPathTo(int vertex) {
        return marked[vertex];
    }

    public Iterable<Integer> pathTo(int vertex) {
        if (!marked[vertex]) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = vertex; x != source; x = edgeTo[x]) {
            path.push(x);
        }
        return path;
    }
}
