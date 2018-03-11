package com.brainyvoyage.datastructure;

public class UnionFind {
    private int[] id;
    private int numComponent;

    public UnionFind(int capacity) {
        id = new int[capacity];
        numComponent = capacity;
        for(int i = 0; i < numComponent; i++) {
            id[i] = i;
        }
    }

    public int find(int elem) {
        return id[elem];
    }

    public boolean connected(int elem1, int elem2) {
        return id[elem1] == id[elem2];
    }

    public void union(int elem1, int elem2) {
        int id1 = find(elem1);
        int id2 = find(elem2);

        if (id1 == id2) return;
        for(int i = 0; i < id.length; i++) {
            if(id[i] == id1) id[i] = id2;
        }
        numComponent--;
    }

    public int totalComponents() {
        return this.numComponent;
    }
}
