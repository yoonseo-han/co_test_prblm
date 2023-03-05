package Leetcode_100;

import java.util.*;

class Solution {
    public static boolean isIsomorphic(String s, String t) {
        //Define two hashtable
        HashMap<Character, Integer> storeS = new HashMap<>();
        HashMap<Character, Integer> storeT = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char sVal = s.charAt(i);
            char tVal = t.charAt(i);
            //Store char and appearance in hash map
            if(storeS.containsKey(sVal)) storeS.put(sVal, storeS.get(sVal)+1);
            if(storeT.containsKey(tVal)) storeT.put(tVal, storeT.get(tVal)+1);
            if (!storeS.containsKey(sVal)) storeS.put(sVal,1);
            if (!storeT.containsKey(tVal)) storeT.put(tVal,1);
        }

        for(int i=0; i<s.length(); i++) {
            char sVal = s.charAt(i);
            char tVal = t.charAt(i);

            //If appearance and numer doesnt match
            if(storeS.get(sVal) != storeT.get(tVal)) return false;
        }

        return true;
    }

    public static void main(String strs[]) {
        String s = "egg";
        String t = "add";
        System.out.println(isIsomorphic(s,t));
    }
}