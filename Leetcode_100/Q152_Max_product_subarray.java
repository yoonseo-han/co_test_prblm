package Leetcode_100;

import java.lang.*;

class Solution {
    public static int maxProduct(int[] nums) {
        int max = 0;
        int [][] dp = new int[nums.length][nums.length];

        if(nums.length==1) return nums[0];

        for(int i=0; i<nums.length; i++) {
            for(int j=i; j<nums.length; j++) {
                if(i==j) dp[i][j] = nums[i];
                else dp[i][j] = dp[i][j-1]*nums[j];
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }

    public static void main(String strs[]) {
        int[] inputArray = {2,3,-2,4};
        System.out.println(maxProduct(inputArray));
    }
}