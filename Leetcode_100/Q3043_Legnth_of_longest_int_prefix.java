package Leetcode_100;

//https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/description/

import java.util.*;

class intReverseComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer a, Integer b) {
        return b-a;
    }
}

class Solution {
    
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int longestPrefix = 0;
        
        Integer[] arr1Int = new Integer[arr1.length];
        Arrays.setAll(arr1Int, i -> arr1[i]);
        Arrays.sort(arr1Int, new intReverseComparator());
        
        Integer[] arr2Int = new Integer[arr2.length];
        Arrays.setAll(arr2Int, i -> arr2[i]);
        Arrays.sort(arr2Int, new intReverseComparator());
        
        for(int i=0; i<arr1Int.length; i++) {
            Integer curCompare = arr1Int[i];
            for(int j=0; j<arr2Int.length; i++) {
                if(curCompare>arr2Int[j]) break;
            }
        }
        
        return longestPrefix;
    }
}