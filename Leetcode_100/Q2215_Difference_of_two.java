package Leetcode_100;

import java.util.*;

class Solution {
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();

        //Hasht table for first array
        HashSet<Integer> tempStore1 = new HashSet<>();
        for(int i=0; i<nums1.length; i++) tempStore1.add(nums1[i]);
        HashSet<Integer> tempStore2 = new HashSet<>();
        for(int i=0; i<nums2.length; i++) tempStore2.add(nums2[i]);

        res.add(new ArrayList<>());
		res.add(new ArrayList<>());

        for(int num : tempStore1){                                            // just iterate to all elements of set1
			if(!tempStore2.contains(num)){ res.get(0).add(num); }      // add those elements to first sublist of result list, which are not in set2.
		}
		for(int num : tempStore2){                                            // just iterate to all elements of set2
			if(!tempStore1.contains(num)){ res.get(1).add(num); }      // add those elements to first sublist of result list, which are not in set1
		}

        return res;
    }
    public static void main(String strs[]) {
        int [] nums1 = {1,2,3};
        int [] nums2 = {2,4,6};

        for(List<Integer> result : findDifference(nums1, nums2)) {
            for(int i: result) System.out.print(i+",");
            System.out.println("");
        }
    }
}