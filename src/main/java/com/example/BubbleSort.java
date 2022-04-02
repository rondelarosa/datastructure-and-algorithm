package com.example;

public class BubbleSort {
    /**
     * Brute force pattern
     * Own implementation
     * @param values array values to sort
     * @return
     */
    public static int[] sort(int[] values) {
        int[] toSort = values.clone();
        for (int i = 0; i < toSort.length; i++) {
            System.out.println("next i: " + i);

            // must always from the second last to check
            // i = 0 | 0 < j < n-2 | (n-1)
            // i = 1 | 0 < j < n-3 | (n-2)
            int remaining = (toSort.length - i) - 1;

            for (int j = 0; j < remaining; j++) {
                int a = toSort[j];
                int b = toSort[j + 1];

                System.out.println("i: " + i + " j:" + j);
                System.out.println("a: " + a + " b:" + b);
                if (a > b) {
                    int tmp = b;
                    toSort[j + 1] = toSort[j];
                    toSort[j] = tmp;
                    System.out.println(tmp);
                }
            }
        }
        return toSort;
    }
}
