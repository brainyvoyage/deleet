package com.brainyvoyage.algos.search;

public class Search {

    public static int finbonacciSearch(int[] data, int key) {
        int nMinus2FibNum = 0;
        int nMinus1FibNum = 1;
        int nthFibNum = nMinus1FibNum + nMinus2FibNum;

        while (nthFibNum < data.length){
            nMinus2FibNum = nMinus1FibNum;
            nMinus1FibNum = nthFibNum;
            nthFibNum = nMinus1FibNum + nMinus2FibNum;
        }


        return 0;
    }

}


