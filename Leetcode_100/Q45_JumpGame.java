package Leetcode_100;

class Solution {
    public static int jump(int[] nums) {
        //Use greedy algorithm: Check the farthest position reachable 
        int jumpCount = 0;
        int maxDistance = 0;
        int curEnd = 0;
        for(int i=0; i<nums.length; i++){
            maxDistance = Math.max(maxDistance, i+nums[i]);
            if(i==curEnd) {
                jumpCount++;
                curEnd=maxDistance;
            }
        }
        return jumpCount;
    }
    public static void main(String strs[]) {
        int [] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
}