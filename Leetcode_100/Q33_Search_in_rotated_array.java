package Leetcode_100;

class Solution {
    public static int search(int [] nums, int target){
        int start = 0;
        int end = nums.length -1;

        while(start<=end) {
            int mid = (start+end)/2;
            if(nums[mid] == target) return mid;
            //First left half is ordered
            if(nums[mid] >= nums[start]) {
                //Target exists in the left half
                if(nums[start] <= target && nums[mid] >= target) end = mid-1;
                //If not, tragerse on second half
                else start = mid+1;
            }
            //Right half is ordered
            else if(nums[mid] <= nums[end]) {
                //Target exists in  the right half
                if(nums[end] >= target && nums[mid] <= target) start = mid+1;
                //If not, traverse on left half
                else end = mid-1;
            }
        }

        return -1;
    }
    public static void main(String strs[]) {
        int[] inputArray = {4,5,6,7,1,2};
        int target = 5;  
        System.out.println(search(inputArray, target));
    }
}