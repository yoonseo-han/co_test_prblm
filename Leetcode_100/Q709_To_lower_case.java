package Leetcode_100;


class Solution {
    public static String toLowerCase(String s) {
        char [] result = new char[s.length()];
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) >='A' && s.charAt(i)<= 'Z') result[i] = (char) (s.charAt(i) + ('a'-'A'));
            else result[i] = s.charAt(i);
        }
        return String.valueOf(result);
    }
    public static void main(String strs[]) {
        String s = "Hello";
        System.out.println(toLowerCase(s));
    }
}