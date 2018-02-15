package com.brainyvoyage.algos.search;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class InterpolationSearchTest {


    Ops<Integer> ops = new Ops<Integer>() {
        public Integer add(Integer lhs, Integer rhs) {
            return lhs + rhs;
        }

        @Override
        public Integer minus(Integer lhs, Integer rhs) {
            return lhs - rhs;
        }

        @Override
        public int compareTo(Integer lhs, Integer rhs) {
            return lhs.compareTo(rhs);
        }

        @Override
        public double mult(Integer lhs, double rhs) {
            return lhs * rhs;
        }

        @Override
        public Double div(int div, Integer rhs) {
            return div / rhs.doubleValue();
        }

        public Integer zero() {
            return 0;
        }
    };

    @Test
    public void randomInterpolationSearchTest() {
        Random rand = new Random();
        int numOfTest = Math.abs(rand.nextInt(10));
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
            int actual = InterpolationSearch.search(data, searchFor, 0, data.length - 1);

            assertEquals(expected, actual);
        }
    }

    @Test
    public void genericInterpolationSearchTest() {
        InterpolationSearch<Integer> interpolation = new InterpolationSearch<>();
        Random rand = new Random();
        int numOfTest = Math.abs(rand.nextInt(10));
        HashSet<Integer> addedValue = new HashSet<>();
        List<Integer> data = new ArrayList<>();

        for (int test = 0; test < numOfTest; test++) {
            data.clear();
            addedValue.clear();
            int numElement = Math.abs(rand.nextInt(50));
            while (numElement == 0)
                numElement = Math.abs(rand.nextInt(500));

            while(data.size() != numElement) {
                int elem = rand.nextInt(1000);
                if (!addedValue.contains(elem)) {
                    data.add(elem);
                    addedValue.add(elem);
                }
            }
            assertEquals(numElement, data.size());
            int expected = Math.abs(rand.nextInt(numElement));
            Collections.sort(data);
            int searchFor = data.get(expected);
            int actual = interpolation.search(data, searchFor, 0, numElement-1, ops);

            assertEquals(expected, actual);
        }
//        List<Integer> data = new ArrayList<>();
//
//        for(int i = 0; i < 10; i ++){
//            data.add(i * 2);
//        }
//        Collections.sort(data);
//        for (int i = 0; i < 10; i++){
//            int actual = interpolation.search(data, data.get(i), 0, data.size() - 1, ops);
//            assertEquals(i, actual);
//        }
    }
}
