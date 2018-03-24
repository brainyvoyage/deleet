package com.brainyvoyage.datastructure;

import java.util.Iterator;
import java.util.Optional;

public class LinkedList<Item> implements Iterable<Item> {
    private Optional<Node<Item>> head;
    private Optional<Node<Item>> last;
    private int size;

    public LinkedList() {
        last = Optional.ofNullable(null);
        head = Optional.ofNullable(null);
    }

    /**
     * Adds item at the beginning of the list
     *
     * @param item
     */
    public void add(Item item) {
        Optional<Node<Item>> currentHead = this.head;
        Node<Item> node = new Node<>();
        node.item = item;
        node.next = currentHead;
        head = Optional.of(node);
        if(!currentHead.isPresent()) last = head;
//        if (currentHead == null) last = Optional.of(head);
        size++;
    }

    public void append(Item item) {
        Node<Item> node = new Node<>();
        node.item = item;
        node.next = Optional.ofNullable(null);
        last.ifPresent(itemNode -> itemNode.next = Optional.of(node));
        last = Optional.of(node);
        if(!head.isPresent()) head = Optional.of(node);
//        if (head == null) head = node;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Item getHead(){
        return head.get().item;
    }

    public Item getLast() {
        return last.get().item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class Node<Item> {
        Item item;
        Optional<Node<Item>> next;
    }
    private class ListIterator implements Iterator<Item> {
        private Optional<Node<Item>> current = head;

        public boolean hasNext() {
            return current.isPresent();
        }

        public void remove() {
            // TODO: Not yet Implemented
        }

        public Item next() {
            Item item = current.get().item;
            current = current.get().next;
            return item;
        }
    }
}
