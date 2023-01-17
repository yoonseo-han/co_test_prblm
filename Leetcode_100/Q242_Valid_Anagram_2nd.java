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

        int [] alphabetArr = new int[26];
        for(int i=0; i<s.length(); i++) {
            alphabetArr[s.charAt(i)-'a']++;
            alphabetArr[t.charAt(i)-'a']--;
        }

        for(int i:alphabetArr) {
            if(i!=0) return false;
        }
        
        return true;
    }
    public static void main(String strs[]) {
        String inputString1 = "anagram";
        String inputString2 = "nagaram";

        System.out.println(isAnagram(inputString1, inputString2));
    }
}