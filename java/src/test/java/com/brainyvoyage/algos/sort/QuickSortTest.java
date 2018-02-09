package com.brainyvoyage.algos.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSortTest {
    int[] data = {10, 80, 30, 90, 40, 50, 70};
    int[] expected = {10, 30, 40, 50, 70, 80, 90};

    @Test
    public void sortTest() {

        QuickSort.sort(data, 0, data.length - 1);

        assertArrayEquals(expected, data);
    }

    @Test
    public void indexOutOfBoundTestRight() {
        Exception expected = null;
        try{
            QuickSort.sort(data, 0, data.length);
        }catch (IndexOutOfBoundsException e){
            expected = e;
        }
        assertNotEquals("No Exception", expected);
    }

    @Test
    public void indexOutOfBoundTestLeft() {
        Exception expected = null;
        try{
            QuickSort.sort(data, -1, data.length - 1);
        }catch (IndexOutOfBoundsException e){
            expected = e;
        }
        assertNotEquals("No Exception", expected);
    }
}