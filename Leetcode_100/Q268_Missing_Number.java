package Leetcode_100;

class Solution {
    public static int missingNumber(int[] nums) {
        //Edge cases
        if(nums==null || nums.length == 0) return 0;

        //Define new int array
        int [] tempStorage = new int[nums.length + 1];
        //Insert number 
        for(int i=0; i<nums.length; i++) {
            tempStorage[nums[i]]=1;
        }
        //Check remaining one
        for(int i=0; i<tempStorage.length; i++) {
            if(tempStorage[i]!=1) return i;
        }

        return 0;
    }
    public static void main (String strs[]) {
        int [] inputArray = {3,0,1};

        System.out.println(missingNumber(inputArray));
    }
}