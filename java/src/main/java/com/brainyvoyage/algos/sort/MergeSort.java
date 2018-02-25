package com.brainyvoyage.algos.sort;

public class MergeSort {
    private static Comparable[] auxiliary;

    public static void merge(Comparable[] data, int low, int mid, int high) {
        int leftSubArrayIndex = low;
        int rightSubArrayIndex = mid + 1;

        System.arraycopy(data, low, auxiliary, low, high - low + 1);
        /*
         * leftSubArrayIndex - mid is left sub array
         * rightSubArrayIndex - high is right sub array
         */
        for (int k = low; k <= high; k++) {
            // First two Boundary cases

            // Left sub-array is already merged (leftSubArrayIndex > mid)
            //      then put all the elements from right sub-array
            if (leftSubArrayIndex > mid) {
                data[k] = auxiliary[rightSubArrayIndex++];
            }

            // Right sub-array is already merged (rightSubArrayIndex > high)
            //      then put all the elements from left sub-array
            else if (rightSubArrayIndex > high) {
                data[k] = auxiliary[leftSubArrayIndex++];
            }

            // else put the smallest one at data[k]
            else if (SortUtils.less(auxiliary[rightSubArrayIndex], auxiliary[leftSubArrayIndex]))
                data[k] = auxiliary[rightSubArrayIndex++];
            else data[k] = auxiliary[leftSubArrayIndex++];
        }
    }

    public static void sort(Comparable[] data) {
        auxiliary = new Comparable[data.length];
        sort(data, 0, data.length - 1);
    }

    private static void sort(Comparable[] data, int low, int high) {
        if (high <= low) return;
        int mid = low + (high - low) / 2;
        sort(data, low, mid);
        // Sort left half
        sort(data, mid + 1, high);
        // Sort right half
        merge(data, low, mid, high);
    }
}
