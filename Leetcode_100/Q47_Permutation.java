package Leetcode_100;

import java.util.*;

class Solution {
    public static void backtracing(List<List<Integer>> ans, List<Integer> temp, int[] nums, boolean[] vis) {
        //Use backtracing

        //If size of temp list equals size of nums: Add to list
        if(nums.length == temp.size()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        //Else use recursive call with different permutation
        for(int i=0; i< nums.length ; i++ ) {
            if(vis[i]) continue; // if current element is already present in the temp, skip the element
            if(i > 0 && ! vis[i-1] && nums[i] == nums[i-1]) continue; // if prev element and current element is equal, skip the element

            vis[i] = true;
            temp.add(nums[i]);
            
            backtracing(ans, temp, nums, vis); // recursive call
            
			// backtracking
            temp.remove(temp.size() - 1);
            vis[i] = false;
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); // ans list
        Arrays.sort(nums); // sort the array
		
		// create a boolean array which track the certain indexed integer is present in out temp list or not
        backtracing(ans, new ArrayList<>(), nums, new boolean[nums.length]); // helper method
		
        return ans; // return output
    }
    public static void main(String strs[]) {
        int [] nums = {1,1,2};
        List<List<Integer>> result = permuteUnique(nums);
        for(List<Integer> results : result) {
            for(int number : results) System.out.println(number);
        }
    }
}