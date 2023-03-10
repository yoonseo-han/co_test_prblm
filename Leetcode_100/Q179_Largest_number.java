package Leetcode_100;

import java.util.*;

class Solution {
    public static String largestNumber(int[] nums) {
        String result = "";

        String [] temp = new String[nums.length];
        for(int i=0; i<nums.length; i++) temp[i] = String.valueOf(nums[i]);

        //Sort in lexicographic order using comparator ovcerride
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2 ) {
                String temp1 = s1+s2;
                String temp2 = s2+s1;
                return temp1.compareTo(temp2);
            }
        };

        Arrays.sort(temp, comp);

        //Edge case deal
        if(temp[temp.length-1].equals("0")) return "0";

        for(int i=temp.length-1; i>=0; i--) result += temp[i];

        return result;
    }

    public static void main(String strs[]) {
        int [] nums = {3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }
}