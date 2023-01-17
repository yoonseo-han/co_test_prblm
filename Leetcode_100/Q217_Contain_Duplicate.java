package Leetcode_100;

import java.util.HashMap;

class Solution {
    public static boolean containsDuplicate(int [] nums) {
        HashMap <Integer, Integer> tempStorage = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if(tempStorage.containsKey(nums[i])) return true;
            else tempStorage.put(nums[i], 1);
        }

        return true;
    }

    public static void main(String strs[]) {
        int[] inputArray = {1,2,3,1};
        System.out.println(containsDuplicate(inputArray));
    }
}