package Leetcode_100;

class Solution {
    public static int longestOnes(int[] nums, int k) {
        //Record left and right
        int left=0;
        int right=1;

        //For each A[j], try to find the longest subarray.
        //If A[i] ~ A[j] has number of zeros <= K, we continue to increment j.
        //If A[i] ~ A[j] has zeros > K, we increment i (as well as j).

        for (right = 0; right < nums.length; ++right) {
            if (nums[right] == 0) k--;
            if (k < 0 && nums[left++] == 0) k++;
        }
        return right - left;

    }
    public static void main(String strs[]) {
        int [] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(longestOnes(nums, k));
    }
}