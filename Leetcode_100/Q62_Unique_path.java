package Leetcode_100;

class Solution{
    public static int uniquePaths(int m, int n) {
        //Define 2D dp array
        int [][] dp = new int[m][n];
        //Base case
        for(int i=0; i<m; i++) dp[i][0] = 1;
        for(int j=0; j<n; j++) dp[0][j] = 1;

        //Recursive case
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String strs[]) {
        int m = 3;
        int n = 7;
        System.out.println(uniquePaths(m, n));
    }
}