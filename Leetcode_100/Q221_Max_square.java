package Leetcode_100;

class Solution {
    public static int maximalSquare(char[][] matrix) {
        //Use 2d dynamic programming

        //Definition: dp[i][j] = X; Stores the largest size of square within range of i,j at right bottom
        //Base case: dp[i][j] = 1 for i=0 or j=0

        //Recursive case: dp[i][j] = min(dp[i-1][j-1], min(dp[i][j-1], dp[i-1][j])) +1;

        //Record the largest length of side possible in int variable for every visit of cell
        int maxLength = 0;
        int [][] dp = new int [matrix.length][matrix[0].length];

        //Edge case
        if(matrix.length == 0) return 0;

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(i==0 || j==0 || matrix[i][j] == '0') dp[i][j] = matrix[i][j] - '0';
                else dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) +1;
                maxLength = Math.max(dp[i][j], maxLength);
            }
        }
        return maxLength*maxLength;
    }
    public static void main(String strs[]) {
        char [][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(matrix));
    }
}