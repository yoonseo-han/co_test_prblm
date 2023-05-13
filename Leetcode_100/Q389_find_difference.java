package Leetcode_100;

import java.util.*;

class Solution {
    public static char findTheDifference(String s, String t) {
        //Edge case
        if(s.length()==0) return t.toCharArray()[0];

        HashMap<Character, Integer> store = new HashMap<>();

        for(int i=0; i<s.length(); i++) store.put(s.charAt(i), store.getOrDefault(s.charAt(i), 0) + 1);

        for(int i=0; i<t.length(); i++) {
            if(store.containsKey(t.charAt(i))) {
                store.put(t.charAt(i), store.get(t.charAt(i))-1);
                if(store.get(t.charAt(i)) < 0) return t.charAt(i);
            }
            else return t.charAt(i);
        }
        return 'c';
    }
    public static void main(String strs[]) {
        String s = "abcd";
        String t = "abcde";
        System.out.println(findTheDifference(s,t));
    }
}