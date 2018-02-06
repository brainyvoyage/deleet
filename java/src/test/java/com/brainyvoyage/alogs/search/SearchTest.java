package com.brainyvoyage.alogs.search;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

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
}