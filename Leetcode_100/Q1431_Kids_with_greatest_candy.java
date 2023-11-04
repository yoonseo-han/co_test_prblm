package Leetcode_100;

import java.util.*;

class Solution {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        
        int max = 0;
        for(int i=0; i<candies.length; i++) max = Math.max(max, candies[i]);
        for(int i: candies) {
            if(i + extraCandies >= max) result.add(true);
            else result.add(false);
        }

        return result;
    }
    public static void main(String strs[]) {
        int [] candies = {2,3,5,1,3};
        int extraCandies = 3;

        List<Boolean> result = kidsWithCandies(candies, extraCandies);
        for(Boolean i: result) System.out.print(i + ",");
    }
}