package Leetcode_100;

import java.util.*;

class Solution {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> record = new HashMap<Integer, Integer>();

        for(int num1: nums1) {
            for(int num2: nums2) {
                int sum = num1+num2;
                if(!record.containsKey(sum)) record.put(sum, 1);
                else record.replace(sum, record.get(sum)+1);
            }
        }
        int count = 0;
        for(int num3: nums3) {
            for(int num4: nums4) {
                count +=  record.getOrDefault(-(num3+num4), 0);
            }
        }
        return count;
    }
    public static void main(String strs[]) {
        int [] nums1 = {1,2};
        int [] nums2 = {-2,-1};
        int [] nums3 = {-1,2};
        int [] nums4 = {0,2};
        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
    }
}