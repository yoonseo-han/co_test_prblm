package Leetcode_100;

import java.util.*;

class Solution{
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> temp = new HashSet<>();
        for(int i: nums1) temp.add(i);

        List<Integer> resultList = new ArrayList<>();
        for(int k: temp) {
            for(int i=0; i<nums2.length; i++) {
                if(nums2[i] == k) {
                    resultList.add(k);
                    break;
                }
            }
        }

        return resultList.stream().mapToInt(i->i).toArray();
    }
    public static void main(String strs[]) {
        int [] nums1 = {1,2,2,1};
        int [] nums2 = {2,2};

        int [] result = intersection(nums1, nums2);
        for(int i: result) System.out.println(i);
    }
}