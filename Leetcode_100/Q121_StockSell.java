package Leetcode_100;

import java.lang.Math;

class Solution {
    public static int maxProfitDC(int [] prices, int l, int r) {

        //Exit case
        if(l==r) return prices[l];
        
        int q = Math.floorDiv((l+r), 2);
        int M1 = maxProfitDC(prices, l, q);
        int M2 = maxProfitDC(prices, q+1, r);

        //Case 3
        int MIN = Integer.MAX_VALUE;
        int MAX = 0;
        for(int i=q; i>=l; i--) {
            if(prices[i]<MIN) MIN = prices[i];
        }
        for(int i=q+1; i<=r; i++) {
            if(prices[i]>MAX) MAX = prices[i];
        }
        int profit = ((MAX-MIN)>0) ? (MAX-MIN) : 0;

        return Math.max(M1, Math.max(M2, profit));
    }

    public static int maxProfit(int[] prices) {
        return maxProfitDC(prices, 0, prices.length-1);
    }

    public static void main (String strs[]) {
        int [] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}