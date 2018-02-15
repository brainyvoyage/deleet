package com.brainyvoyage.algos.search;

import java.util.List;

interface Ops<T extends Number> {
    T zero();

    T add(T lhs, T rhs);

    T minus(T lhs, T rhs);

    int compareTo(T lhs, T rhs);

    double mult(T lhs, double rhs);

    Double div(int div, T rhs);
}

public class InterpolationSearch<T extends Number> {

    public static int search(int[] data, int key, int low, int high) {
        int middle;
        while ((data[high] != data[low]) && (key >= data[low]) && (key <= data[high])) {
            middle = low + ((key - data[low]) * (high - low) / (data[high] - data[low]));

            if (data[middle] < key)
                low = middle + 1;
            else if (data[middle] > key)
                high = middle - 1;
            else return middle;

        }

        if (key == data[low]) return low;
        else return -1;
    }

    public int search(List<T> data, T key, int low, int high, Ops<T> ops) {
        int middle;

        while ((ops.compareTo(data.get(high), data.get(low)) != 0)
                && (ops.compareTo(key, data.get(low)) >= 0)
                && (ops.compareTo(key, data.get(high)) <= 0)
                ) {
            T farFromLow = ops.minus(key, data.get(low));
            int len = high - low;
            T dataRange = ops.minus(data.get(high), data.get(low));
            double density = ops.div(len, dataRange);
            double approxShift = ops.mult(farFromLow, density);

            middle = low + (int) approxShift;
//            System.out.println(key);
//            System.out.println(String.format("[low = %d, high = %d]: Middle = %d, farFromLow = %d, Len = %d, " +
//                    "dataRange = %d, density = %f, approxShift = %f", data.get(low), data.get(high), middle,
//                    farFromLow, len, dataRange, density, approxShift));
            if (ops.compareTo(data.get(middle), key) < 0)
                low = middle + 1;
            else if (ops.compareTo(data.get(middle), key) > 0)
                high = middle - 1;
            else return middle;

        }

        if (ops.compareTo(data.get(low), key) == 0) return low;
        else {
            System.out.println("Bad");
            return -1;
        }
    }
}
