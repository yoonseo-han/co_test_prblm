package Leetcode_100;

class Solution{
    public static int climbStairs(int n) {
        int [] dp = new int [n+1];
        //If size is less than or equal to 2
        if(n<=2) {
            return n;
        }
        //Base case
        dp[1]=1;
        dp[2]=2;
        for(int i=3; i<n+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String strs[]) {
        System.out.println(climbStairs(9));
    }
}