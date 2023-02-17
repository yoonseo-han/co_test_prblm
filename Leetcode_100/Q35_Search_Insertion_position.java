package Leetcode_100;

class Solution{
    public static int searchRecursive(int []nums, int target, int left, int right){
        //Calculate median value
        int median = (left+right)/2;
        //Base case
        if(nums[median] == target) return median;
        if(left==right) {
            if(nums[left] < target) return left+1;
            else return left;
        }

        //Recursive case
        if(nums[median] <target) return searchRecursive(nums, target, median+1, right);
        else return searchRecursive(nums, target, left, median);
    }

    public static int searchInsert(int[] nums, int target) {
        //Recursive call return
        return searchRecursive(nums, target, 0, nums.length-1);
    }

    public static void main(String strs[]) {
        int [] inputArray = {1,3,5,6};
        int target = 5;
        System.out.println(searchInsert(inputArray, target));
    }
}