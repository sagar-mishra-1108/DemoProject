package com.practice.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class SortingClass <T extends Comparable<T>> {
    public List<T> sort(List<T> list) {
        List<T> sortedList = new ArrayList<>(list);
        int n = sortedList.size();
        boolean swapped;

        do {
            swapped = IntStream.range(1, n)
                    .mapToObj(i -> {
                        T current = sortedList.get(i - 1);
                        T next = sortedList.get(i);
                        return current.compareTo(next) > 0 ? i : -1;
                    })
                    .anyMatch(index -> {
                        if (index != -1) {
                            Collections.swap(sortedList, index - 1, index);
                            return true;
                        }
                        return false;
                    });
            n--;
        } while (swapped);
        return sortedList;
    }

    public static void main(String ...args) {
        SortingClass<Integer> intSorter = new SortingClass<>();
        List<Integer> integers = Arrays.asList(5, 1, 8, -3, 0, 11);
        List<Integer> sortedIntegers = intSorter.sort(integers);

        System.out.println(sortedIntegers);

    }
}
