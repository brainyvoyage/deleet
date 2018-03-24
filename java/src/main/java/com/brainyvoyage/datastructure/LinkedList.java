package com.brainyvoyage.datastructure;

import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item> {

    private class Node<Item> {
        Item item;
        Node<Item> next;
    }



    private class ListIterator implements Iterator<Item> {
        private Node<Item> current = head;

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
    private int size;
    private Node<Item> head;
    private Node<Item> last;

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
        Node<Item> currentHead = this.head;
        head = new Node<>();
        head.item = item;
        head.next = currentHead;
        if (currentHead == null) last = head;
        size++;
    }

    public void append(Item item) {
        Node<Item> node = new Node<>();
        node.item = item;
        node.next = null;
        if (last != null) last.next = node;
        last = node;
        if (head == null) head = node;
        size++;
    }

    public Item getHead(){
        return head.item;
    }

    public Item getLast() {
        return last.item;
    }



    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }
}
