package Leetcode_100;

class Solution {
    public static int lengthOfLIS(int[] nums) {
        int [] dp = new int[nums.length];
        for(int i=0; i<nums.length; i++) dp[i]=1;
        int max = 1;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) dp[i] = dp[j] + 1;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    public static void main(String strs[]) {
        int [] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}