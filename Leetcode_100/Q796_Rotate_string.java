package Leetcode_100;

class Solution {
    public static boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
    public static void main(String strs[]) {
        String s = "abcde";
        String goal = "cdeab";
        System.out.println(rotateString(s, goal));
    }
}