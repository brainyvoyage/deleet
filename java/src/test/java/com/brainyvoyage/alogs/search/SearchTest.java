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

    @Test
    public void genericBinarySearchOutOfBoundTest() {
        Search<Double> search = new Search<>();
        Random rand = new Random();
        ArrayList<Double> data = new ArrayList<>();
        int length = 25;
        for (int i = 0; i < length; i++) {
            data.add(rand.nextDouble());
        }
        Collections.sort(data);

        int index = rand.nextInt(length);
        Double searchFor = data.get(index);
        Exception expected = null;

        try{
            assertEquals(search.binarySearch(data, searchFor, 0, data.size()), index);
        }catch (IndexOutOfBoundsException e){
            expected = e;
        }
        assertNotEquals("No Exception", expected);
    }

    @Test
    public void partitionTest() {
        int data[] = {10, 80, 30, 90, 40, 50, 70};
        int expected = 4;
        for (int item :
                data) {
            System.out.print(item + ", ");
        }
        int actual = Search.partition(data, 0, data.length - 1);
        System.out.println();
        for (int item :
                data) {
            System.out.print(item + ", ");
        }
        System.out.println();
        assertEquals(expected, actual);

        assertEquals(70, data[actual]);
    }
}