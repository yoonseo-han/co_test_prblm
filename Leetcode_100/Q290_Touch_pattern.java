package Leetcode_100;

import java.util.*;

class Solution {
    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> store = new HashMap<>();
        String [] storeString = s.split(" ");

        for(int i=0; i<pattern.length(); i++) {
            char tempChar = pattern.charAt(i);
            //Where key already exist
            if(store.containsKey(tempChar)) {
                //Where corresponding word does not match
                if(!store.get(tempChar).equals(storeString[i])) return false;
                else continue;
            }
            //Where key does not exit
            else {
                //Key does not exist but word exist
                if(store.containsValue(storeString[i])) return false;
                else store.put(tempChar, storeString[i]);
            }
        }

        return true;
    }
    public static void main(String strs[]) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(wordPattern(pattern,s));
    }
}