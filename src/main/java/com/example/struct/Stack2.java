package com.example.struct;

import java.util.Stack;

/**
 * The stack data structure can be useful for algorithms where you need to keep track of state.
 */
public class Stack2 {

    /**
     * Next greater element
     */

    public void nextGreaterElement(int[] arr) {
        if(arr.length == 0) return;

        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);

        for(int i=1; i< arr.length; i++) {
            int next  = arr[i];

            if(!stack.isEmpty()) {
                int popped = stack.pop();
                while (popped < next) {
                    System.out.println(popped + "--->" + next);
                    if(stack.isEmpty()) {
                        break;
                    }
                    popped = stack.pop();
                }
                if(popped > next) {
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
        stack.nextGreaterElement(new int[]{3,1,5,9,7});
    }
}
