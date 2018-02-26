package com.brainyvoyage.algos.sort;

/**
 * Top down merge sort uses 1/2 * N * log(N) and N * log(N) compares
 * to sort and array of length N
 *
 * Lower bound of 1/2 * N * log(N) follows from fact that the number
 * of compares for the merge is at least floor(N/2)
 *
 * Top down merge sort uses at most 6N * log(N) array access
 * <ul>
 *     <li>
 *         2N for copy
 *     </li>
 *     <li>
 *         2N for move back
 *     </li>
 *     <li>
 *         at most 2N for compares
 *     </li>
 * </ul>
 *
 * Some facts
 * <ul>
 *     <li>
 *         If all the items have the same value, the running time is linear
 *     </li>
 *     <li>
 *         In practice, merge and shell sort running times are within a small
 *         constant factor of one another, so comparative performance depends
 *         on the implementations.
 *
 *         In theory, no one has been able to prove that shellsort is linearithmic
 *         for random data, so there remains the possibility that the asymptotic
 *         growth of the average-case performance of shellsort is higher. Such
 *         a gap has been proven for worst-case performance, but it is not relevant
 *         in practice.
 *     </li>
 * </ul>
 */

public class MergeSort {
    /*
     * The cost of creating a new array to hold the output every time
     * that we do a merge is problematic. It would be much more desirable
     * to have an in-place method so that we could sort the first half of
     * the array in place, then sort the second half of the array in place,
     * then do the merge of the two halves by moving the items around within
     * the array, without using a significant amount of other extra space.
     *
     * To avoid the overhead of creating an array for every merge, even the
     * tiny ones. This cost would dominate the running time of merge sort
     */
    private static Comparable[] auxiliary;

    private static void merge(Comparable[] data, int low, int mid, int high) {
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
