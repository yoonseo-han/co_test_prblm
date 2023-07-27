package Leetcode_100;

import java.util.*;

class Solution {
    public static String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> count = new HashMap<>();

        //Remove all blank spaces and non-alphabets, then transform to lower case
        String[] words = paragraph.toLowerCase().split("[ !?',;.]+");

        //Include words and count 
        for(String word: words) count.put(word, count.getOrDefault(word, 0)+1);

        //Excludes banned word
        for(String word : banned) if(count.containsKey(word)) count.remove(word);
        
        //Find word with higest count
        String res = null;
        for(String word : count.keySet())
            if(res == null || count.get(word) > count.get(res)) res = word;
        return res;
    }
    public static void main(String strs[]) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String [] banned = {"hit"};
        System.out.println(mostCommonWord(paragraph, banned));
    }
}