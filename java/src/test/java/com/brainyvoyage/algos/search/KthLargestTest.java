package com.brainyvoyage.algos.search;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

import static org.junit.Assert.*;

public class KthLargestTest {

    private float element1 = 1.4f;
    private float element2 = 3.12f;
    private float element3 = 7.9f;

    private Random rand = new Random();
    private KthLargest<Float> kthLargest = new KthLargest<>();

    @Test
    public void compareEqual() {
        int compResult = kthLargest.compare(element1, element1);
        assert (compResult == 0);
    }

    @Test
    public void compareStrictLess() {
        int compResult = kthLargest.compare(element1, element2);
        assert (compResult < 0);
    }

    @Test
    public void compareStrictGreater() {
        int compResult = kthLargest.compare(element3, element2);
        assert (compResult > 0);
    }

    @Test
    public void kthLargestElementTest() {
        int data[] = {-1286317408, -634513151, -61035229, 86835269, 581808165, 610291422, 1481170226, 1699760854};

        int expected = -1286317408;
        int actual = KthLargest.find(data, 0);

        assertEquals(expected, actual);
    }

    @Test
    public void kthLargestBoundTest() {
        int data[] = {10, 80, 30, 90, 40, 50, 70};
        Exception expected = null;
        try {
            KthLargest.find(data, data.length);
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

            int actual = KthLargest.find(data, kLargestIndex);
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
            int actual = KthLargest.find(data, data.length + 2);
        } catch (IllegalArgumentException e) {
            expected = e;
        }

        assertNotEquals("No Exception", expected);
    }

}