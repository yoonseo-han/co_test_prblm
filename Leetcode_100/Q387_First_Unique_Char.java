package Leetcode_100;

import java.util.HashMap;

class Solution {
    public static int firstUniqChar(String s) {
        //erdge cases
        if(s.length() == 1) return 0;

        //Convert string to char array
        char [] inputArray = s.toCharArray();

        //Define hashmap
        HashMap <Character, Integer> storeArray = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            if(!storeArray.containsKey(inputArray[i])) storeArray.put(inputArray[i], 1);
            else storeArray.put(inputArray[i], storeArray.get(inputArray[i])+1);
        }
        //Return first index
        for(int i=0; i<s.length(); i++) {
            if(storeArray.get(inputArray[i]) == 1) return i;
        }
        
        //If following number does not exist
        return -1;
    }

    public static void main(String strs[]) {
        String inputString = "loveleetcode";
        System.out.println(firstUniqChar(inputString));
    }
}