package Leetcode_100;

class Solution {
    //Output int array that removed duplicates
    public static int removeDuplicates(int[] nums) {
        //Counter of distinct elements
        int k = 1;

        //Initially add first element in array
        int ptr1 = 0;
        int ptr2 = 1;

        while(ptr2<nums.length) {
            if(nums[ptr1] != nums[ptr2]) {
                nums[ptr1+1] = nums[ptr2];
                ptr1++;
                k++;
            }
            else ptr2++;
        }

        return k;
    }

    public static void main(String strs[]) {
        int[] nums = {1,1,2}; // Input array
        int[] expectedNums = {1,2,4}; // The expected answer with correct length

        int k = removeDuplicates(nums); // Calls your implementation
        
        assert k == expectedNums.length;
        for (int i = 0; i < 3; i++) {
            assert nums[i] == expectedNums[i];
        }
    }
}