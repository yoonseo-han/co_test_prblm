package Leetcode_100;

import java.util.*;

class Solution {
    public static void combination( List<List<Integer>> combs, List<Integer> temp, int start, int n, int k) {
        if(k==0) {
            combs.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i = start; i<=n; i++) {
            temp.add(i);
            combination(combs, temp, i+1, n, k-1);
            temp.remove(temp.size()-1);
        }
    }

    public static  List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<List<Integer>>();
		combination(combs, new ArrayList<Integer>(), 1, n, k);
		return combs;
    }
    public static void main(String strs[]){
        int n = 4;
        int k = 2;
        
        for(List<Integer> list : combine(n, k)) {
            for (int num : list) System.out.print(num + ",");
            System.out.println("");
        }
    }
}