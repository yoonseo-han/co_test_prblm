package Leetcode_100;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void swap(int []nums, int first, int second) {
        int temp = nums[second];
        nums[second] = nums[first];
        nums[first] = temp;
    }

    public static void permuteGenerate(int [] nums, int start, List<List<Integer>> resultList) {
        //Base case
        if(start == nums.length) {
            List<Integer> tempList = new ArrayList<>();
            for(int i=0; i<nums.length; i++) tempList.add(nums[i]);
            resultList.add(tempList);
        }

        //Else case
        else {
            for(int i=start; i<nums.length; i++) {
                swap(nums, start, i);
                permuteGenerate(nums, start+1, resultList);
                swap(nums, start, i);
            }
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();

        permuteGenerate(nums,0, resultList);

        return resultList;
    }

    public static void main(String strs[]) {
        int [] inputArray = {1,2,3};
        System.out.println(permute(inputArray));
    }
}