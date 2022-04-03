package com.example;

public class Recursive {
    public static int factorial(int n) {
        System.out.println("n: " + n);
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }
}
