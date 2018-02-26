package com.brainyvoyage.algos.sort;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class InsertionSortTest {

    private static Integer[] data = {10, 80, 30, 90, 40, 50, 70};
    private static Integer[] expected = {10, 30, 40, 50, 70, 80, 90};

    private static Random rand = new Random();

    private static void shuffle() {
        int j;
        for(int i = 0; i < data.length; i++) {
            j = rand.nextInt(data.length);
            SortUtils.swap(data, i, j);
        }
    }

    @Test
    public void sortTest() {
        InsertionSort.sort(data);
        SortUtils.show(data);
        assertArrayEquals(expected, data);
    }

    @Test
    public void sortRangeTest() {
        shuffle();
        data[0] = 10; data[1] = 80; data[2] = 30;
        data[3] = 90;
        InsertionSort.sort(data, 0, 4);
        expected[0] = 10; expected[1] = 30;
        expected[2] = 80; expected[3] = 90;

        for(int i = 0; i < 4; i++) {
            assertEquals(expected[i], data[i]);
        }
    }
}