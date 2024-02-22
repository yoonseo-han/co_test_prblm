package Leetcode_100;

import java.util.*;

class StringLengthComparator implements Comparator<String> {
        @Override
        public int compare(String str1, String str2) {
            return str1.length() - str2.length();// compare length of Strings
        }
}

class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        //Sort based on length of string
        //Arrays.sort(words, new StringLengthComparator());
        int count = 0;
        
        for(int i=0; i<words.length-1; i++) {
            //Word to be compared from
            int lengthOfSubWord = words[i].length();
            String subWord = words[i];
            for(int j=i+1; j<words.length; j++) {
                String compareWord = words[j];
                int compareWordLength = compareWord.length();
                if(compareWordLength < lengthOfSubWord) continue;
                if(compareWord.substring(0, lengthOfSubWord).equals(subWord) && compareWord.substring(compareWordLength - lengthOfSubWord, compareWordLength).equals(subWord)) count++;
            }
        }
        
        return count;
    }
}