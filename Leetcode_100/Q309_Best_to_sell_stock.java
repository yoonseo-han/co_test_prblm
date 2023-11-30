package Leetcode_100;

class Solution {
    public static int maxProfit(int[] prices) {
        //Focus on the 3 types of actions that can be taken (However depending on what the previous state was, the action is determined)
        //If previous action was rest: Can Keep on rest or Buy the stock -> s0[]
        //If previous action was buy: Can rest or Sell the stock -> s1[]
        //If previous action was Sell: Can only rest -> s2[]
        //For each of the 3 cases and possible actions to be taken -> Select one with max value

        //Representation of the 3 cases in each separate array
        if(prices.length <= 1) return 0;

        int [] s0 = new int[prices.length];
        int [] s1 = new int[prices.length];
        int [] s2 = new int[prices.length];

        //Base case definition
        s0[0] = 0; //No stock, then just rest
        s1[0] = -prices[0]; //After buy, should have -prices[0] profit
        s2[0] = Integer.MIN_VALUE; //Lower base case

        for(int i=1; i<prices.length; i++) {
            s0[i] = Math.max(s0[i-1],s2[i-1]); // Stay at s0, or rest from s2 to reach s0
            s1[i] = Math.max(s1[i-1],s0[i-1] - prices[i]); // Stay at s1, or buy from s1 to reach s1
            s2[i] = s1[i-1] + prices[i]; // Can only sell from s1 to reach s2
        }

        return Math.max(s0[prices.length-1], s2[prices.length-1]);
    }
    public static void main(String strs[]) {
        int[] prices = {1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }
}