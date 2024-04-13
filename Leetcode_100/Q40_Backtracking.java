package Leetcode_100;

import java.util.*;

class Solution {
    public static void backtracking(int [] candidates, List<Integer> curList, int target, List<List<Integer>> result ,int curPosition, int curSum) {
        if(curSum > target) {
            return;
        }
        else if(curSum == target) {
            result.add(new ArrayList<>(curList));
            return;
        }
        else {
            for(int i = curPosition; i<candidates.length; i++) {
                if(i > curPosition && candidates[i] == candidates[i-1]) continue; /** skip duplicates */
                curList.add(candidates[i]);
                backtracking(candidates, curList, target, result, i+1, curSum + candidates[i]);
                curList.remove(curList.size()-1);
            }
        }
    }

    public static List<List<Integer>> combinationSum2(int [] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);
        backtracking(candidates, new ArrayList<Integer>(), target, result, 0, 0);

        return result;
    }
    public static void main(String strs[]) {
        int [] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }
}