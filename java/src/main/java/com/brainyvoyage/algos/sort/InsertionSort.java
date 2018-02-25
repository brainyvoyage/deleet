package com.brainyvoyage.algos.sort;

/**
 * Insertion sort is similar to sorting deck of cards starting with empty
 * hand. Every time one picks up the new card, it is placed into its correct
 * sorted position.
 * <p>
 * Insertion sort uses ~N^2/4 compares and ~N^2/4 exchanges to sort
 * a randomly ordered data of length N with distinct keys, on the average.
 * The worst case is ~N^2/2 compares and ~N^2/2 exchanges and the best
 * case is N - 1 compares and 0 exchanges.
 * <p>
 * Pros:
 * <ol>
 * <li>Stable sort.</li>
 * <li> Works better with not so random array that arises in
 * practice (partially sorted, already sorted, few elements)
 * </li>
 * </ol>
 * <p>
 * Cons: Quadratic runtime for unordered data
 */
public class InsertionSort {
    public static void sort(Comparable[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = i; j > 0 && SortUtils.less(data[j], data[j - 1]); j++)
                SortUtils.swap(data, j, j - 1);
        }
    }
}
