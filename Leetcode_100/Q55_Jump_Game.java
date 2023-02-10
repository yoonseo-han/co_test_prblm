package Leetcode_100;

class Solution {
    public static boolean canJump(int[] nums) {

        boolean [] dp = new boolean[nums.length];
        dp[0] = true;

        for(int i=1; i<nums.length; i++) {
            for(int j=i-1; j>=0; j--) {
                if(dp[j] && j+nums[j] >=i) {
                    dp[i]= true;
                    break;
                }
            }
            if(dp[i]==false) return false;
        }

        return dp[nums.length-1];
    }

    public static void main(String strs[]) {
        int [] inputArray = {2,3,1,1,4};
        System.out.println(canJump(inputArray));
    }
}