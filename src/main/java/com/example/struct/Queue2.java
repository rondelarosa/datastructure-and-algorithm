package com.example.struct;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The queue data structure can be useful in algorithms where you need to process data in order.
 * First in, first out
 */
public class Queue2 {

    public static void example() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(5);
        queue.add(17);
        queue.add(6);

        System.out.println("peek : " + queue.peek());
        System.out.println("remove : " + queue.remove());
        System.out.println("peek : " + queue.peek());

        // deleting all
        while (!queue.isEmpty()){
            queue.remove();
        }
    }
}
