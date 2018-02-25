package com.brainyvoyage.algos.sort;

import org.junit.Test;
import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class QuickSortTest {

    private Integer[] data = {10, 80, 30, 90, 40, 50, 70};
    private Integer[] expected = {10, 30, 40, 50, 70, 80, 90};
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
    public void isSortedTest() {
        Integer[] unSorted = {10, 80, 30, 90, 40, 50, 70};
        assert (!QuickSort.isSorted(unSorted));
        QuickSort.sort(unSorted);
        assert (QuickSort.isSorted(unSorted));

    }

    @Test
    public void genericQuickSort() {
        int numTest = 0;
        while (numTest <= 10) numTest = randGen.nextInt(30);
        for (int test = 0; test < numTest; test++) {
            int numSample = 0;
            while (numSample <= 0) numSample = randGen.nextInt(1000);
            Float[] data = new Float[numSample];
            for(int i =0; i < numSample; i++) data[i]= randGen.nextFloat();
            Float[] sorted = data.clone();
            Arrays.sort(sorted);
            QuickSort.sort(data);
            assertArrayEquals(sorted, data);
        }

    }
}
