package com.brainyvoyage.algos.search;

public class Search {

    public static int finbonacciSearch(int[] data, int key) {
        int nMinus2FibNum = 0;
        int nMinus1FibNum = 1;
        int nthFibNum = nMinus1FibNum + nMinus2FibNum;

        while (nthFibNum < data.length){
            nMinus2FibNum = nMinus1FibNum;
            nMinus1FibNum = nthFibNum;
            nthFibNum = nMinus1FibNum + nMinus2FibNum;
        }


        return 0;
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

        while (high >= low) {
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

}


