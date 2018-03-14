package com.brainyvoyage.algos.string;

public class LsdStringSort {

    public static void sort(String[] data, int numOfLeadingChar) {
        int dataSize = data.length;
        int base = 256;
        String[] aux = new String[dataSize];
        for (int leadingIndex = numOfLeadingChar - 1; leadingIndex >= 0; leadingIndex--) {
            int[] charCount = new int[base + 1];

            for(int wordIndex = 0; wordIndex < dataSize; wordIndex++)
                charCount[data[wordIndex].charAt(leadingIndex) + 1] ++;

            for(int b = 0; b < base; b++){
                charCount[b+1] += charCount[b];
            }

            for(int wordIndex = 0; wordIndex < dataSize; wordIndex++){
                aux[charCount[data[wordIndex].charAt(leadingIndex)]++] = data[wordIndex];
            }

            for(int i = 0; i < dataSize; i++)
                data[i] = aux[i];
        }
    }
}
