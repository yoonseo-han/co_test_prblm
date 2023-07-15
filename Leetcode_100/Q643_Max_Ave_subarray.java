package Leetcode_100;

import java.util.Arrays;

class Solution {
    public static double findMaxAverage(int[] nums, int k) {
        //Max subarray value: element values must be consecutive
        
        //Using the sliding window algorithm
        
        //First caclulate the first k sums
        long sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];
        long max = sum;

        //Move on and add on
        for(int i=k; i<nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }

        return max / 1.0 / k;
    }
    public static void main (String strs[]) {
        int [] nums = {1,12,-5,-6,50,3};
        System.out.println(findMaxAverage(nums, 4));
    }
}