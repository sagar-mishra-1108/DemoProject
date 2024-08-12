package com.practice.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringDemo {
    public static void main(String[] args) {
        System.out.println("Common Prefix example");
        StringDemo stringDemo = new StringDemo();
        String commonPrefix = stringDemo.longestCommonPrefix("Amazing Spiderman", "Amazing Spinner");
        System.out.println(commonPrefix);

        System.out.println("Repeated Substring example");
        String text = "This is a sample text that repeats the word repeat.";
        String repeatedSubstring = stringDemo.longestRepeatedSubstring(text);
        System.out.println(repeatedSubstring);
    }

    public String longestCommonPrefix(String firstStr, String secondStr) {
        int matchLength = 0;
        int minLength = Math.min(firstStr.length(), secondStr.length());
        while (matchLength < minLength && firstStr.charAt(matchLength) == secondStr.charAt((matchLength))) {
            matchLength++;
        }
        return firstStr.substring(0, matchLength);
    }

    public String longestRepeatedSubstring(String text) {
        List<String> suffixes = getSuffixes(text);
        Collections.sort(suffixes);
        String longestSubstring = "";
        for (int i = 0; i < suffixes.size() - 1; i++) {
            String commonPrefix = longestCommonPrefix(suffixes.get(i), suffixes.get(i + 1));
            if (commonPrefix.length() > longestSubstring.length()) {
                longestSubstring = commonPrefix;
            }
        }
        return longestSubstring;
    }

    public List<String> getSuffixes(String text) {
        return IntStream.range(0, text.length())
                .mapToObj(index -> text.substring(index))
                .collect(Collectors.toList());
    }
}
