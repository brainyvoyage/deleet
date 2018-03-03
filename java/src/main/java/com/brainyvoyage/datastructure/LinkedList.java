package com.brainyvoyage.datastructure;

import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item> {

    private class Node {
        Item item;
        Node next;
    }

    private int size;

    private class ListIterator implements Iterator<Item> {
        private Node current = head;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            // TODO: Not yet Implemented
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    private Node head;

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    /**
     * Adds item at the beginning of the list
     *
     * @param item
     */
    public void add(Item item) {
        Node currentHead = this.head;
        head = new Node();
        head.item = item;
        head.next = currentHead;
        size++;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }
}
