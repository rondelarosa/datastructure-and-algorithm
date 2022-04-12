package com.training;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class ArraysAndLists {

    private int[] data = {1, 5, 2, 4, 6, 3};

    public static void example() {
        ArraysAndLists training = new ArraysAndLists();

//        int[] twoPointers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        System.out.println("two pointer, find 5: " + training.twoPointerSumOfTwoElems(twoPointers, 5));

//        int[] kStepsTwoPointers = {1, 2, 3, 4, 5, 6, 7};
//        System.out.println("two pointer 4 k steps: " + Arrays.stream(kStepsTwoPointers).mapToObj(Objects::toString).collect(Collectors.joining(",")));
//        Arrays.stream(training.twoPointerRotateArrayKSteps(kStepsTwoPointers, 4)).forEach(System.out::println);
//
//        int[] kStepsTwoPointers2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        System.out.println("two pointer 4 k steps: " + Arrays.stream(kStepsTwoPointers2).mapToObj(Objects::toString).collect(Collectors.joining(",")));
//        Arrays.stream(training.twoPointerRotateArrayKSteps(kStepsTwoPointers2, 4)).forEach(System.out::println);

//        int[] kStepsTwoPointers3 = {1, 2, 3, 4, 5};
//        System.out.println("two pointer 6 k steps: " + Arrays.stream(kStepsTwoPointers3).mapToObj(Objects::toString).collect(Collectors.joining(",")));
//        Arrays.stream(training.twoPointerRotateArrayKSteps(kStepsTwoPointers3, 6)).forEach(System.out::println);

        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

        MyNode<Integer> head = list.getHead();
        System.out.println("two pointer for finding middle node, length: " + list.length());
        System.out.println("middle node: " + training.findMiddleNode(head));

        MyNode<Integer> node1 = new MyNode<>(1);
        MyNode<Integer> node2 = new MyNode<>(2);
        MyNode<Integer> node3 = new MyNode<>(3);
        MyNode<Integer> node4 = new MyNode<>(4);
        MyNode<Integer> node5 = new MyNode<>(5);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node1);
        node5.setNext(node2);
        System.out.println("find node cycle: " + training.detectCycle(node1));

    }

    /**
     * Requirements: Sorted values
     * <p>
     * In many problems involving arrays or lists, we have to analyze
     * <p>
     * each element of the array compared to its other elements.
     * <p>
     * An approach to efficiently solve using the two pointers approach.
     * <p>
     * Sum of two elements in an array
     * <p>
     * Problem: Given a sorted array of integers, we need to see if there are two numbers in it such that their sum is equal to a specific value.
     * <p>
     * For example, if our input array is [1, 1, 2, 3, 4, 6, 8, 9] and the target value is 11, then our method should return true.
     * <p>
     * However, if the target value is 20, it should return false.
     * <p>
     * Let's first see a naive solution:
     */
    public boolean twoPointerSumOfTwoElems(int[] data, int targetValue) {
        int pointerOne = 0;
        int pointerTwo = data.length - 1;

        while (pointerOne < pointerTwo) {
            int sum = data[pointerOne] + data[pointerTwo];

            if (sum == targetValue) {
                return true;
            } else if (sum < targetValue) {
                pointerOne++;
            } else {
                pointerTwo--;
            }
        }
        return false;
    }

    /**
     * Problem: Given an array, rotate the array to the right by k steps, where k is non-negative.
     * <p>
     * For example, if our input array is [1, 2, 3, 4, 5, 6, 7] and k is 4, then the output should be [4, 5, 6, 7, 1, 2, 3].
     * <p>
     * We can solve this by having two loops again which will make the time complexity O(n^2) or by using an extra,
     * temporary array, but that will make the space complexity O(n).
     * <p>
     * Let's solve this using the two-pointer technique instead:
     **/
    public int[] twoPointerRotateArrayKSteps(int[] data, int step) {
//        step %= data.length; // w/ out raise java.lang.ArrayIndexOutOfBoundsException
        if (step > data.length) { // safer than modulus approach
            System.out.println("invalid steps, must be between 1 to " + data.length);
            return new int[]{};
        }

        kStepsReverse(data, 0, data.length - 1);
        kStepsReverse(data, 0, step - 1);
        kStepsReverse(data, step, data.length - 1);
        return data;
    }

    private void kStepsReverse(int[] data, int start, int end) {
        while (start < end) {
            int temp = data[start];
            data[start] = data[end];
            data[end] = temp;
            start++;
            end--;
        }
    }


    /**
     * Finding middle node on singly linked list
     */
    public <T> T findMiddleNode(MyNode<T> head) {
        MyNode<T> slowPointer = head;
        MyNode<T> fastPointer = head;

        while (fastPointer.getNext() != null && fastPointer.getNext().getNext() != null) {
            fastPointer = fastPointer.getNext().getNext();
            slowPointer = slowPointer.getNext();
        }

        return slowPointer.data;
    }

    /**
     * Detecting node cycle
     */
    public <T> boolean detectCycle(MyNode<T> head) {
        MyNode<T> slowPointer = head;
        MyNode<T> fastPointer = head;

        while (fastPointer != null && fastPointer.getNext() != null) {
            fastPointer = fastPointer.getNext().getNext();
            slowPointer = slowPointer.getNext();

            if (slowPointer == fastPointer) return true;
        }

        return false;
    }
}
