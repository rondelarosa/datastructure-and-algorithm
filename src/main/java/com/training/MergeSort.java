package com.training;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class MergeSort {
    private int[] data = {1, 5, 2, 4, 6, 3};

    public static void example() {
        MergeSort training = new MergeSort();

        int[] mergeSorting = training.data.clone();
        System.out.println("Merge sort: " + Arrays.stream(mergeSorting).mapToObj(Objects::toString).collect(Collectors.joining(",")));

        Arrays.stream(training.mergeSort(mergeSorting)).forEach(System.out::println);

    }

    public void assign(int[] data, int index, int value) {

        data[index] = value;
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

}
