package com.brainyvoyage.algos.search;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class BinarySearchTest {
    private BinarySearch<Character> bstChar = new BinarySearch<>();
    private BinarySearch<Float> bstFloat = new BinarySearch<>();
    private BinarySearch<Double> bstDouble = new BinarySearch<>();

    private char element1 = 'd';
    private char element2 = 'k';
    private char element3 = 'z';

    private Random rand = new Random();

    @Test
    public void compareEqual() {
        int compResult = bstChar.compare(element1, element1);
        assert (compResult == 0);
    }

    @Test
    public void compareStrictLess() {
        int compResult = bstChar.compare(element1, element2);
        assert (compResult < 0);
    }

    @Test
    public void compareStrictGreater() {
        int compResult = bstChar.compare(element3, element2);
        assert (compResult > 0);
    }

    @Test
    public void randomBinarySearch() {
        Random rand = new Random();
        int numOfTest = Math.abs(rand.nextInt(100));
        HashSet<Integer> addedValue = new HashSet<>();

        for (int test = 0; test < numOfTest; test++) {
            int numElement = Math.abs(rand.nextInt(500));
            while (numElement == 0)
                numElement = Math.abs(rand.nextInt(500));

            addedValue.clear();
            while (addedValue.size() != numElement) {
                addedValue.add(rand.nextInt(10000));
            }

            int[] data = new int[numElement];
            int index = 0;
            for (int elem : addedValue) {
                data[index] = elem;
                index++;
            }

            int expected = Math.abs(rand.nextInt(numElement));
            Arrays.sort(data);
            int searchFor = data[expected];
            int actual = BinarySearch.search(data, searchFor, 0, data.length - 1);
            assertEquals(expected, actual);
        }
    }

    @Test
    public void binarySearchTestFound() {
        int[] data = {2, 8, 10, 15, 19, 32, 47};
        int searchFor = 15;
        int expected = 3;
        assert(BinarySearch.isDistinct(data));
        assertEquals(expected, BinarySearch.search(data, searchFor, 0, data.length - 1));
    }

    @Test
    public void binarySearchTestNotFound() {
        int[] data = {2, 8, 10, 15, 19, 32, 47};
        int searchFor = 14;
        int expected = -1;
        assertEquals(expected, BinarySearch.search(data, searchFor, 0, data.length - 1));

    }

    @Test
    public void binarySearchRightOutOfBound() {
        int[] data = {2, 8, 10, 15, 19, 32, 47};
        int searchFor = 15;
        Exception expected = null;
        try {
            BinarySearch.search(data, searchFor, 0, data.length);
        } catch (IndexOutOfBoundsException e) {
            expected = e;
        }
        assertNotEquals("No Exception", expected);
    }

    @Test
    public void binarySearchLeftOutOfBound() {
        int[] data = {2, 8, 10, 15, 19, 32, 47, 75};
        int searchFor = 15;
        Exception expected = null;
        try {
            BinarySearch.search(data, searchFor, -4, data.length - 1);
        } catch (IndexOutOfBoundsException e) {
            expected = e;
        }
        assertNotEquals("No Exception", expected);
    }

    @Test
    public void binarySearchLeftRightOutOfBound() {
        int[] data = {2, 8, 10, 15, 19, 37, 47, 94, 23};
        int searchFor = 15;
        Exception expected = null;
        try {
            BinarySearch.search(data, searchFor, -2, data.length + 8);
        } catch (IndexOutOfBoundsException e) {
            expected = e;
        }
        assertNotEquals("No Exception", expected);
    }

    @Test
    public void nonDistinctTest() {
        int[] data = {2, 8, 10, 15, 15, 15, 15, 32, 47};
        int searchFor = 15;
        int expected = -1;
        assertEquals(false, BinarySearch.isDistinct(data));
        assertEquals(expected, BinarySearch.search(data, searchFor, 0, data.length - 1));
        int[] distinctData = {2, 8, 10, 15, 32, 47};
        assertEquals(true, BinarySearch.isDistinct(distinctData));

        ArrayList<Double> nonDistinctData = new ArrayList<>();
        for (int elem: data) nonDistinctData.add(elem * 1.0);

        assertEquals(-1, bstDouble.search(nonDistinctData, searchFor * 1.0, 0, nonDistinctData.size() - 1));
    }

    @Test
    public void genericBinarySearchTest() {
        ArrayList<Float> data = new ArrayList<>();
        int length = 25;
        for (int i = 0; i < length; i++) {
            data.add(rand.nextFloat());
        }
        Collections.sort(data);

        int expected = rand.nextInt(length);
        Float searchFor = data.get(expected);

        assertEquals(bstFloat.search(data, searchFor, 0, data.size() - 1), expected);

        assertEquals(-1, bstFloat.search(data, searchFor, 3, 3));
        assertEquals(-1, bstFloat.search(data, searchFor, 5, 3));

    }

    @Test
    public void genericBSTRightBoundTest() {
        ArrayList<Float> data = new ArrayList<>();
        int length = 25;
        for (int i = 0; i < length; i++) {
            data.add(rand.nextFloat());
        }
        Collections.sort(data);
        Exception excepted = null;
        try {
            bstFloat.search(data, 0.0f, 0, data.size() + 3);
        } catch (IndexOutOfBoundsException e) {
            excepted = e;
        }
        assertNotEquals("No Exception", excepted);
    }

    @Test
    public void genericBSTLeftBoundTest() {
        ArrayList<Float> data = new ArrayList<>();
        int length = 55;
        for (int i = 0; i < length; i++) {
            data.add(rand.nextFloat());
        }
        Collections.sort(data);
        Exception excepted = null;
        try {
            bstFloat.search(data, 0.0f, -3, data.size() - 1);
        } catch (IndexOutOfBoundsException e) {
            excepted = e;
        }
        assertNotEquals("No Exception", excepted);
    }

    @Test
    public void genericBinarySearchOutOfBoundTest() {
        ArrayList<Double> data = new ArrayList<>();
        int length = 25;
        for (int i = 0; i < length; i++) {
            data.add(rand.nextDouble());
        }
        Collections.sort(data);

        int index = rand.nextInt(length);
        Double searchFor = data.get(index);
        Exception expected = null;

        try {
            assertEquals(bstDouble.search(data, searchFor, 0, data.size()), index);
        } catch (IndexOutOfBoundsException e) {
            expected = e;
        }
        assertNotEquals("No Exception", expected);

        try {
            assertEquals(bstDouble.search(data, searchFor, -5, data.size() - 1), index);
        } catch (IndexOutOfBoundsException e) {
            expected = e;
        }
        assertNotEquals("No Exception", expected);
    }
}