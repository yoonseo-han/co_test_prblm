package Leetcode_100;

import java.util.*;

class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> store = new HashMap<>();
        List<Integer>[] arr = new List[nums.length+1]; 
        
        for(int i=0; i<nums.length; i++) {
            store.put(nums[i], store.getOrDefault(nums[i], 0)+1);
        }

        for(int i : store.keySet()) {
            //Do bucket sort based on frequency
            int freq = store.get(i);
            if(arr[freq] == null) arr[freq] = new ArrayList<>();
            //Add the key values with corresponding key values
            arr[freq].add(i);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = arr.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (arr[pos] != null) {
                res.addAll(arr[pos]);
            }
        }

        int [] ans = new int [k];
        int iter = 0;
        for(int i=0; i<k; i++) ans[iter++] = res.get(i);

        return ans;
    }
    public static void main(String strs[]) {
        int [] nums = {1,1,1,2,2,3};
        int k=2;
        
        int [] res = topKFrequent(nums, k);
        for(int i: res) System.out.print(i + ",");
    }
}