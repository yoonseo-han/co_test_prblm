package Leetcode_100;

class Solution {
    public static int getLeftEnd(int [] nums, int target, int left, int right) {
        if(left == right && nums[left] == target) return left;
        else if(left == right) return -1;

        int mid = (left + right)/2;

        if(nums[mid] < target) return getLeftEnd(nums, target, mid+1, right);
        else return getLeftEnd(nums, target, left, mid);
    }

    public static int getRightEnd(int [] nums, int target, int left, int right) {
        if(left == right && nums[left] == target) return left;
        else if(left == right) return -1;

        int mid = (left + right+1)/2;

        if(nums[mid] > target) return getRightEnd(nums, target, left, mid-1);
        else return getRightEnd(nums, target, mid, right);
    }

    public static int[] searchRange(int[] nums, int target) {
        //Initialize result array
        int [] returnArray = {-1,-1};
        //Intialize variables
        int left = 0;
        int right = nums.length - 1;
        //Edge cases
        if(nums.length == 0) return returnArray;

        returnArray[0] = getLeftEnd(nums, target, left, right);
        returnArray[1] = getRightEnd(nums, target, left, right);

        return returnArray;
    }

    public static void main(String strs[]) {
        int [] inputArray = {5,7,7,8,8,10};
        int target = 7;

        int [] resultArray = searchRange(inputArray, target);
        for(int i=0; i<resultArray.length; i++ ) {
            System.out.println(resultArray[i]);
        }
    }
}