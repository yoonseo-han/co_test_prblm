package Leetcode_100;

import java.util.*;

class Solution {
    public static int findShortestSubArray(int[] nums) {
        //Record frequency
        Map<Integer, Integer> count = new HashMap<>();
        //Record first occuring index of each number
        Map<Integer, Integer> first = new HashMap<>();
        int result = 0;
        int degree = 0;
        for(int i=0; i<nums.length; i++) {
            first.putIfAbsent(nums[i], i);

            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            //If larger count than highest degree
            if (count.get(nums[i]) > degree) {
                degree = count.get(nums[i]);
                result = i - first.get(nums[i]) + 1;
            }
            //Else if same degree: Get larger one
            else if (count.get(nums[i]) == degree)
                result = Math.min(result, i - first.get(nums[i]) + 1);
        }
        return result;
    }
    public static void main(String strs[]) {
        int [] nums = {1,1,2,2,2,1};
        System.out.println(findShortestSubArray(nums));
    }
}