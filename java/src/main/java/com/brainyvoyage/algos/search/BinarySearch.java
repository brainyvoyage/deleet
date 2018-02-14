package com.brainyvoyage.algos.search;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public class BinarySearch<T extends Comparable<T>> implements Comparator<T> {
    private Logger searchLogger = Logger.getGlobal();

    @Override
    public int compare(T el1, T el2) {
        return el1.compareTo(el2);
    }

    /**
     * @param data
     * @param value
     * @param left
     * @param right
     * @return
     * @throws IndexOutOfBoundsException
     */

    public static int search(int[] data, int value, int left, int right) throws IndexOutOfBoundsException {
        if (right > data.length || left < 0) throw new IndexOutOfBoundsException();
        if (left > right) return -1;

        int middle = Math.floorDiv(left + right, 2);

        if (data[middle] == value)
            return middle;
        else if (data[middle] > value)
            return BinarySearch.search(data, value, left, middle - 1);
        else
            return BinarySearch.search(data, value, middle + 1, right);
    }

    /**
     * @param data
     * @param value
     * @param left
     * @param right
     * @return
     * @throws IndexOutOfBoundsException
     */

    public int search(List<T> data, T value, int left, int right) throws IndexOutOfBoundsException {
        searchLogger.info(String.format("Left = %d, Right = %d", left, right));

        if (right > data.size() || left < 0) {
            searchLogger.severe(String.format("Index Out of bound. Applicable range [0 - %d), got [%d, %d]",
                    data.size(), left, right));
            throw new IndexOutOfBoundsException();
        }
        if (left >= right) return -1;

        int middle = Math.floorDiv(left + right, 2);

        if (this.compare(data.get(middle), value) == 0) return middle;
        else if (this.compare(value, data.get(middle)) > 0) return search(data, value, middle + 1, right);
        else return search(data, value, left, middle);
    }
}
