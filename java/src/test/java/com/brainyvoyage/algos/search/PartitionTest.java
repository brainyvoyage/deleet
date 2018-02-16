package com.brainyvoyage.algos.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class PartitionTest {
    private Partition<Float> partition = new Partition<>();
    Random rand = new Random();

    @Test
    public void compare() {
    }

    @Test
    public void partitionTest() {
        int data[] = {10, 80, 30, 90, 40, 50, 70};
        int expected = 4;
        for (int item :
                data) {
            System.out.print(item + ", ");
        }
        int actual = Partition.partition(data, 0, data.length - 1);
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
            Partition.partition(data, 0, data.length + 1);
        } catch (IndexOutOfBoundsException e) {
            expected = e;
        }
        assertNotEquals("No Exception", expected);

        try {
            Partition.partition(data, -4, data.length - 1);
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
            Partition.partition(data, data.length + 1, data.length);
        } catch (IndexOutOfBoundsException e) {
            expected = e;
        }
        assertNotEquals("No Exception", expected);
    }


    @Test
    public void genericPartitionTest() {
        int numTest = 0;
        while (numTest <= 0) numTest = rand.nextInt(100);
        for (int test = 0; test < numTest; test++) {
            int numElement = 0;
            while (numElement <= 0) numElement = rand.nextInt(1000);
            List<Float> data = new ArrayList<>();
            while (data.size() != numElement) data.add(rand.nextFloat());
            ArrayList<Float> sorted = new ArrayList<>(data);
            Collections.sort(sorted);
            Float pivot = data.get(data.size() - 1);
            int expected = -1;
            for (int i = 0; i < sorted.size(); i++) if (sorted.get(i).equals(pivot)) expected = i;
            assert (expected >= 0);
            assertEquals(expected, partition.partition(data, 0, data.size() - 1));
        }
    }

    @Test
    public void genericBoundTest() {
        ArrayList<Float> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) data.add(rand.nextFloat());

        int expected = -1;
        int actual = partition.partition(data, 2, 1);
        assertEquals(expected, actual);
        actual = partition.partition(data, 3, 11);
        assertEquals(expected, actual);

    }
}