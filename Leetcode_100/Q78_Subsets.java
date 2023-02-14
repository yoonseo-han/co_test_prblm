package Leetcode_100;

import java.util.List;
import java.util.ArrayList;

class Solution{
    public static void subsetRecursive(List<List<Integer>> resultList, List<Integer> curList, int iterator, int[] nums) {
        if(iterator == nums.length-1) {
            resultList.add(new ArrayList<>(curList));
            curList.add(nums[iterator]);
            resultList.add(new ArrayList<>(curList));
            return;
        }
        else {
            subsetRecursive(resultList, new ArrayList<>(curList), iterator+1, nums);
            curList.add(nums[iterator]);
            subsetRecursive(resultList, new ArrayList<>(curList), iterator+1, nums);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        //Define variables
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        int iterator = 0;

        subsetRecursive(resultList, curList, iterator, nums );

        return resultList;
    }

    public static void main(String strs[]) {
        int [] inputArray = {1,2,3};
        List<List<Integer>> resultList = subsets(inputArray);

        for(List<Integer> temp: resultList) {
            System.out.println(temp);
        }
    }
}