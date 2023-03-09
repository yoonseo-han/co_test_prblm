package Leetcode_100;

class Solution {
    public static boolean isPalindrome(int x) {
        //Edge cases
        if(x>=0 && x<=9 ) return true;
        if(x<0) return false;

        String s = String.valueOf(x); // Convert to String
        int n = s.length(); // Store the String length to int n

        for (int i=0; i<n/2; i++) {
            // We check whether the elements at the same distance from
            // beginning and from ending are same, if not we return false
            if (s.charAt(i) != s.charAt(n-i-1)) return false;
        }

        // if no flaws are found we return true
        return true;
    }
    public static void main(String strs[]) {
        int input = 123;
        System.out.println(isPalindrome(input));
    }
}