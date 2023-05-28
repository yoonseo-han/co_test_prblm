package Leetcode_100;

class Solution {
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int [] dp = new int[n];

        for(int i = 0;  i<n; i++) {
            if (i<2) dp[i] = cost[i];
            else dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[n-1], dp[n-2]);
    }
    public static void main(String strs[]) {
        int [] cost = {10,15,20};
        System.out.println(minCostClimbingStairs(cost));
    }
}