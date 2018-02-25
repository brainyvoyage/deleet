package com.brainyvoyage.algos.sort;

public class QuickSort {

    private static int partition(Comparable[] data, int low, int high) {
        Comparable pivot = data[high];
        int lowIndex = low;
        int currentElementIndex = low - 1;

        for (; lowIndex < high; lowIndex++ ){
            if (SortUtils.less(data[lowIndex], pivot) ) {
                SortUtils.swap(data, ++currentElementIndex, lowIndex);
            }
        }
        SortUtils.swap(data, ++currentElementIndex, high);

        return currentElementIndex;
    }

    public static void sort(Comparable[] data) {
        QuickSort.sort(data, 0, data.length - 1);
    }

    public static void sort(Comparable[] data, int left, int right) {
        if (right >= data.length || left < 0) throw new IndexOutOfBoundsException();
        if (left >= right) return;

        int pivot = partition(data, left, right);
        sort(data, left, pivot - 1);
        sort(data, pivot + 1, right);
    }
}
