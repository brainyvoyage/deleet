package com.brainyvoyage.algos.sort;

public class SelectionSort {
    public static void sort(Comparable[] data) {
        if (data == null)
            throw new IllegalArgumentException("Array to be sorted cannot be null");

        if (data.length < 2)
            return;

        for (int i = 0; i < data.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++)
                if (SortUtils.less(data[j], data[minIndex])) minIndex = j;

            SortUtils.swap(data, i, minIndex);
        }
    }
}
