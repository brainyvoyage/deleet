package com.brainyvoyage.alogs.search;


public class Search {

    public static int binarySearch(int[] data, int value, int left, int right) throws IndexOutOfBoundsException {
        if (right > data.length || left < 0) throw new IndexOutOfBoundsException();
        if (left > right) return -1;

        int middle = Math.floorDiv(left + right, 2);

        if (data[middle] == value) return middle;
        else if (data[middle] > value) return Search.binarySearch(data, value, middle + 1, right);
        else return Search.binarySearch(data, value, left, middle);
    }
}
