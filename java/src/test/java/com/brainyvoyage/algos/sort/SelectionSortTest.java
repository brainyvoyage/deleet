package com.brainyvoyage.algos.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class SelectionSortTest {
    private Integer[] data = {10, 80, 30, 90, 40, 50, 70};
    private Integer[] expected = {10, 30, 40, 50, 70, 80, 90};

    @Test
    public void sortTest() {

        SelectionSort.sort(data);
        SortUtils.show(data);

        assertArrayEquals(expected, data);
    }

}