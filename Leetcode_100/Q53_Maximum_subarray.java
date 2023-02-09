package Leetcode_100;

import java.lang.Math;

class Solution{
    public static int maxSubArray(int[] nums) {

        //Edge cases
        if(nums.length == 1) return nums[0];

        int [] dp = new int[nums.length];
        int max = dp[0];
        dp[0] = nums[0];

        for(int i=1; i<nums.length; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String strs[]) {
        int [] inputArray = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(inputArray));
    }
}