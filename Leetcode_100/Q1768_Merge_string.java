package Leetcode_100;

class Solution {
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();

        for(int i=0, j=0; i<word1.length() || j<word2.length(); ) {
            if(i<word1.length()) result.append(word1.charAt(i));
            if(j<word2.length()) result.append(word2.charAt(j));
            i++;
            j++;
        }

        return result.toString();
    }
    public static void main(String strs[]) {
        String word1 = "ab";
        String word2 = "pqrs";
        System.out.println(mergeAlternately(word1,word2));
    }
}