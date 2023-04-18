package Leetcode_100;

class Solution {
    public static int[] productExceptSelf(int[] nums) {
        int [] result = new int[nums.length];
        result[0] = 1;
        //Calculate left half
        for(int i=1; i<nums.length; i++) result[i] = result[i-1]*nums[i-1];
        //Calculate right half
        int right = 1;
        for(int i=nums.length-1; i>=0; i--) {
            result[i] *= right;
            right *= nums[i];
        }

        return result;
    }
    public static void main(String strs[]) {
        int [] nums = {1,2,3,4};
        int [] result = productExceptSelf(nums);
        for(int i:result) System.out.print(i + " ");
    }
}