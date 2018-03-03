package com.brainyvoyage.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class Queue<Item> implements Iterable<Item> {
    private static class Node<Item> {
        public Item item;
        public Node<Item> next;
    }

    private Node<Item> first;
    private Node<Item> last;
    private int size = 0;

    private Node<Item> createNode(Item item) {
        Node node = new Node();
        node.item = item;
        node.next = null;
        return node;
    }

    public void enqueue(Item item) {
        Node<Item> oldLast = this.last;
        last = createNode(item);
        if (isEmpty()) first = last;
        else oldLast.next = last;
        size++;

    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        Item item = first.item;
        first = first.next;
        size--;
        return item;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item item : this) {
            sb.append(item).append(" ");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
