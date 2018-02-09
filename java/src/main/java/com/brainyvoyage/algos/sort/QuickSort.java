package com.brainyvoyage.algos.sort;

import com.brainyvoyage.algos.search.Search;

public class QuickSort {
    public static void sort(int[] data, int left, int right) {
        if (right >= data.length || left < 0) throw new IndexOutOfBoundsException();
        if (left >= right) return;

        int pivot = Search.partition(data, left, right);
        QuickSort.sort(data, left, pivot - 1);
        QuickSort.sort(data, pivot + 1, right);
    }
}
