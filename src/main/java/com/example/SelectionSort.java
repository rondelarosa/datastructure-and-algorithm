package com.example;

public class SelectionSort {
    public static int[] sort(int[] values) {
        // prevent making changes to the source
        // create new reference
        int[] toSort = values.clone();
        for (int i=0; i < toSort.length - 2; i++) {
            int currentIndex = i;

            for (int j = i+1; j < toSort.length; j++)
                if (toSort[j] < toSort[currentIndex]) currentIndex = j;

            int tmp = toSort[currentIndex];
            toSort[currentIndex] = toSort[i];
            toSort[i] = tmp;
        }

        return toSort;
    }
}
