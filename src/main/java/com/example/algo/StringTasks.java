package com.example.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.StringJoiner;
import java.util.function.IntPredicate;
import java.util.stream.Stream;

public class StringTasks {
    /**
     * String are all uppercase
     */
    public static boolean isUppercase(String s) {
        return s.chars().allMatch(Character::isUpperCase);
    }

    /**
     * String are all in lowercase
     */
    public static boolean isLowercase(String s) {
        // s.chars().noneMatch(Character::isUpperCase);
        return s.chars().allMatch(Character::isLowerCase);
    }

    /**
     * rules for the valid string
     */
    public static boolean isPasswordComplex(String s) {
        return s.chars().anyMatch(Character::isUpperCase) &&
                s.chars().anyMatch(Character::isLowerCase) &&
                s.chars().anyMatch(Character::isDigit);
    }

    /**
     * Easy to work on the string when normalized and it will optimized
     */
    public static String normalizeString(String s) {
        return s.toLowerCase().trim().replace(",", "");
    }

    /**
     * Parsing contents
     */
    public static void parseContents(String s) {
        System.out.println("Option 1");
        for (char c : s.toCharArray()) {
            System.out.print(c);
        }

        System.out.println();
        System.out.println("Option 2");
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.print(c);
        }
    }

    /**
     * Character from the string at even index
     */
    public static boolean isAtEvenIndex(String s, char item) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        // look only in the even index, it's optimized reduced by half
        for (int i = 0; i < s.length() / 2 + 1; i = i + 2) {
            if (s.charAt(i) == item) {
                return true;
            }
        }
        return false;
    }

    /**
     * Reverse the string
     */
    public static String reverse(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        StringBuilder reversed = new StringBuilder();
        // loop string in reverse order
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed.append(s.charAt(i));
        }

        return reversed.toString();
    }

    /**
     * String Builder reverse
     */
    public static String reverseSB(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        return new StringBuilder(s).reverse().toString();
    }

    /**
     * Reverse word
     * palindrome - a number that is equal or string to the same reverse
     */
    public static void reverseWord(String s) {
        if (s == null || s.isEmpty()) {
            return;
        }

        StringJoiner result = new StringJoiner(" ");
        String[] words = s.split(" ");
        for (String w : words) {
            result.add(reverseSB(w));
        }
        System.out.println("Output 1: " + result.toString());

        StringBuilder sb = new StringBuilder();

        // Option 2
        for (int i = 0; i < words.length; i++) {
            sb.append(reverseSB(words[i]));
            if (i < words.length - 1)
                sb.append(" ");
        }

        System.out.println("Output 2: " + sb.toString());
    }

    /**
     * Linear search arrays to simplify seach implementation and prevent null pinter exception
     */
    public OptionalInt linearSearch(int[] arr, int item) {
        return Arrays.stream(arr).filter(f -> f == item).findFirst();
    }

    /**
     * Example of linear search
     */
    public static void linearSearch() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        StringTasks tasks = new StringTasks();
        tasks.linearSearch(arr, 1).ifPresent(System.out::println);
        tasks.linearSearch(arr, 8).ifPresent(System.out::println);
    }

    /**
     * Assumption, data is sorted
     * Binary Search tree is divide and conquer algorithm
     */
    public boolean binarySearch(int[] arr, int item) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;
            if (item == arr[mid]) {
                return true;
            } else if (item < arr[mid]) {
                max = mid - 1; // lookup to shift the left content
            } else if (item > arr[mid]) {
                min = mid + 1; // lookup to shift the right content
            }
        }

        return false;
    }

    public static void binarySearch() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        StringTasks tasks = new StringTasks();
        System.out.println("source: " + Arrays.toString(arr) + ", find 1: " + tasks.binarySearch(arr, 1));
        System.out.println("source: " + Arrays.toString(arr) + ", find 5: " + tasks.binarySearch(arr, 5));
        System.out.println("source: " + Arrays.toString(arr) + ", find 8: " + tasks.binarySearch(arr, 8));
    }

    /**
     * Old approach
     */
    public int[] findEvenNumberOld(int[] arr1, int[] arr2) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int num : arr1) {
            if (num % 2 == 0)
                result.add(num);
        }

        for (int num : arr2) {
            if (num % 2 == 0)
                result.add(num);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Cleaner approach in finding even number
     */
    public int[] findEvenNumber(int[] arr1, int[] arr2) {
        IntPredicate isEvenPred = num -> num % 2 == 0;
        return Stream.of(arr1, arr2)
                .flatMapToInt(Arrays::stream)
                .filter(isEvenPred)
                .toArray();
    }

    public static void findEvenNumber() {
        int[] arr1 = {-9, 3, 2, -8, 12, -16};
        int[] arr2 = {0, -3, -8, -35, 40, 20, 7};

        StringTasks tasks = new StringTasks();
        System.out.println("source: " + Arrays.toString(arr1) + " results: " + Arrays.toString(tasks.findEvenNumber(arr1, arr2)));

        Arrays.stream(tasks.findEvenNumber(arr1, arr2)).forEach(System.out::println);
    }

    public int[] reverseArray(int[] arr) {
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - 1 - i];
        }

        return result;
    }

    /**
     * In place sorting no new array created
     */
    public int[] reverseArrayInPlace(int[] arr) {
        // to not make changes to the source
        int[] result = arr.clone();

        // for loop in half (result.length / 2)
        for (int i = 0; i < result.length / 2; i++) {
            // Swap item at index (i) and
            // item at index (arr.length -i -1)
            int temp = result[i];
            result[i] = result[result.length - 1 - i];
            result[result.length - 1 - i] = temp;
        }

        return result;
    }

    public static void reverseArray() {
        int[] arr1 = {-9, 3, 2, -8, 12, -16};

        StringTasks tasks = new StringTasks();
        System.out.println("source: " + Arrays.toString(arr1));
//        Arrays.stream(tasks.reverseArrayOld(arr1)).forEach(System.out::println);
        Arrays.stream(tasks.reverseArrayInPlace(arr1)).forEach(System.out::println);
    }

    public int[] rotateArrayToLeft(int[] arr) {
        // to not make changes to the source
        int[] result = arr.clone();

        int temp = result[0];
        for (int i = 0; i < result.length - 1; i++) {
            // Swap item at index (i) and
            // item at index (i + 1)
            result[i] = result[i + 1];
        }
        result[result.length - 1] = temp;

        return result;
    }

    public int[] rotateArrayToRight(int[] arr) {
        // to not make changes to the source
        int[] result = arr.clone();

        int temp = result[result.length - 1];
        for (int i = result.length - 1; i > 0; i--) {
            // Swap item at index (i) and
            // item at index (i - 1)
            result[i] = result[i - 1];
        }
        result[0] = temp;

        return result;
    }

    public static void rotateAnArray() {
        int[] arr1 = {-9, 3, 2, -8, 12, -16};

        StringTasks tasks = new StringTasks();
        System.out.println("source: " + Arrays.toString(arr1));
        int[] results = tasks.rotateArrayToLeft(arr1);

        System.out.println("source > to left: " + Arrays.toString(results));
        Arrays.stream(results).forEach(System.out::println);

        System.out.println("source > to right: " + Arrays.toString(results));
        Arrays.stream(tasks.rotateArrayToRight(results)).forEach(System.out::println);
    }
}
