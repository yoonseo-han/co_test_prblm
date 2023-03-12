package Leetcode_100;

class Solution {
    public static int rob(int[] nums) {
        int [] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];

        for(int i = 2; i<=nums.length; i++) dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        return dp[nums.length];
    }
    public static void main(String strs[]) {
        int [] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }
}