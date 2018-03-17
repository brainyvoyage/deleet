package com.brainyvoyage.algos.string;

public class KmpSubstringMatch {
    private String pattern;
    private final int[][] dfa;

    public KmpSubstringMatch(String pattern) {
        this.pattern = pattern;
        int radix = 256;
        int patternLength = pattern.length();

        dfa = new int[radix][patternLength];
        dfa[this.pattern.charAt(0)][0] = 1;

        for (int mismatchIndex = 0, patternIndex = 1; patternIndex < patternLength; patternIndex++) {

            for (int ch = 0; ch < radix; ch++) {
                dfa[ch][patternIndex] = dfa[ch][mismatchIndex];
            }

            dfa[this.pattern.charAt(patternIndex)][patternIndex] = patternIndex + 1;
            mismatchIndex = dfa[this.pattern.charAt(patternIndex)][mismatchIndex];
        }
    }

    public int search(String text) {
        int textIndex = 0;
        int textLength = text.length();

        int patternIndex = 0;
        int patternLength = pattern.length();

        for (textIndex = 0, patternIndex = 0; textIndex < textLength && patternIndex < patternLength; textIndex++)
            patternIndex = dfa[text.charAt(textIndex)][patternIndex];
        if (patternIndex == patternLength)
            return textIndex - patternLength;
        else return textLength;

    }
}
