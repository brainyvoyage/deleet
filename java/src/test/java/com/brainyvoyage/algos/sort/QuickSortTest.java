package com.brainyvoyage.algos.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static org.junit.Assert.*;

public class QuickSortTest {
    private int[] data = {10, 80, 30, 90, 40, 50, 70};
    private int[] expected = {10, 30, 40, 50, 70, 80, 90};
    private QuickSort<Float> quick = new QuickSort<>();
    private Random randGen = new Random();

    @Test
    public void sortTest() {

        QuickSort.sort(data, 0, data.length - 1);

        assertArrayEquals(expected, data);
    }

    @Test
    public void indexOutOfBoundTestRight() {
        Exception expected = null;
        try {
            QuickSort.sort(data, 0, data.length);
        } catch (IndexOutOfBoundsException e) {
            expected = e;
        }
        assertNotEquals("No Exception", expected);
    }

    @Test
    public void indexOutOfBoundTestLeft() {
        Exception expected = null;
        try {
            QuickSort.sort(data, -1, data.length - 1);
        } catch (IndexOutOfBoundsException e) {
            expected = e;
        }
        assertNotEquals("No Exception", expected);
    }

    @Test
    public void genericQuickSort() {
        int numTest = 0;
        ArrayList<Float> data = new ArrayList<>();
        while (numTest <= 10) numTest = randGen.nextInt(30);
        for (int test = 0; test < numTest; test++) {
            data.clear();
            int numSample = 0;
            while (numSample <= 0) numSample = randGen.nextInt(1000);
            while (data.size() != numSample) data.add(randGen.nextFloat());
            ArrayList<Float> sorted = new ArrayList<>(data);
            Collections.sort(sorted);
            quick.sort(data, 0, data.size() - 1);
            for (int i = 0; i < data.size(); i++) {
                assertEquals(sorted.get(i), data.get(i));
            }
        }

    }
}
