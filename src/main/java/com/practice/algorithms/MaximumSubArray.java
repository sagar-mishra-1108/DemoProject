package com.practice.algorithms;

public class MaximumSubArray {
    public static void main(String[] args) {
        MaximumSubArray maximumSubArray = new MaximumSubArray();
        int max = maximumSubArray.maxSubArray(new int[]{-2, 3, -5, 2, 2, -1, 4, -3});
        System.out.println(max);
    }

    public int maxSubArray(int[] nums) {
        int localMax = 0;
        int globalMax = 0;
        for (int num : nums) {
            localMax = Math.max(num, num + localMax);
            globalMax = Math.max(localMax, globalMax);
        }
        return globalMax;
    }
}
