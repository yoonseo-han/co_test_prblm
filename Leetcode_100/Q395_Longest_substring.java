package Leetcode_100;

class Solution {
    public static int longestSubstring(String s, int k) {
        //Record frequency of each char
        char[] chars = new char[26];
        for (int i = 0; i < s.length(); i ++) chars[s.charAt(i) - 'a'] += 1;

        boolean flag = true;
        for (int i = 0; i < chars.length; i += 1) {
            //Check if whole string contains any element that has frequency less than k
            if (chars[i] < k && chars[i] > 0) flag = false;
        }
        // return the length of string if this string is a valid string
        if (flag == true) return s.length();

        int result = 0;
        int start = 0, cur = 0;
        // otherwise we use all the infrequent elements as splits
        while(cur<s.length()) {
            if (chars[s.charAt(cur) - 'a'] < k) {
                result = Math.max(result, longestSubstring(s.substring(start, cur), k));
                start = cur + 1;
            }
            cur++;
        }
        result = Math.max(result, longestSubstring(s.substring(start), k));
        return result;
    }
    public static void main(String strs[]) {
        String s = "aaabb";
        int k = 3;
        System.out.println (longestSubstring(s, k));
    }
}