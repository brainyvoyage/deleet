package com.brainyvoyage.algos.search;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ExponentialSearchTest {

    private ExponentialSearch<Character> expChar = new ExponentialSearch<>();
    private ExponentialSearch<Float> expFloat = new ExponentialSearch<>();

    private char element1 = 'd';
    private char element2 = 'k';
    private char element3 = 'z';

    private Random rand = new Random();

    @Test
    public void compareEqual() {
        int compResult = expChar.compare(element1, element1);
        assert (compResult == 0);
    }

    @Test
    public void compareStrictLess() {
        int compResult = expChar.compare(element1, element2);
        assert (compResult < 0);
    }

    @Test
    public void compareStrictGreater() {
        int compResult = expChar.compare(element3, element2);
        assert (compResult > 0);
    }

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
            int actual = ExponentialSearch.search(data, searchFor);
            assertEquals(expected, actual);
        }
    }

    @Test
    public void expSearchTestFound() {
        int[] data = {2, 8, 10, 15, 19, 32, 47};
        int searchFor = 15;
        int expected = 3;
        assert(BinarySearch.isDistinct(data));
        assertEquals(expected, ExponentialSearch.search(data, searchFor));
    }

    @Test
    public void expSearchTestNotFound() {
        int[] data = {2, 8, 10, 15, 19, 32, 47};
        int searchFor = 14;
        int expected = -1;
        assertEquals(expected, ExponentialSearch.search(data, searchFor));

    }

    @Test
    public void genericExpSearchTest() {
        ArrayList<Float> data = new ArrayList<>();
        int length = 25;
        for (int i = 0; i < length; i++) {
            data.add(rand.nextFloat());
        }
        Collections.sort(data);

        int expected = rand.nextInt(length);
        Float searchFor = data.get(expected);

        assertEquals(expected, expFloat.search(data, searchFor));
        searchFor = data.get(0);
        assertEquals(0, expFloat.search(data, searchFor));

    }
}