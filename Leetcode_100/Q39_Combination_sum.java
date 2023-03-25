package Leetcode_100;

import java.util.*;

class Solution {
    public static void backtracking(List<List<Integer>> resultList, List<Integer> tempList, int [] nums, int target, int tempSum, int start) {
        // Base case
        if(tempSum == target) {
            resultList.add(new ArrayList<>(tempList));
            return;
        }
        if(tempSum>target) return;

        for(int i=start; i<nums.length; i++) {
            tempList.add(nums[i]);
            backtracking(resultList, tempList, nums, target, tempSum+nums[i], i);
            tempList.remove(tempList.size()-1);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        backtracking(resultList, new ArrayList<Integer>(), candidates, target, 0, 0);
        return resultList;
    }
    public static void main(String strs[]) {
        int [] candidates = {2,3,6,7};
        int target = 7;

        List<List<Integer>> resultList = combinationSum(candidates, target);
        for(List<Integer> iterator: resultList) System.out.println(iterator);
    }
}