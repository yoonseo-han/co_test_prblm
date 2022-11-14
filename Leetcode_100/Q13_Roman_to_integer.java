package Leetcode_100;

class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int [] answer={1,1};
        for(int i=0; i<nums.length-1; i++) {
            int find = target - nums[i];
            for(int j=i+1; j<nums.length; j++) {
                if(nums[j]==find) {
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int[] nums = {3,2,4};
        int[] output = twoSum(nums,6);
        System.out.println(output[0]);
    }
}