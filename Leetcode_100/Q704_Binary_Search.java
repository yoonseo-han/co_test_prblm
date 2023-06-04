package Leetcode_100;

class Solution {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left<=right) {
            int mid = left + (right - left) / 2; // calculate the middle index of the array

            if(nums[mid]==target) return mid;
            else if(nums[mid]<target) left = mid+1;
            else right = mid-1;
        }

        return -1; // target not found in the array
    }
    public static void main(String strs[]) {
        int [] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums, target));
    }
}