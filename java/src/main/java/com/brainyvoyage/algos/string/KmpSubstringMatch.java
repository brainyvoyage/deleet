package com.brainyvoyage.algos.string;

public class KmpSubstringMatch {
    private String pattern;
    private final int[][] dfa;

    public KmpSubstringMatch(String pattern) {
        this.pattern = pattern;
        int patternLength = pattern.length();
        int radix = 256;

        dfa = new int[radix][patternLength];
        int currentState = 0;
        int fallbackState;
        dfa[this.pattern.charAt(0)][currentState] = 1;

        for (fallbackState = 0, currentState = 1; currentState < patternLength; currentState++) {
            for (int alphabet = 0; alphabet < radix; alphabet++)
                dfa[alphabet][currentState] = dfa[alphabet][fallbackState];

            dfa[this.pattern.charAt(currentState)][currentState] = currentState + 1;
            fallbackState = dfa[this.pattern.charAt(currentState)][fallbackState];
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
