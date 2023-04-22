package Leetcode_100;

class Solution {
    public static int findDuplicate(int[] nums) {
        int [] count = new int[nums.length+1];

        for(int i=0; i<nums.length; i++) {
            count[nums[i]]++;
            if(count[nums[i]]==2) return nums[i];
        }

        return 0;
    }
    public static void main(String strs[]) {
        int [] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }
}