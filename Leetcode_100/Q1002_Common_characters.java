package Leetcode_100;

import java.util.*;

class Solution {
    public static List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();

        //For each string we count the frequency of chars 
        //Then we store it in min array
        int [] minCount = new int[26];

        for(int i=0; i<26; i++) minCount[i] = Integer.MAX_VALUE;
        
        //For characters that does not exist at all: set to 0 automatically
        for(int i=0; i<words.length; i++) {
            int [] curCount = new int[26];
            for(char c:words[i].toCharArray()) curCount[c-'a']++;
            for(int j=0; j<26; j++) minCount[j] = Math.min(minCount[j], curCount[j]);
        }

        //Add the ones that remains by the min count
        for(int i=0; i<26; i++) {
            //Type casting
            for(int j=0; j<minCount[i]; j++) result.add(String.valueOf((char)('a' + i)));
        }

        return result;
    }
    public static void main(String strs[]) {
        String [] words = {"bella", "label", "roller"};
        List<String> res = commonChars(words);
        for(String s : res) System.out.print(s + ", ");
    }
}