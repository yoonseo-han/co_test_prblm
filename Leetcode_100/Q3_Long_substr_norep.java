package Leetcode_100;

import java.util.*;

class Solution {
    public static int lengthOfLongestSubstring(String inputString) {
        //Edge case
        if(inputString.length() == 1 && inputString.length() == 0) return inputString.length();

        if(inputString.length() == 2 && inputString.charAt(0) != inputString.charAt(1)) return 1;

        //Use 2 pointer technique
        int left = 0;
        int right = 1;
        HashMap<Character, Integer> tempStore = new HashMap<>();
        //ADd following components to hashtable
        tempStore.putIfAbsent(inputString.charAt(0), 1);
        int curLength = 1;
        int maxLength = curLength;

        while(right < inputString.length()) {
            //Check if right element is already present in  hash table: Right element not present in hash table
            if(!tempStore.containsKey(inputString.charAt(right))) {
                //Add element to hashtable
                tempStore.put(inputString.charAt(right), 1);
                curLength++;
                maxLength = Math.max(maxLength, curLength);
                right++;
            }
            //Right element already present in hashtable
            else {
                //Increase left position pointer
                left++;
                curLength--;
            }
        }

        return maxLength;
    }
    public static void main(String[] args) {
        String inputString = "ppoowerzspwer";
        System.out.println(lengthOfLongestSubstring(inputString));
    }
}