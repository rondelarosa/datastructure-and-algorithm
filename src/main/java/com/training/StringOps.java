package com.training;

import java.util.HashSet;

public class StringOps {

    public String replaceCharsWithCollect(String data) {
        String[] datum = data.split(",");
        HashSet<Character> scrubSet = new HashSet<>();

        String scrub = datum[1];
        var input = datum[0];

        // O(n)
        for (char c : scrub.toCharArray()) {
            if (!scrubSet.contains(c) && String.valueOf(c).trim().length() > 0)
                scrubSet.add(c);
        }

        return input.chars()
                // .map(c -> scrubSet.contains((char)c) ? '-' : c) // replace teh character with other
                .filter(c -> !scrubSet.contains((char) c)) // return normalize
                .collect(StringBuilder::new, (sb2, c) -> sb2.append((char) c), StringBuilder::append)
                .toString();
    }

    public String replaceCharsCommaSep(String data) {
        String[] datum = data.split(",");
        String scrub = datum[1];
        HashSet<Character> scrubSet = new HashSet<>();

        for (char c : scrub.toCharArray()) {
            if (!scrubSet.contains(c) && String.valueOf(c).trim().length() > 0)
                scrubSet.add(c);
        }

        StringBuilder sb = new StringBuilder();
        char[] toScrub = datum[0].toCharArray();

        for (char c : toScrub) {
            if (!scrubSet.contains(c))
                sb.append(c);
        }

        return sb.toString();

    }
}
