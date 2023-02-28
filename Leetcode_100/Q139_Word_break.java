package Leetcode_100;

import java.util.*;

class Solution {
    public static boolean recursiveSol(String curString, Set<String> wordDict) {
        //Base case: When left over string has nothing
        if(curString.length() == 0) return true;

        for(int i=1; i<=curString.length(); i++) {
            //Consider all possible string
            if(wordDict.contains(curString.substring(0,i)) && recursiveSol(curString.substring(i), wordDict)) return true;
        }
        return false;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        //Store the word dictionary in hash list
        Set<String> set = new HashSet<>(wordDict);
        return recursiveSol(s, set);
    }
    public static void main(String strs[]) {
        String inputString = "leetcode";
        List<String> wordDict = new ArrayList<>();
        
        wordDict.add("leet");
        wordDict.add("code");

        System.out.println(wordBreak(inputString, wordDict));
    }
}