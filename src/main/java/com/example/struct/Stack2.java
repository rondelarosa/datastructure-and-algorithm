package com.example.struct;

import java.util.Stack;

/**
 * The stack data structure can be useful for algorithms where you need to keep track of state.
 */
public class Stack2 {

    /**
     * O(1) time algorithm
     */
    public boolean hasMatchingEfficient(String s) {
        Stack<Character> stack = new Stack<>();
        int matching = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(') {
                matching++;
            } else if (current == ')') {
                if (matching > 0) {
                    matching--;
                }
            }
        }

        return matching == 0;
    }

    /**
     * O(n) time algorithm
     */
    public boolean hasMatchingInefficient(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(') {
                stack.push('(');
            } else if (current == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }

    /**
     * Next greater element
     */
    public void nextGreaterElement(int[] arr) {
        if (arr.length == 0) return;

        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int next = arr[i];

            if (!stack.isEmpty()) {
                int popped = stack.pop();
                while (popped < next) {
                    System.out.println(popped + "--->" + next);
                    if (stack.isEmpty()) {
                        break;
                    }
                    popped = stack.pop();
                }
                if (popped > next) {
                    stack.push(popped);
                }
            }

            stack.push(next);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + "--->" + -1);
        }
    }

    public static void example() {
        Stack2 stack = new Stack2();
        stack.nextGreaterElement(new int[]{3, 1, 5, 9, 7});
    }

    public static void exampleStackInefficient() {
        Stack2 stack = new Stack2();
        String test1 = "(local test))";
        String test2 = "(local test";

        System.out.println("source: " + test1 + " must have parentheses: " + stack.hasMatchingInefficient(test1));
        System.out.println("source: " + test2 + " must have parentheses: " + stack.hasMatchingInefficient(test2));
    }

    public static void exampleStackEfficient() {
        Stack2 stack = new Stack2();
        String test1 = "(local test))";
        String test2 = "(local test";

        System.out.println("source: " + test1 + " must have parentheses: " + stack.hasMatchingEfficient(test1));
        System.out.println("source: " + test2 + " must have parentheses: " + stack.hasMatchingEfficient(test2));
    }
}
