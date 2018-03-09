package com.brainyvoyage.algos.graph;

import com.brainyvoyage.datastructure.Digraph;
import com.brainyvoyage.datastructure.Queue;

import java.util.Stack;

public class DepthFirstOrder {
    private boolean[] marked;

    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;

    public DepthFirstOrder(Digraph digraph) {
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();

        marked = new boolean[digraph.vertices()];
        for (int vertex = 0; vertex < digraph.vertices(); vertex++) {
            if (!marked[vertex]) dfs(digraph, vertex);
        }
    }

    private void dfs(Digraph digraph, int source) {
        marked[source] = true;
        pre.enqueue(source);

        for (int connectedVertex : digraph.adj(source)) {
            if (!marked[connectedVertex]) {
                dfs(digraph, connectedVertex);
            }
        }
        post.enqueue(source);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> reversePost() {
        Stack<Integer> reverse = new Stack<>();
        for (int v : post)
            reverse.push(v);
        return post;
    }
}
