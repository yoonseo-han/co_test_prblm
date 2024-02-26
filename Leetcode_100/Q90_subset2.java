package Leetcode_100;

import java.util.*;

class Solution {
    public HashSet<List<Integer>> tempStore = new HashSet<>();

    public void backtracking(List<Integer> curList, boolean[] visited, int[] nums) {
        //Regardless of size of array: Add to array list
        Collections.sort(curList);
        tempStore.add(curList);
        if(curList.size() == nums.length) return;

        else {
            for(int i=0; i<nums.length; i++) {
                if(visited[i]) continue;
                visited[i] = true;
                curList.add(nums[i]);
                backtracking(new ArrayList<Integer>(curList), visited, nums);
                visited[i] = false;
                curList.remove(curList.size()-1);
            }
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        backtracking(new ArrayList<Integer>(), visited, nums);

        for(List<Integer> i: tempStore) {
            answer.add(i);
        }

        return answer;
    }
}