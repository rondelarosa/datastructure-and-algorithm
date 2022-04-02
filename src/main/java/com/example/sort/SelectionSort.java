package com.example.sort;

/**
 * Better than bubble sort
 * Running time is independent of ordering of elements
 */
public class SelectionSort {
    public static int[] sort(int[] values) {
        // prevent making changes to the source
        // create new reference
        int[] data = values.clone();
        for (int i=0; i < data.length - 2; i++) {
            int currentIndex = i;

            for (int j = i+1; j < data.length; j++)
                if (data[j] < data[currentIndex]) currentIndex = j;

            int tmp = data[currentIndex];
            data[currentIndex] = data[i];
            data[i] = tmp;
        }

        return data;
    }
}
