package Leetcode_100;

import java.util.*;

class Solution {
    // check if c1 is a subset of c2
    private static boolean isComplete(int[] c1, int[] c2) {
        for (int i = 0; i < 26; ++i)
        if (c1[i] > c2[i])
            return false;
        return true;
    }
    
    private static int[] getCount(final String word) {
        int[] count = new int[26];
        for (final char c : word.toCharArray()) ++count[c - 'a'];
        return count;
    }

    public static String shortestCompletingWord(String licensePlate, String[] words) {
        //Using array for count
        int[] count = new int[26];
        String ans = "****************";

        for (char curChar : licensePlate.toCharArray()) {
            if(Character.isLetter(curChar)) count[Character.toLowerCase(curChar)-'a']++;
        }

        //O(n^2) loop for comparison
        for (final String word : words)
            if (word.length() < ans.length() && isComplete(count, getCount(word)))
                ans = word;
        //Return asnwer with shortest length
        return ans;
    }
    public static void main(String strs[]) {
        String licensePlate = "s3 PSt";
        String[] words = {"step","steps","stripe","stepple"};
        System.out.println(shortestCompletingWord(licensePlate, words));
    }
}