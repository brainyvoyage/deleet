package com.brainyvoyage.algos.search;

import java.util.Comparator;
import java.util.List;

public class ExponentialSearch<T extends Comparable<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }

    public static int search(int[] data, int key) {
        if (data[0] == key) return 0;
        int i = 1;
        while (i < data.length && data[i] <= key) i <<= 1;
        return BinarySearch.search(data, key, i >> 1, Math.min(i, data.length));
    }

    public int search(List<T> data, T key){
        if(data.get(0) == key) return 0;
        int i = 1;
        while(i < data.size() && data.get(i).compareTo(key) <= 0) i <<= 1;
        BinarySearch<T> bst = new BinarySearch<>();
        return bst.search(data, key,i >> 1, Math.min(i, data.size()));
    }
}
