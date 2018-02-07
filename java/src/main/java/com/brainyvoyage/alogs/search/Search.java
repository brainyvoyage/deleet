package com.brainyvoyage.alogs.search;


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
        else if (data[middle] > value) return Search.binarySearch(data, value, middle + 1, right);
        else return Search.binarySearch(data, value, left, middle);
    }

    public int binarySearch(List<T> data, T value, int left, int right) {
        searchLogger.info(String.format("Left = %d, Right = %d", left, right));

        if (right > data.size() || left < 0) throw new IndexOutOfBoundsException();
        if (left > right) return -1;

        int middle = Math.floorDiv(left + right, 2);

        if (this.compare(data.get(middle), value) == 0) return middle;
        else if (this.compare(value, data.get(middle)) > 0) return binarySearch(data, value, middle + 1, right);
        else return binarySearch(data, value, left, middle);
    }
}


