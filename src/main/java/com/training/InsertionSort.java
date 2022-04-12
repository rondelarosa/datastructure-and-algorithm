package com.training;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class InsertionSort {
    private int[] data = {1, 5, 2, 4, 6, 3};

    public static void example() {
        InsertionSort training = new InsertionSort();

        int[] insertion = training.data.clone();
        System.out.println("Insertion sort: " + Arrays.stream(insertion).mapToObj(Objects::toString).collect(Collectors.joining(",")));

        Arrays.stream(training.insertionSort(insertion)).forEach(System.out::println);

    }

    public boolean lessThan(int[] data, int left, int right) {
        System.out.println(data[left] + "<" + data[right]);
        return data[left] < data[right];
    }

    public int[] swap(int[] data, int left, int right) {
        int temp = data[left];
        data[left] = data[right];
        data[right] = temp;
        return data;
    }

    public int[] insertionSort(int[] data) {
        if (data.length <= 1) {
            return data;
        }

        for (int i = 1; i < data.length; i++) {
            System.out.println("index :(" + i + ") value: " + data[i]);
            if (lessThan(data, i, i - 1)) {
                for (int p = i; p > 0; p--) {
                    System.out.println("index p:(" + p + ") value: " + data[p]);
                    if (lessThan(data, p, p - 1)) {
                        swap(data, p, p - 1);
                    } else {
                        break;
                    }
                }
            }
        }
        return data;
    }

}
