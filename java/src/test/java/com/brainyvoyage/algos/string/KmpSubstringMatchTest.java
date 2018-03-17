package com.brainyvoyage.algos.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class KmpSubstringMatchTest {

    @Test
    public void search() {
        String text = "AABRAACADABRAACAADABRA";
        String pattern = "AACAA";

        KmpSubstringMatch patternMatcher = new KmpSubstringMatch(pattern);

        assertEquals(text.indexOf(pattern), patternMatcher.search(text));
        assertEquals("ARCD".length(), patternMatcher.search("ARCD"));
    }
}