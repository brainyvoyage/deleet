package com.brainyvoyage.algos.string;

import com.brainyvoyage.datastructure.Queue;
import sun.dc.pr.PRError;

public class Tries<Value> {
    private static final int radix = 256;
    private Node root;

    private static class Node {
        private Object value;
        private Node[] next = new Node[radix];
    }

    @SuppressWarnings("unchecked")
    public Value get(String key) {
        Node node = get(root, key, 0);
        if (node == null) return null;
        return (Value) node.value;
    }

    private Node get(Node node, String key, int index) {
        if (node == null || index == key.length()) return node;
        char ch = key.charAt(index);
        return get(node.next[ch], key, index + 1);
    }

    public void put(String key, Value value) {
        root = put(root, key, value, 0);
    }

    private Node put(Node node, final String key, final Value value, int index) {
        if (node == null) node = new Node();
        if (key.length() == index) {
            node.value = value;
            return node;
        }
        char ch = key.charAt(index);
        node.next[ch] = put(node.next[ch], key, value, index + 1);
        return node.next[ch];
    }

    public Iterable<String> keyWithPrefix(String prefix) {
        Queue<String> queue = new Queue<>();
        collect(root, prefix, queue);
        return queue;
    }

    public Iterable<String> keys() {
        return keyWithPrefix("");
    }


    private void collect(Node node, String prefix, Queue<String> queue) {
        if (node == null) return;
        if (node.value != null) queue.enqueue(prefix);
        for (char ch = 0; ch < radix; ch++) {
            collect(node.next[ch], prefix + ch, queue);
        }
    }

    public Iterable<String> keysThatMatch(String pattern) {
        Queue<String> queue = new Queue<>();
        collect(root, "", pattern, queue);
        return queue;
    }

    private void collect(Node node, String prefix, String pattern, Queue<String> queue) {
        int prefixLen = prefix.length();
        if (node == null) return;
        if (prefixLen == pattern.length() && node.value != null) queue.enqueue(prefix);
        if (prefixLen == pattern.length()) return;

        char nextChar = pattern.charAt(prefixLen);
        for (char ch = 0; ch < radix; ch++) {
            if (nextChar == '.' || nextChar == ch)
                collect(node.next[ch], prefix + ch, pattern, queue);
        }
    }

}
