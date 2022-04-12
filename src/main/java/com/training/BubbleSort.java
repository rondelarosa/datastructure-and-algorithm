package com.training;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class BubbleSort {
    private int[] data = {1, 5, 2, 4, 6, 3};

    public static void example() {
        BubbleSort training = new BubbleSort();

        int[] boubble = training.data.clone();
        System.out.println("Bubble sort: " + Arrays.stream(boubble).mapToObj(Objects::toString).collect(Collectors.joining(",")));

        Arrays.stream(training.bubbleSort(boubble)).forEach(System.out::println);

    }

    public boolean greaterThan(int[] data, int left, int right) {
        System.out.println(data[left] + ">" + data[right]);
        return data[left] > data[right];
    }

    public int[] swap(int[] data, int left, int right) {
        int temp = data[left];
        data[left] = data[right];
        data[right] = temp;
        return data;
    }

    public int[] bubbleSort(int[] data) {
        boolean again;

        if (data.length <= 1) {
            return data;
        }

        do {
            again = false;

            for (int i = 1; i < data.length; i++) {
                System.out.println("index :(" + i + ") value: " + data[i]);
                if (greaterThan(data, i - 1, i)) {
                    swap(data, i, i - 1);
                    again = true;
                }
            }
        } while (again);

        return data;
    }
}
