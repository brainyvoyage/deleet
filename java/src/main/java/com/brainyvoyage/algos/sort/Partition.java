package com.brainyvoyage.algos.sort;

public class Partition {
    public static int partition(Comparable[] data, int low, int high) {
        Comparable pivot = data[high];
        int lowIndex = low;
        int currentElementIndex = low - 1;

        for (; lowIndex < high; lowIndex++ ){
            if (less(data[lowIndex], pivot)) {
                currentElementIndex++;
                Comparable temp = data[currentElementIndex];
                data[currentElementIndex] = data[lowIndex];
                data[lowIndex] = temp;
            }
        }

        currentElementIndex++;
        Comparable temp = data[currentElementIndex];
        data[currentElementIndex] = pivot;
        data[high] = temp;
        return currentElementIndex;
    }

    @SuppressWarnings("unchecked")
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
