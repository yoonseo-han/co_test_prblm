package Leetcode_100;

class Solution {
    public static int findPeakElement(int[] nums) {
        //Able to use binary search to find the peak

        //Based on the observation that nums[left-1] <= nums[left] <= nums[peak] >= nums[right] >= nums[right+1]: Then peak must exist

        //Able to reduce the subarray in which the following characteristic is followed
        //IF nums[mid] < nums[mid+1] -> Can reduce left to mid+1 and else reduce right to mid
        int N = nums.length;
        if(N==1) return 0;

        int left = 0;
        int right = N-1;

        while(left<right) {
            int mid = (right+left)/2;

            if(nums[mid] < nums[mid+1]) left = mid+1;
            else right = mid;
        }

        return (left == N - 1 || nums[left] > nums[left + 1]) ? left : right;
    }
    public static void main(String strs[]) {
        int [] inputArray = {1,2,3,1};
        System.out.println(findPeakElement(inputArray));
    }
}