package com.brainyvoyage.algos.heap;


public class IndexMinPriorityQueue<Key extends Comparable<Key>> {
    private Key[] minPq;
    private int[] qp;
    private int size = 0;


    @SuppressWarnings("unchecked")
    public IndexMinPriorityQueue(int capacity){
        minPq = (Key[]) new Comparable[capacity];
    }

    public void insert(int index, Key item){}
    public void change(int index, Key item){}
    public boolean contains(int index){return false;}
    public void delete(int index){}
    public Key min() {return null;}
    public int minIndex(){return -1;}
    public int delMin(){return -1;}
    public boolean isEmpty(){return true;}
    public int size(){return 0;}
}
