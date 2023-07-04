package Leetcode_100;

class Solution {
    public static int findLengthOfLCIS(int[] nums) {
        int max = 0;
        int left = 0;

        for(int i=0; i<nums.length-1; i++) {
            if(nums[i] >= nums[i+1]) {
                max = Math.max(max, i-left+1);
                left = i+1;
            }
        }

        return max;
    }
    public static void main(String strs[]) {
        int [] nums = {1,3,5,4,7};
        System.out.println(findLengthOfLCIS(nums));
    }
}