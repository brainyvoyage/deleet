package com.brainyvoyage.algos.sort;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.Assert.*;

public class PartitionTest {
    private Random rand = new Random();

    @Test
    public void partition() {
        Integer data[] = {10, 80, 30, 90, 40, 50, 70};
        Integer expected = 4;
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
        assertEquals((int)expected, actual);
        expected = 70;
        assertEquals(expected, data[actual]);
    }

    @Test
    public void genericPartitionTest() {
        int numTest = 0;
        while (numTest <= 0) numTest = rand.nextInt(100);
        for (int test = 0; test < numTest; test++) {
            int numElement = 0;
            while (numElement <= 0) numElement = rand.nextInt(1000);
            Float[] data = new Float[numElement];
            for (int i = 0; i < numElement; i++) data[i] = rand.nextFloat();
            Float[] sorted = data.clone();
            Arrays.sort(sorted);
            Float pivot = data[data.length - 1];
            int expected = -1;
            for (int i = 0; i < sorted.length; i++) if (sorted[i].equals(pivot)) expected = i;
            assert (expected >= 0);
            assertEquals(expected, Partition.partition(data, 0, data.length - 1));
        }
    }
}