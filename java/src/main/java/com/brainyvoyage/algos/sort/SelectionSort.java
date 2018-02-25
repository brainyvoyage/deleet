package com.brainyvoyage.algos.sort;

/**
 * Finds the first smallest element and replaces with first element
 * and then finds second smallest element and replace with second element
 * and so on...
 *
 * Selection sort uses ~N^2/2 compares and N exchanges to sort an
 * array of length N.
 *
 * Pros: Data movement is minimal (Only N exchanges)
 *
 * Cons: Running time insensitive to input. Takes same amount of time
 * for sorted or unsorted data
 *
 */
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
