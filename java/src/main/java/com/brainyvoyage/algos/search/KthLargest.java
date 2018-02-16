package com.brainyvoyage.algos.search;

import java.util.Comparator;
import java.util.List;

public class KthLargest<T extends Comparable<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }

    public static int find(int[] data, int k) {
        if (k > data.length) throw new IllegalArgumentException();

        int low = 0;
        int high = data.length - 1;
        int pivotIndex = -1;

        while (high >= low) {
            /* Find the rank of pivot element (data[pivot]) */
            pivotIndex = Partition.partition(data, low, high);
            /* Look in left side or right side of pivot element depending on its rank */
            if (pivotIndex > k) {
                high = pivotIndex - 1;   // Look Left
            } else if (pivotIndex < k) {
                low = pivotIndex + 1;    // Look Right
            } else break;                // Found the k largest
        }

        return data[pivotIndex];
    }

    public T find(final List<T> data, final int kth) {
        if (data.size() < kth) throw new IllegalArgumentException();
        Partition<T> partitioner = new Partition<>();
        int pivotIndex = -1;
        int low = 0;
        int high = data.size() - 1;

        while (high >= low) {
            pivotIndex = partitioner.partition(data, low, high);
            if (pivotIndex < kth) low = pivotIndex + 1;
            else if (pivotIndex > kth) high = pivotIndex - 1;
            else break;
        }
        return data.get(pivotIndex);
    }
}
