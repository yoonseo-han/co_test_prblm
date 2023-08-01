package Leetcode_100;

class Solution {
    public static int smallestRangeI(int[] nums, int k) {
        //3 cases: smallest and largest -> both +ve, 1+ve 1-ve, both -ve

        //Edge case
        if(nums.length==1) return 0;

        //First recrod the largest and smallest element
        int largest = nums[0];
        int smallest = nums[0];

        for(int i=1; i<nums.length; i++) {
            largest = Math.max(largest, nums[i]);
            smallest = Math.min(smallest, nums[i]);
        }

        if(largest - smallest <=2*k) return 0;

        return (largest - smallest -(2*k));
    }
    public static void main(String strs[]) {
        int [] nums = {0,10};
        int k = 2;
        System.out.println(smallestRangeI(nums, k));
    }
}