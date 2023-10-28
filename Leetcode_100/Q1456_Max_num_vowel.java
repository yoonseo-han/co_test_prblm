package Leetcode_100;

class Solution {
    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static int maxVowels(String s, int k) {
        int cnt = 0;
        int max = 0;
        for (var i=0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) cnt++;
            if (i >= k && isVowel(s.charAt(i-k))) cnt--;
            
            max = Math.max(max, cnt);
        }
        return max;
    }
    public static void main(String strs[]) {
        String s = "abciiidef";
        int k = 3;
        System.out.println(maxVowels(s,k));
    }
}