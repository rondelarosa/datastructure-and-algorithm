package com.example;

public class Recursive {

    /**
     * Head recursion, may cause stack overflow
     */
    public static int factorial(int n) {
        System.out.println("n: " + n);
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    /**
     * Tail recursion, may cause stack overflow
     */
    public static int factorial(int n, int result) {
        System.out.println("n: " + n);
        if (n == 0) return 1;
        return factorial(n - 1, n * result);
    }

    public static void move(int disc, char from, char to, char inter) {
        if(disc == 1) {
            System.out.println("moving disc 1 from :" + from + " to " + to);
        } else {
            move(disc -1, from, inter, to);
            System.out.println("moving disc " + disc + " from :" + from + " to " + to);
            move(disc -1, inter, to, from);
        }
    }
}
