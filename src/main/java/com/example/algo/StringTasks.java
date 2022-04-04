package com.example.algo;

import java.util.Arrays;
import java.util.StringJoiner;

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
    public static  void reverseWord(String s) {
        if (s == null || s.isEmpty()) {
            return;
        }

        StringJoiner result = new StringJoiner(" ");
        String[] words = s.split(" ");
        for (String w: words){
            result.add(reverseSB(w));
        }
        System.out.println("Output 1: " + result.toString());

        StringBuilder sb = new StringBuilder();

        // Option 2
        for (int i=0; i < words.length; i++) {
            sb.append(reverseSB(words[i]));
            if (i < words.length - 1)
                sb.append(" ");
        }

        System.out.println("Output 2: " + sb.toString());
    }

}
