package Leetcode_100;

import java.util.Arrays;

class Solution {
    public static int[] singleNumber(int[] nums) {
        int [] result = new int[2];
        int count = 0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i] == nums[i+1]) i++;
            else result[count++] = nums[i];
        }
        if(count==1) result[count] = nums[nums.length-1];
        return result;
    }
    public static void main(String strs[]) {
        int [] nums = {1,2,1,3,2,5};
        int [] result = singleNumber(nums);
        for(int i: result) System.out.print(i + ", ");
    }
}