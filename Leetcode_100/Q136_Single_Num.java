package Leetcode_100;

import java.util.Objects;

class Solution {
    public static int singleNumber(int[] nums) {
        //Find max element number
        int max=0;
        for(int i=0; i<nums.length; i++) {
            int value = (nums[i] >0) ? (nums[i]) : (nums[i]*(-1));
            if(max<value) max=value;
        }

        //Define counter array size based on max value of input array
        int[][] temp = new int[max+1][2];
        //Initialize counter function
        for(int i=0; i<temp.length; i++) {
            temp[i][0] = 0;
            temp[i][1] = 0;
        }

        //Increase count if positive number, decrease if negative
        for(int i=0; i<nums.length; i++) {
            int index = (nums[i] >0) ? (nums[i]) : (nums[i]*(-1));
            if(nums[i]>0) temp[index][0]++;
            else temp[index][1]++;
        }
        for(int i=0; i<temp.length; i++) {
            if(temp[i][0]==1) return i;
            else if (temp[i][1]==1) return -i;
        }
        return 0;
    }

    public static void main(String strs[]) {
        int [] nums = {-1};
        System.out.println(singleNumber(nums));
    }
}