package com.training;

import java.util.ArrayList;
import java.util.List;

public class PatternMatching {

    public static void example() {
    PatternMatching patternMatching = new PatternMatching();

        System.out.println("Searching");
//    patternMatching.search("hello world", "llo").forEach(System.out::println);

//        patternMatching.search("abbbcabb", "bbb").forEach(System.out::println);


//        String text = "---abcxxxab------abcxxxabcy---";
//        String pattern = "abcxxxabcy";
//        patternMatching.search(text, pattern).forEach(System.out::println);

//        patternMatching.search("abbascadabb", "aabaacaabaa").forEach(System.out::println);

        patternMatching.search("abbascadabb", "aaacaaaaac").forEach(System.out::println);
    }

    /**
     * Knut Morris Pratt Pattern
     */
    public int[] calcPrefixLength(String pattern) {
        // get the pattern length
        int patternLength = pattern.length();

        // prefix characters occurrence
        // added 1 for -1 storage
        // all array values set to 0
        int[] store = new int[pattern.length() + 1];

        // index 0 is -1 and index 1 as 0 value
        store[0] = -1;
        store[1] = 0;

        // to be used as pointer in the storage array
        int prefixLength = 0;

        // starts at 1 index position to determine
        // 1st and 2nd value the same characters
        int i = 1;

        while (i < patternLength) {
            // found match to prefix and increment the count to be used for shifting decrement
            if (pattern.charAt(prefixLength) == pattern.charAt(i)) {
                prefixLength++;
                i++;
                store[i] = prefixLength;
            } else if (prefixLength > 0) {
                // look on the array index with prefix length and assign as prefix length
                prefixLength = store[prefixLength]; // note we do not increment i here
            } else {
                // prefixLength reached 0, so save into arr[] and move forward
                i++;
                store[i] = 0;
            }
        }

        // return array with prefix character counters
        return store;
    }

    public List<Integer> search(String text, String pattern) {
        int t = 0; // position of current character in text
        int p = 0; // position of current character i pattern

        // getting text and pattern length
        int textLength = text.length();
        int patternLength = pattern.length();

        // storage for matches
        List<Integer> matches = new ArrayList<>();

        // look up for prefix length based on the pattern
        int[] prefixLength = calcPrefixLength(pattern);


        // iterating to text length
        while(t < textLength) {
            // comparing pattern character position and text character position
            if(pattern.charAt(p) == text.charAt(t)) {

                // increment pattern position and text position
                p++;
                t++;

                // if p position same of pattern length
                if(p == patternLength) {
                    // occurrence found
                    // store index position
                    matches.add(t-p);

                    // reset the p position to the prefix length p position index
                    p = prefixLength[p];
                }
            } else {
                // reset the p position to the prefix length p position index
                p = prefixLength[p];

                // p position reset returned -1
                // reset back to the pattern p position 0
                if(p < 0) {
                    p++;
                    t++;
                }
            }
        }

        return matches;
    }
}
