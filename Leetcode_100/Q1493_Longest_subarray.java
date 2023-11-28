package Leetcode_100;

class Solution {
    public static int longestSubarray(int[] nums) {
        int curMax = 0;

        int left=0;
        int curNumOfZero = 0;

        //Sliding window being able to contain atmost 1 number of 0 within the sliding window
        for(int right = 0; right<nums.length; right++) {
            if(nums[right] == 0) curNumOfZero++;

            // Adjust the window to maintain at most one zero in the subarray
            while (curNumOfZero > 1) {
                if (nums[left] == 0) {
                    curNumOfZero--; // Decrement the count of zeroes
                }
                left++; // Move the left pointer to the right
            }

            // Calculate the length of the current subarray and update the maximum length
            curMax = Math.max(curMax, right - left + 1 - curNumOfZero);
        }

        return (curMax == nums.length)? nums.length-1 : curMax;
    }
    public static void main(String strs[]) {
        int[] nums = {1,1,0,1};
        System.out.println(longestSubarray(nums));
    }
}