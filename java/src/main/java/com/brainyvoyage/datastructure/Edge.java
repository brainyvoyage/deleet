package com.brainyvoyage.datastructure;

public class Edge implements Comparable<Edge> {
    private Double weight;
    int vertex1;
    int vertex2;

    public Edge(int vertex1, int vertex2, double weight) {
        this.weight = weight;
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    public int either() {
        return vertex1;
    }

    public int other(int vertex) {
        if (vertex == this.vertex1) return vertex2;
        else if (vertex == this.vertex2) return vertex1;
        else throw new IllegalArgumentException("Inconsistent vertex");
    }

    @Override
    public int compareTo(Edge that) {
        return this.weight.compareTo(that.weight);
    }

    @Override
    public String toString() {
        return String.format("%d-%d %.2f", vertex1, vertex2, weight);
    }
}
