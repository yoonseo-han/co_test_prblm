package Leetcode_100;

import java.util.*;

class Solution {
    public static void backtracingMethod(List<List<Integer>> tempList, ArrayList<Integer> curList, int size, int curNum, int target){
        if(curList.size() == size && target == 0) {
            List<Integer> li = new ArrayList<Integer>(curList);
            tempList.add(li);
            return;
        }
        for(int i = curNum ; i<10; i++) {
            curList.add(i);
            backtracingMethod(tempList, curList, size, i+1, target-i);
            curList.remove(curList.size()-1);
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> tempList = new ArrayList<>();
        backtracingMethod(tempList, new ArrayList<Integer>(), k, 1, n);
        return tempList;
    }
    public static void main(String strs[]) {
        int k=3;
        int n=7;
        System.out.println(combinationSum3(k, n));
    }
}