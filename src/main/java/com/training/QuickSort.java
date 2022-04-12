package com.training;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

public class QuickSort {
    private int[] data = {1, 5, 2, 4, 6, 3};

    public static void example() {
        QuickSort training = new QuickSort();

        int[] quickSorting = training.data.clone();
        System.out.println("Quick sort: " + Arrays.stream(quickSorting).mapToObj(Objects::toString).collect(Collectors.joining(",")));

        Arrays.stream(training.quickSort(quickSorting)).forEach(System.out::println);
    }

    public int[] swap(int[] data, int left, int right) {
        int temp = data[left];
        data[left] = data[right];
        data[right] = temp;
        return data;
    }

    Random pivotRandom = new Random();

    public int getRandom(int min, int max) {
        return pivotRandom
                .ints(min, (max + 1))
                .findFirst()
                .getAsInt();
    }


    public int[] quickSort(int[] data) {
        return quickRandom(data, 0, data.length - 1);
    }

    public int[] quickRandom(int[] data, int left, int right) {
        if (left < right) {
            int pivotIndex = getRandom(left, right);
            int newPivot = partition(data, left, right, pivotIndex);

            System.out.println("newPivot: " + newPivot + " left: " + left + " right: " + right);

            quickRandom(data, left, newPivot - 1);
            quickRandom(data, newPivot + 1, right);
        }
        return data;
    }

    private int partition(int[] data, int left, int right, int pivotIndex) {
        int pivotValue = data[pivotIndex];

        swap(data, pivotIndex, right);

        int storedIndex = left;

        for (int i = left; i < right; i++) {
            if (data[i] < pivotValue) {
                swap(data, i, storedIndex);
                storedIndex++;
            }
        }
        swap(data, storedIndex, right);
        return storedIndex;
    }
}
