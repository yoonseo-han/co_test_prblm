package Leetcode_100;

class Solution {
    public static boolean isCapital(char c) {
        if(c >= 'A' && c<='Z') return true;
        else return false;
    }

    public static boolean detectCapitalUse(String word) {
        int count = 0;
        for(int i=0; i<word.length(); i++) {
            if(isCapital(word.charAt(i))) count++;
        }
        //Case 1
        if(count == word.length()) return true;
        if(count == 0) return true;
        if(count == 1 && isCapital(word.charAt(0))) return true;
        return false;
    }
    public static void main(String strs[]) {
        String word = "USA";
        System.out.println(detectCapitalUse(word));
    }
}