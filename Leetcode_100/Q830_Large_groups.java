package Leetcode_100;

import java.util.*;

class Solution {
    public static List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0, j = 0; i < S.length(); i = j) {
            while (j < S.length() && S.charAt(j) == S.charAt(i)) ++j;
            if (j - i >= 3)
                res.add(Arrays.asList(i, j - 1));
        }
        return res;
    }
    public static void main(String strs[]) {
        String s = "abbxxxxzzy";
        for (List<Integer> element: largeGroupPositions(s) ) {
            for(int i : element) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}