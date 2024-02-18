package Leetcode_100;

import java.util.*;

class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
        HashMap<Character, Integer> tempStore = new HashMap<>();
        int count = 0;
        
        //Count each character and freq
        for(String curString: words) {
            for(int i=0; i<curString.length(); i++) {
                char c = curString.charAt(i);
                tempStore.put(c, tempStore.getOrDefault(c, 0) + 1);
            }
        }        
        
        //Sort array interms of length
        Arrays.sort(words, Comparator.comparing(String::length));

        //COunt number of total pairs
        int pairs = 0;
        for(HashMap.Entry<Character, Integer> entry: tempStore.entrySet()) pairs += entry.getValue()/2;
        
        //For each word length: Assess appropriateness
        for(String curString: words) {
            int lengthOfWord = curString.length();
            
            int numOfPair = (lengthOfWord/2);
            int numOfOdd = (lengthOfWord%2);

            if((pairs -= numOfPair) < 0) return count;
            count++;
        }
        return count;
    }
}