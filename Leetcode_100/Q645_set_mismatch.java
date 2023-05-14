package Leetcode_100;

class Solution {
    public static int[] findErrorNums(int[] nums) {
        //Define coutning array
        int [] count = new int[nums.length];
        //Result array
        int [] result = new int [2];

        for(int i=0; i<nums.length; i++) {
            count[nums[i]-1]++;
            if(count[nums[i]-1]>1) {
                result[0] = nums[i];
            }
        }
        //Find missing one
        for(int i=0; i<nums.length; i++) {
            if(count[i]==0) result[1] = i+1;
        }

        return result;
    }
    public static void main(String strs[]) {
        int [] nums = {1,2,2,4};
        System.out.println(findErrorNums(nums)[0]);
    }
}