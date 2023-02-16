package Leetcode_100;

import java.lang.Math;

class Solution{
    public static int maxProfit(int[] prices) {
        int length = prices.length;
        //Define 2d dp and max
        int [][]dp = new int[length][length];
        int max = 0;

        //Iterate and fill value
        for(int i=0; i<length; i++) {
            for(int j=i; j<length; j++) {
                if(i==j) dp[i][j] = 0;
                else if(prices[j-1]>=prices[j]) dp[i][j] = dp[i][j-1];
                else {
                    dp[i][j] = dp[i][j-1] + (prices[j] - prices[j-1]);
                    max = Math.max(dp[i][j], max);
                }
            }
        }

        return max;
    }

    public static void main(String strs[]) {
        int [] inputArray = {7,1,5,3,6,4};
        System.out.println(maxProfit(inputArray));
    }
}