package com.practice.algorithms;

import java.util.*;

public class ActualIntersectionOfArrays {
    public static void main(String[] args) {
        ActualIntersectionOfArrays intersection = new ActualIntersectionOfArrays();
        int[] nums1 = {4, 2, 8, 8, 6, 3, 2, 7, 7, 5};
        int[] nums2 = {2, 0, 9, 9, 7, 1, 3, 2, 1, 3};

        int[] intersectionResult1 = intersection.intersect1(nums1, nums2);
        for (int num : intersectionResult1) {
            System.out.print(num + " ");
        }

        System.out.println();
        int[] intersectionResult2 = intersection.intersect2(nums1, nums2);
        for (int num : intersectionResult2) {
            System.out.print(num + " ");
        }
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); // store occurrences
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                map.put(num, map.get(num) - 1); // decrement occurrence of found num-key
                result.add(num); // keep adding num as long as it occurs in frequency map
            }
        }

        return result.stream().mapToInt(Integer::intValue).sorted().toArray();
    }

    // for sorted arrays - better space complexity
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList<>();

        int index1 = 0;
        int index2 = 0;

        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                result.add(nums1[index1]);
                index1++;
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
