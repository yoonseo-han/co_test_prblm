package Leetcode_100;

class Solution {
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void nextPermutation(int[] nums) {
        //Edge case
        if(nums.length == 1) return;

        //Start from end to find pivot: From the end to start, pivot at where the decrease in number stops
        int pivot = 0;
        for(int i=nums.length-1; i>0; i--) {
            if(nums[i] > nums[i-1]) {
                pivot = i-1;
                break;
            }
        }

        
    }
    public static void main(String strs[]) {
        int [] nums = {2,1,3};
        nextPermutation(nums);
    }
}