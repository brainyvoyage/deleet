package com.brainyvoyage.algos.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class LsdStringSortTest {

    @Test
    public void testStringSort() {
        String[] data = {"4PGC938", "2IYE230", "3CIO720", "1ICK750", "1OHV845", "4JZY524", "1ICK750", "3CIO720",
                "1OHV845", "1OHV845", "2RLA629", "2RLA629", "3ATW723"};

        String[] exppectedOutput = {"1ICK750", "1ICK750", "1OHV845", "1OHV845", "1OHV845", "2IYE230", "2RLA629",
                "2RLA629", "3ATW723", "3CIO720", "3CIO720", "4JZY524", "4PGC938"};

        LsdStringSort.sort(data, 7);

        for (String word: data)
            System.out.println(word);
        assertArrayEquals(exppectedOutput, data);
    }

}