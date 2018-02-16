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



    public static int kthLargestElement(int[] data, int k) {
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

}


