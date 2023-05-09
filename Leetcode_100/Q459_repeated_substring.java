package Leetcode_100;

import java.util.*;

class Solution {
    public static boolean repeatedSubstringPattern(String s) {
        int length = s.length();

        for(int i = length/2; i>=1; i--) {
            if(length%i==0) {
                int reps = length/i;
                String subS = s.substring(0,i);
                StringBuilder tempS = new StringBuilder();
                for(int j=0; j<reps; j++) tempS.append(subS);
                if(tempS.toString().equals(s)) return true;
            }
        }

        return false;
    }
    public static void main(String strs[]) {
        String s = "abab";
        System.out.println(repeatedSubstringPattern(s));
    }
}