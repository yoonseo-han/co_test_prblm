package Leetcode_100;

import java.lang.Math;

class Solution {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;

        for(int i=0; i<prices.length-1; i++) {
            for(int j=i; j<prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }

        return maxProfit;
    }

    public static void main (String strs[]) {
        int [] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}