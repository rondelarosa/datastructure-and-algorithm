package com.example.sort;

import com.example.model.Circle;

/***
 * Relatively good for small lists
 * can work with other sorting
 */
public class InsertionSort {
    public static int[] sort(int[] values) {
        int[] data = values.clone();

        // {12, 5, 8, 7, 2}
        for (int i = 0; i < data.length; i++) {
            int current = data[i];
            int j = i - 1;
            System.out.println("i: " + i + " j: " + j);

            // unsorted array input
            // Ex: 1,2,3,3'
            // to have stable sorting = data[j] > current ex: (3, 3') meaning
            // for unstable sort = data[j] >= current ex: (3', 3) meaning it changed the order though same number
            while (j >= 0 && data[j] > current) {
                System.out.println("from: " + data[j + 1] + " to: " + data[j]);
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = current;
        }

        return data;
    }

    public static Circle[] sort(Circle[] values) {
        Circle[] data = values.clone();

        for (int i = 0; i < data.length; i++) {
            Circle current = data[i];
            int j = i - 1;
            System.out.println("i: " + i + " j: " + j);

            // unsorted array input
            // Ex: 1,2,3,3'
            // to have stable sorting = data[j] > current ex: (3, 3') meaning
            // for unstable sort = data[j] >= current ex: (3', 3) meaning it changed the order though same number
            while (j >= 0 && data[j].getRadius() > current.getRadius()) {
                System.out.println("from: " + data[j + 1] + " to: " + data[j]);
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = current;
        }

        return data;
    }
}
