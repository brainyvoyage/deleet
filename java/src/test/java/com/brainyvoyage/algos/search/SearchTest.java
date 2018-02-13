package com.brainyvoyage.algos.search;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SearchTest {

    @Test
    public void randomBinarySearch() {
        Random rand = new Random();
        int numOfTest = Math.abs(rand.nextInt(100000));
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
            int actual = Search.binarySearch(data, searchFor, 0, data.length - 1);
            if (actual != expected) {
                for (int x :
                        data) {
                    System.err.print(x + ", ");
                }
                System.err.println();
                System.err.println(String.format("Expectd = %d, Searched for = %d, Location Value = %d, Actual = %d",
                        expected, searchFor, data[expected], actual));
            }
            assertEquals(expected, actual);
        }
    }

    @Test
    public void randomExponentialSearch() {
        Random rand = new Random();
        int numOfTest = Math.abs(rand.nextInt(100000));
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
            int actual = Search.exponentialSearch(data, searchFor);
//            if (actual != expected) {
//                for (int x :
//                        data) {
//                    System.err.print(x + ", ");
//                }
//                System.err.println();
//                System.err.println(String.format("Expectd = %d, Searched for = %d, Location Value = %d, Actual = %d",
//                        expected, searchFor, data[expected], actual));
//            }
            assertEquals(expected, actual);
        }
    }

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
    public void binarySearchRightOutOfBound() {
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
    public void binarySearchLeftOutOfBound() {
        int[] data = {2, 8, 10, 15, 19, 32, 47, 75};
        int searchFor = 15;
        Exception expected = null;
        try {
            Search.binarySearch(data, searchFor, -4, data.length - 1);
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
            Search.binarySearch(data, searchFor, -2, data.length + 8);
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
    public void genericBSTRightBoundTest() {
        Search<Float> search = new Search<>();
        Random rand = new Random();
        ArrayList<Float> data = new ArrayList<>();
        int length = 25;
        for (int i = 0; i < length; i++) {
            data.add(rand.nextFloat());
        }
        Collections.sort(data);
        Exception excepted = null;
        try {
            search.binarySearch(data, 0.0f, 0, data.size() + 3);
        } catch (IndexOutOfBoundsException e) {
            excepted = e;
        }
        assertNotEquals("No Exception", excepted);
    }

    @Test
    public void genericBSTLeftBoundTest() {
        Search<Float> search = new Search<>();
        Random rand = new Random();
        ArrayList<Float> data = new ArrayList<>();
        int length = 55;
        for (int i = 0; i < length; i++) {
            data.add(rand.nextFloat());
        }
        Collections.sort(data);
        Exception excepted = null;
        try {
            search.binarySearch(data, 0.0f, -3, data.size() - 1);
        } catch (IndexOutOfBoundsException e) {
            excepted = e;
        }
        assertNotEquals("No Exception", excepted);
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

        try {
            assertEquals(search.binarySearch(data, searchFor, 0, data.size()), index);
        } catch (IndexOutOfBoundsException e) {
            expected = e;
        }
        assertNotEquals("No Exception", expected);

        try {
            assertEquals(search.binarySearch(data, searchFor, -5, data.size() - 1), index);
        } catch (IndexOutOfBoundsException e) {
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

    @Test
    public void partitionOutOfBoundRightTest() {
        int data[] = {10, 80, 30, 90, 40, 50, 70};
        Exception expected = null;
        try {
            Search.partition(data, 0, data.length + 1);
        } catch (IndexOutOfBoundsException e) {
            expected = e;
        }
        assertNotEquals("No Exception", expected);

        try {
            Search.partition(data, -4, data.length - 1);
        } catch (IndexOutOfBoundsException e) {
            expected = e;
        }
        assertNotEquals("No Exception", expected);
    }

    @Test
    public void partitionOutOfBoundLeftTest() {
        int data[] = {10, 80, 30, 90, 40, 50, 70};
        Exception expected = null;
        try {
            Search.partition(data, data.length + 1, data.length);
        } catch (IndexOutOfBoundsException e) {
            expected = e;
        }
        assertNotEquals("No Exception", expected);
    }

    @Test
    public void kthLargestElementTest() {
        int data[] = {-1286317408, -634513151, -61035229, 86835269, 581808165, 610291422, 1481170226, 1699760854};

        int expected = -1286317408;
        int actual = Search.kthLargestElement(data, 0);

        assertEquals(expected, actual);
    }

    @Test
    public void kthLargestBoundTest() {
        int data[] = {10, 80, 30, 90, 40, 50, 70};
        Exception expected = null;
        try {
            Search.kthLargestElement(data, data.length);
        } catch (IllegalArgumentException e) {
            expected = e;
        }
        assertNotEquals("No exception", expected);
    }

    @Test
    public void randomKthLargestTest() {
        HashSet<Integer> distinctValues = new HashSet<>();
        Random rand = new Random();
        int numOfTest = Math.abs(rand.nextInt(10000));

        for (int test = 0; test < numOfTest; test++) {
            distinctValues.clear();
            int numElement = Math.abs(rand.nextInt(1000));
            while (numElement == 0) {
                numElement = Math.abs(rand.nextInt(1000));
            }
            while (distinctValues.size() != numElement) {
                distinctValues.add(rand.nextInt());
            }
            int[] data = new int[numElement];
            int index = 0;
            for (int elem : distinctValues) {
                data[index] = elem;
                index++;
            }

            Arrays.sort(data);
            int kLargestIndex = Math.abs(rand.nextInt(numElement));
            int expected = data[kLargestIndex];

            index = 0;
            for (int elem : distinctValues) {
                data[index] = elem;
                index++;
            }

            int actual = Search.kthLargestElement(data, kLargestIndex);
            if (actual != expected) {
                Arrays.sort(data);
                for (int elem : data) {
                    System.out.print(elem + ", ");
                }
                System.out.println();
                System.out.println(String.format("Index = %d, Expected = %d, found = %d", kLargestIndex, expected, actual));
            }

            assertEquals(expected, actual);
        }
    }

    @Test
    public void kLargestElementIllegalArg() {
        int data[] = {-1286317408, -634513151, -61035229, 86835269, 581808165, 610291422, 1481170226, 1699760854};

        Exception expected = null;
        try {
            int actual = Search.kthLargestElement(data, data.length + 2);
        } catch (IllegalArgumentException e) {
            expected = e;
        }

        assertNotEquals("No Exception", expected);
    }

    @Test
    public void randomInterpolationSearchTest() {
        Random rand = new Random();
        int numOfTest = Math.abs(rand.nextInt(100000));
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
            int actual = Search.interpolationSearch(data, searchFor, 0, data.length - 1);

            assertEquals(expected, actual);
        }
    }
}