package com.brainyvoyage.algos.search;


import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Logger;

public class BinarySearch<T extends Comparable<T>> implements Comparator<T> {
    private Logger searchLogger = Logger.getGlobal();

    public static boolean isDistinct(final int[] data){
        HashSet<Integer> hashedData = new HashSet<>();
        for(int elem: data){
            if(hashedData.contains(elem))
                return false;
            else hashedData.add(elem);
        }
        return true;
    }

    private boolean isDistinct(final List<T> data){
        HashSet<T> hashedData = new HashSet<>();
        for(T elem: data){
            if(hashedData.contains(elem)) return false;
            else hashedData.add(elem);
        }
        return true;
    }

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

        if(!BinarySearch.isDistinct(data)) {
            System.err.println("Elements are not unique. The returned result will vary");
            return -1;
        }

        int middle = (left + right) >> 1;

        if (data[middle] == value)
            return middle;
        else if (data[middle] > value)
            return BinarySearch.search(data, value, left, middle - 1);
        else
            return BinarySearch.search(data, value, middle + 1, right);
    }

    public int search(List<T> data, T value, int left, int right) throws IndexOutOfBoundsException {
        if(!isDistinct(data)) return -1;
        else return searcher(data, value, left, right);
    }

    /**
     * @param data
     * @param value
     * @param left
     * @param right
     * @return
     * @throws IndexOutOfBoundsException
     */

    private int searcher(List<T> data, T value, int left, int right) throws IndexOutOfBoundsException {
        searchLogger.info(String.format("Left = %d, Right = %d", left, right));

        if (right > data.size() || left < 0) {
            searchLogger.severe(String.format("Index Out of bound. Applicable range [0 - %d), got [%d, %d]",
                    data.size(), left, right));
            throw new IndexOutOfBoundsException();
        }
        if (left >= right) return -1;

        int middle = (left + right) >> 1;

        if (this.compare(data.get(middle), value) == 0) return middle;
        else if (this.compare(value, data.get(middle)) > 0) return searcher(data, value, middle + 1, right);
        else return searcher(data, value, left, middle);
    }
}
