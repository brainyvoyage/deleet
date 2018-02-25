package com.brainyvoyage.algos.sort;

public class QuickSort {

    private static int partition(Comparable[] data, int low, int high) {
        Comparable pivot = data[high];
        int lowIndex = low;
        int currentElementIndex = low - 1;

        for (; lowIndex < high; lowIndex++ ){
            if (less(data[lowIndex], pivot) ) {
                swap(data, ++currentElementIndex, lowIndex);
            }
        }
        swap(data, ++currentElementIndex, high);

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

    @SuppressWarnings("unchecked")
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }
}
