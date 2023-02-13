package Leetcode_100;

class Solution {
    public static void sortColors(int[] nums) {
        //Define counter
        int [] count ={0,0,0};
        //1st pass
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==0) count[0]++;
            if(nums[i]==1) count[1]++;
            if(nums[i]==2) count[2]++;
        }
        //2nd pass
        for(int i=0; i<nums.length; i++) {
            if(i<count[0]) nums[i]=0;
            else if(i<count[0]+count[1]) nums[i]=1;
            else nums[i]=2;
        }
    }
    public static void main(String strs[]) {
        int [] inputArray = {2,0,2,1,1,0};
        sortColors(inputArray);
        System.out.println(inputArray);
    }
}