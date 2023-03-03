package Leetcode_100;

import java.util.*;
import java.lang.*;

class Solution {
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void nextPermutation(int[] nums) {
        //Edge case
        if(nums.length == 1) return;

        //Start from end to find pivot
        int pivot = 0;
        for(int i=nums.length-1; i>0; i--) {
            if(nums[i] > nums[i-1]) {
                pivot = i-1;
                break;
            }
        }

        //IF array in descending order, return sorted array
        if(pivot == 0) {
            Arrays.sort(nums);
            return;
        }

        //Else, find the right element that is in next lexicological order
        int swapIndex=0;
        for(int i=nums.length-1; i>=0; i--) {
            if(nums[pivot] < nums[i]) {
                swapIndex = i;
                break;
            }
        }
        //then undergo swap
        swap(nums, pivot, swapIndex);

        //Then reverse the right array
        pivot++;
        int end = nums.length -1;
        while(pivot<end) {
            swap(nums, pivot++, end--);
        }
    }

    public static void main(String strs[]) {
        int [] inputArray = {3,2,1};
        nextPermutation(inputArray);

        for(int i:inputArray) {
            System.out.print(i + ", ");
        }
    }
}