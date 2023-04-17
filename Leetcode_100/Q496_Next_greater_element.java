package Leetcode_100;

import java.util.Arrays;

class Solution {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //num1 is a subset of num2
        // find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2
        int [] result = new int[nums1.length];

        boolean flag = false;
        //For each num1 array, iterate and find the corresponding next value
        for(int i=0; i<nums1.length; i++) {
            int target = nums1[i];
            flag = false;
            for(int j=0; j<nums2.length; j++) {
                if(target == nums2[j]) flag=true;
                if(flag == true && target < nums2[j]) {
                    result[i] = nums2[j];
                    break;
                }
                if(j==nums2.length-1) result[i] = -1;
            }
        }

        return result;
    }

    public static void main(String strs[]) {
        //Input: 2 int arrays
        int [] nums1 = {4,1,2};
        int [] nums2 = {1,3,4,2};

        int [] result = nextGreaterElement(nums1, nums2);

        for(int i: result) System.out.println(i);
    }
}