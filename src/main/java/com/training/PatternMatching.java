package com.training;

import java.util.ArrayList;
import java.util.List;

public class PatternMatching {

    public static void example() {
    PatternMatching patternMatching = new PatternMatching();

    System.out.println("Searching");
    patternMatching.search("hello world", "o").forEach(System.out::println);
    }

    /**
     * Knut Morris Pratt Pattern
     */
    public int[] calcPrefixLength(String pattern) {
        int patternLength = pattern.length();
        int[] arr = new int[pattern.length() + 1];

        arr[0] = -1;
        arr[1] = 0;

        int prefixLength = 0;
        int i = 1;

        while (i < patternLength) {
            if (pattern.charAt(prefixLength) == pattern.charAt(i)) {
                prefixLength++;
                i++;
                arr[i] = prefixLength;
            } else if (prefixLength > 0) {
                prefixLength = arr[prefixLength]; // note we do not increment i here
            } else {
                i++;
                arr[i] = 0; // prefixLength reached 0, so save into arr[] and move forward
            }
        }

        return arr;
    }

    public List<Integer> search(String text, String pattern) {
        int t = 0; // position of current character in text
        int p = 0; // position of current character i pattern

        int textLength = text.length();
        int patternLength = pattern.length();

        List<Integer> matches = new ArrayList<>();
        int[] prefixLength = calcPrefixLength(pattern);


        while(t < textLength) {
            if(pattern.charAt(p) == text.charAt(t)) {
                p++;
                t++;

                if(p == patternLength) {
                    matches.add(t-p); // occurrence found
                    p = prefixLength[p];
                }
            } else {
                p = prefixLength[p];
                if(p < 0) {
                    p++;
                    t++;
                }
            }
        }

        return matches;
    }
}
