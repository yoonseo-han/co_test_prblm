package Leetcode_100;

class Solution {
    public static boolean isSubsequence(String s, String t) {
        //Note that string s is the one having shorter length always
        int iterS = 0;
        int iterT = 0;

        //Edge case
        if(s.length()==0) return true;

        while(iterT < t.length() && iterS < s.length()) {
            if(t.charAt(iterT) == s.charAt(iterS)) iterS++;
            iterT++;
        }

        return iterS == s.length()? true: false;
    }
    public static void main(String strs[]) {
        String s = "b";
        String t = "abc";

        System.out.println(isSubsequence(s,t));
    }
}