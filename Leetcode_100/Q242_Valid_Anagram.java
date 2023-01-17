package Leetcode_100;

// Solution using library

import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public static boolean isAnagram(String s, String t) {
        //Edge cases
        if(s == null || t == null) return false;

        //Compare length and if not equal, return false
        if(s.length() != t.length()) return false;
        
        char [] tempStore1 = s.toCharArray();
        Arrays.sort(tempStore1);

        char [] tempStore2 = t.toCharArray();
        Arrays.sort(tempStore2);

        if(Arrays.equals(tempStore1, tempStore2)) return true;
        else return false;
    }
    public static void main(String strs[]) {
        String inputString1 = "anagram";
        String inputString2 = "nagaram";

        System.out.println(isAnagram(inputString1, inputString2));
    }
}