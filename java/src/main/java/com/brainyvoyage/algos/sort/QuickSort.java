package com.brainyvoyage.algos.sort;

import com.brainyvoyage.algos.search.Partition;

import java.util.List;

public class QuickSort<T extends Comparable<T>> {
    Partition<T> partitioner = new Partition<T>();

    public static void sort(int[] data, int left, int right) {
        if (right >= data.length || left < 0) throw new IndexOutOfBoundsException();
        if (left >= right) return;

        int pivot = Partition.partition(data, left, right);
        QuickSort.sort(data, left, pivot - 1);
        QuickSort.sort(data, pivot + 1, right);
    }

    public void sort(List<T> data, int left, int right) {
        if (right >= data.size() || left < 0) throw new IndexOutOfBoundsException();
        if (left >= right) return;

        int pivot = partitioner.partition(data, left, right);
        sort(data, left, pivot - 1);
        sort(data, pivot + 1, right);
    }
}
