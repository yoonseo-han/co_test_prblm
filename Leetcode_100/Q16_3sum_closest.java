package Leetcode_100;

import java.util.*;

class Solution {
    public static int threeSumClosest(int[] nums, int target) {
        //Sum of 3 integers that leads to closest value to target

        //First sort arrays to prevent any overlap of selection
        Arrays.sort(nums);

        int minDiff=Integer.MAX_VALUE;
        int ans=0;

        for(int i=0; i<nums.length-2; i++) {
            int low = i+1;
            int high = nums.length - 1;

            while(low<high) {
                int temp=nums[i]+nums[low]+nums[high];
                if(Math.abs(target-temp)<minDiff){
                    ans=temp;
                    minDiff=Math.abs(target-temp);
                }
                if(temp==target){
                    return target;
                }
                else if(temp>target){
                        high--;
                }
                else{
                    low++;
                }
            }
        }

        return ans;
    }
    public static void main(String strs[]) {
        int [] nums = {-1,2,1,4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }
}