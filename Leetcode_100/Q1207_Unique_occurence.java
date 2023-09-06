package Leetcode_100;

import java.util.*;

class Solution {
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> tempMap = new HashMap<>();
        HashMap<Integer, Integer> quantityMap = new HashMap<>();

        for(int i=0; i<arr.length; i++) tempMap.put(arr[i], tempMap.getOrDefault(arr[i], 0)+1);
        for(int i: tempMap.values()) {
            quantityMap.put(i, quantityMap.getOrDefault(i, 0)+1);
            if(quantityMap.get(i) > 1) return false;
        }

        return true;
    }
    public static void main(String strs[]) {
        int [] arr = {1,2};
        System.out.println(uniqueOccurrences(arr));
    }
}