package com.practice.newFeatures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NewFeaturesDemo {
    public static void main(String[] args) {
        boolean isEmpty = "  ".isEmpty();
        System.out.println("isEmpty: " + isEmpty);

        boolean isBlank = "  ".isBlank();
        System.out.println("isBlank: " + isBlank);

        List<String> lines = "Line1\nLine2\nLine3".lines().collect(Collectors.toList());
        System.out.println(lines);

        String text = "  Text  ";
        String newStr1 = text.strip();
        String newStr2 = text.stripLeading();
        String newStr3 = text.stripTrailing();
        System.out.println(newStr1);
        System.out.println(newStr2);
        System.out.println(newStr3);

        System.out.println("Text".repeat(4));

        List<Integer> originalList = new ArrayList<>();
        List<Integer> copyList = List.copyOf(originalList);
//        copyList.add(3); // runtime error - UnsupportedOperationException, ImmutableCollections

        List<Integer> evenList =  originalList.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toUnmodifiableList());
//        evenList.add(6); // runtime error - UnsupportedOperationException, ImmutableCollections

        List<String> strList = Arrays.asList("Item1", "Item2", "Item3", "Item4");
        String[] array = strList.toArray(String[]::new);
        Arrays.stream(array).forEach(System.out::println);
    }
}
