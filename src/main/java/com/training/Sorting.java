package com.training;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

public class Sorting {

    private int[] data = {1, 5, 2, 4, 6, 3};

    public static void example() {
        Sorting training = new Sorting();

//        int[] boubble = training.data.clone();
//        System.out.println("Bubble sort: " + Arrays.stream(boubble).mapToObj(Objects::toString).collect(Collectors.joining(",")));
//
//        Arrays.stream(training.bubbleSort(boubble)).forEach(System.out::println);
//
//        int[] insertion = training.data.clone();
//        System.out.println("Insertion sort: " + Arrays.stream(insertion).mapToObj(Objects::toString).collect(Collectors.joining(",")));
//
//        Arrays.stream(training.insertionSort(insertion)).forEach(System.out::println);

        int[] mergeSorting = training.data.clone();
        System.out.println("Merge sort: " + Arrays.stream(mergeSorting).mapToObj(Objects::toString).collect(Collectors.joining(",")));

        Arrays.stream(training.mergeSort(mergeSorting)).forEach(System.out::println);
    }

    public boolean greaterThan(int[] data, int left, int right) {
        System.out.println(data[left] + ">" + data[right]);
        return data[left] > data[right];
    }

    public boolean lessThan(int[] data, int left, int right) {
        System.out.println(data[left] + "<" + data[right]);
        return data[left] < data[right];
    }

    public void assign(int[] data, int index, int value) {
        data[index] = value;
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

    public int[] mergeSort(int[] data) {

        if (data.length <= 1) {
            return data;
        }

        int leftSize = data.length / 2;
        int rightSize = data.length - leftSize;

        int[] left = new int[leftSize];
        int[] right = new int[rightSize];


        System.arraycopy(data, 0, left, 0, leftSize);
        System.arraycopy(data, leftSize, right, 0, rightSize);

        mergeSort(left);
        mergeSort(right);

        return merge(data, left, right);
    }

    public int[] merge(int[] data, int[] left, int[] right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int targetIndex = 0;

        int remaining = left.length + right.length;

        while (remaining > 0) {
            if (leftIndex >= left.length) { // left index is greater than or equal left length
                assign(data, targetIndex, right[rightIndex++]); // get data from right data
            } else if (rightIndex >= right.length) { // right index is greater than or equal to right length
                assign(data, targetIndex, left[leftIndex++]); // get data from left data
            } else if (left[leftIndex] < right[rightIndex]) { // left is less than right data
                assign(data, targetIndex, left[leftIndex++]); // get data from left data // swaps data from the left
            } else {
                assign(data, targetIndex, right[rightIndex++]); // left data is greater than right data // swaps data from the right
            }

            targetIndex++;
            remaining--;
        }

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
return data;
    }

    public int[] quick(int[] data, int left, int right) {
        if(left < right) {
            int pivotIndex = getRandom(left, right);

        }
        return data;
    }
}
