package com.example;

public class InsertionSort {
    public static int[] sort(int[] values) {
        int[] toSort = values.clone();

        // {12, 5, 8, 7, 2}
        for (int i = 0; i < toSort.length; i++) {
            int current = toSort[i];
            int j = i - 1;
            System.out.println("i: " + i + " j: " + j);
            while (j >= 0 && toSort[j] > current) {
                System.out.println("from: " + toSort[j + 1] + " to: " + toSort[j]);
                toSort[j + 1] = toSort[j];
                j = j - 1;
            }
            toSort[j + 1] = current;
        }

        return toSort;
    }
}
