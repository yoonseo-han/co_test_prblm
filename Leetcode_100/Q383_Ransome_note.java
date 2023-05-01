package Leetcode_100;

import java.util.*;

class Solution {
    public static boolean canConstruct(String ransomNote, String magazine) {
        //Add each character into hash table
        char [] tempChar = magazine.toCharArray();
        Map<Character, Integer> store = new HashMap<>();

        for(int i=0; i<magazine.length(); i++) {
            if(!store.containsKey(magazine.charAt(i))) store.put(magazine.charAt(i), 1);
            else store.put(magazine.charAt(i), store.get(magazine.charAt(i))+1);
        }

        for(int i=0; i<ransomNote.length(); i++) {
            if(store.containsKey(ransomNote.charAt(i))) {
                if(store.get(ransomNote.charAt(i)) == 0) return false;
                else store.put(ransomNote.charAt(i), store.get(ransomNote.charAt(i))-1);
            }
            else return false;
        }
        return true;
    }
    public static void main(String strs[]) {
        String ransomeNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct(ransomeNote, magazine));
    }
}