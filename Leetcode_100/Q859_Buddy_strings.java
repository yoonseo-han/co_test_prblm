package Leetcode_100;

import java.util.*;

class Solution {
    public static boolean buddyStrings(String A, String B) {
        //Base case
        if (A.length() != B.length()) return false;

        int diff1 = -1, diff2 = -1;
        Set<Character> A_letters = new HashSet<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                if (diff1 == -1)
                    diff1 = i;
                else if (diff2 == -1)
                    diff2 = i;
                else
                    return false; // More than 2 different places between A & B
            }
            A_letters.add(A.charAt(i));
        }
        if (diff1 != -1 && diff2 != -1) // There are 2 different places
            return A.charAt(diff1) == B.charAt(diff2) && A.charAt(diff2) == B.charAt(diff1);
        if (diff1 != -1) // Only have 1 different place
            return false;
        return A_letters.size() < A.length(); // No different between A & B, check if A contains at least 1 duplicate letters.
    }
    public static void main(String strs[]) {
        String s = "ab";
        String goal = "ba";
        System.out.println(buddyStrings(s, goal));
    }
}