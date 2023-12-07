package Leetcode_100;

import java.util.*;

class Solution {
    public static void backtrack(List<List<Integer>> result, List<Integer> curList, int[] candidates, int target, int curSum, int start) {
        if(curSum > target) return;
        else if(curSum == target) result.add(new ArrayList<>(curList));
        else {
            for(int i = start; i<candidates.length; i++) {
                //Skip duplicates
                if(i > start && candidates[i] == candidates[i-1]) continue; /** skip duplicates */
                curList.add(candidates[i]);
                backtrack(result, curList, candidates, target, curSum + candidates[i], i+1);
                curList.remove(curList.size()-1);
            }
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        //Sort for convenience
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<Integer>(), candidates, target, 0, 0);
        return list;
    }
    public static void main(String strs[]) {
        int [] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }
}