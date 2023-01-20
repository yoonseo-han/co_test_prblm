package Leetcode_100;

import java.util.HashMap;

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        //Edge cases: string having length of 0 and 1 
        if(s.length() == 0 || s.length() == 1) return s.length();

        //Initialize variables
        int firstPtr = 0;
        int secondPtr = 1;
        char[] inputString = s.toCharArray();
        //int count = (inputString[firstPtr] != inputString[secondPtr]) ? 2 : 1;
        int count = 1;
        int maxCount = count;

        //Hashtable initialization and add first and second
        HashMap<Character, Integer> storeMap = new HashMap<>();
        storeMap.put(inputString[firstPtr], 1);

        while(secondPtr < s.length()) {

            //If secondPtr element is not in hashtable
            if(!storeMap.containsKey(inputString[secondPtr]) || storeMap.get(inputString[secondPtr]) == 0) {
                //Add element to hashtable
                storeMap.put(inputString[secondPtr], 1);
                //Update count and max count
                count++;
                maxCount = (maxCount < count) ? count : maxCount;
                //Move second pointer
                secondPtr++;
            }
            //secondPtr element is already in hashtable
            else {
                //Move firstPtr to right and update count, and value in hahstable
                storeMap.put(inputString[firstPtr], storeMap.get(inputString[firstPtr]) - 1);
                count--;
                firstPtr++;
            }
        }


        return maxCount;
    }

    public static void main(String strs[]) {
        String inputString = "pwwkew";
        System.out.println(lengthOfLongestSubstring(inputString));
    }
}