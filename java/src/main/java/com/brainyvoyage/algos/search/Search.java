package com.brainyvoyage.algos.search;


import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public class Search<T extends Comparable<T>> implements Comparator<T> {
    private Logger searchLogger = Logger.getGlobal();

    public int compare(T el1, T el2) {
        return el1.compareTo(el2);
    }

    public static int binarySearch(int[] data, int value, int left, int right) throws IndexOutOfBoundsException {
        if (right > data.length || left < 0) throw new IndexOutOfBoundsException();
        if (left > right) return -1;

        int middle = Math.floorDiv(left + right, 2);

        if (data[middle] == value) return middle;
        else if (data[middle] > value) return Search.binarySearch(data, value, left, middle-1);
        else return Search.binarySearch(data, value, middle + 1, right);
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

    public static int kthLargestElement(int[] data, int k) {
        if (k > data.length) throw new IllegalArgumentException();

        int low = 0;
        int high = data.length - 1;
        int pivotIndex = -1;
        while (high > low) {
            /* Find the rank of pivot element (data[pivot]) */
            pivotIndex = partition(data, low, high);

            /* Look in left side or right side of pivot element depending on its rank */
            if (pivotIndex > k) {
                high = pivotIndex - 1;   // Look Left
            } else if (pivotIndex < k) {
                low = pivotIndex + 1;    // Look Right
            } else break;                // Found the k largest
        }

        return data[pivotIndex];
    }

    public int binarySearch(List<T> data, T value, int left, int right) throws IndexOutOfBoundsException {
        searchLogger.info(String.format("Left = %d, Right = %d", left, right));

        if (right > data.size() || left < 0) {
            searchLogger.severe(String.format("Index Out of bound. Applicable range [0 - %d), got [%d, %d]",
                    data.size(), left, right));
            throw new IndexOutOfBoundsException();
        }
        if (left > right) return -1;

        int middle = Math.floorDiv(left + right, 2);

        if (this.compare(data.get(middle), value) == 0) return middle;
        else if (this.compare(value, data.get(middle)) > 0) return binarySearch(data, value, middle + 1, right);
        else return binarySearch(data, value, left, middle);
    }
}


