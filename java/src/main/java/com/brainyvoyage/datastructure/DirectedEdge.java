package com.brainyvoyage.datastructure;

public class DirectedEdge {
    private double weight;
    private final int source;
    private final int sink;

    public DirectedEdge(int from, int to, double weight) {
        this.source = from;
        this.sink = to;
        this.weight = weight;
    }

    public int from() {
        return this.source;
    }

    public int to() {
        return this.sink;
    }

    public double weight() { return weight; }

    @Override
    public String toString() {
        return String.format("< %s -> %s : %.2f>", this.source, this.sink, this.weight);
    }
}
