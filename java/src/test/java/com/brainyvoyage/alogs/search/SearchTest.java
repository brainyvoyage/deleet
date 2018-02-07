package com.brainyvoyage.alogs.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SearchTest {

    @Test
    public void binarySearchTestFound() {
        int[] data = {2, 8, 10, 15, 19, 32, 47};
        int searchFor = 15;
        int expected = 3;
        assertEquals(Search.binarySearch(data, searchFor, 0, data.length - 1), expected);

    }

    @Test
    public void binarySearchTestNotFound() {
        int[] data = {2, 8, 10, 15, 19, 32, 47};
        int searchFor = 14;
        int expected = -1;
        assertEquals(Search.binarySearch(data, searchFor, 0, data.length - 1), expected);

    }

    @Test
    public void binarySearchOutofBound() {
        int[] data = {2, 8, 10, 15, 19, 32, 47};
        int searchFor = 15;
        Exception expected = null;
        try {
            Search.binarySearch(data, searchFor, 0, data.length);
        } catch (IndexOutOfBoundsException e) {
            expected = e;
        }
        assertNotEquals("No Exception", expected);
    }

    @Test
    public void genericBinarySearchTest() {
        Search<Float> search = new Search<>();
        Random rand = new Random();
        ArrayList<Float> data = new ArrayList<>();
        int length = 25;
        for (int i = 0; i < length; i++) {
            data.add(rand.nextFloat());
        }
        Collections.sort(data);

        int expected = rand.nextInt(length);
        Float searchFor = data.get(expected);

        assertEquals(search.binarySearch(data, searchFor, 0, data.size() - 1), expected);

    }
}