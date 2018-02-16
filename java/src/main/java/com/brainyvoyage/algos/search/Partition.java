package com.brainyvoyage.algos.search;

import java.util.Comparator;
import java.util.List;

/**
 * @param <T>
 */
public class Partition<T extends Comparable<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }

    /**
     * Partition data in range [low - high] around the pivot such that all
     * element left of pivot is smaller that pivot and right of pivot is larger.
     * The pivot element is the last element i.e. data[high]
     *
     * @param data: Array of int. Elements in array is expected to be distinct
     * @param low:  Positive int greater that 0
     * @param high: Positive int less that length of data
     * @return index of pivot element. It is the location where pivot would be if
     * data were sorted.
     */
    public static int partition(int[] data, int low, int high) {
        if (low > high) return -1;
        if (high > data.length) return -1;

        int smallerValueIndex = low - 1;
        int pivot = data[high];
        int currentElementIndex = low;

        for (; currentElementIndex < high; currentElementIndex++) {
            if (data[currentElementIndex] <= pivot) {
                smallerValueIndex++;
                int temp = data[smallerValueIndex];
                data[smallerValueIndex] = data[currentElementIndex];
                data[currentElementIndex] = temp;
            }
        }
        smallerValueIndex++;
        int temp = data[smallerValueIndex];
        data[smallerValueIndex] = pivot;
        data[currentElementIndex] = temp;
        return smallerValueIndex;
    }

    /**
     * @param data
     * @param left
     * @param right
     * @return
     */
    public int partition(List<T> data, int left, int right) {
        if (left > right) return -1;
        if (right > data.size()) return -1;

        int smallerValueIndex = left - 1;
        T pivot = data.get(right);
        int currentElementIndex = left;

        for (; currentElementIndex < right; currentElementIndex++) {
            if (data.get(currentElementIndex).compareTo(pivot) <= 0) {
                smallerValueIndex++;
                T temp = data.get(smallerValueIndex);
                data.set(smallerValueIndex, data.get(currentElementIndex));
                data.set(currentElementIndex, temp);
            }
        }
        smallerValueIndex++;
        T temp = data.get(smallerValueIndex);
        data.set(smallerValueIndex, pivot);
        data.set(currentElementIndex, temp);
        return smallerValueIndex;
    }
}
