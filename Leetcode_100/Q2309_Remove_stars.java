package Leetcode_100;

import java.util.*;

class Solution {
    public static String removeStars(String s) {
        Stack <Character> tempStore = new Stack<>();
        char[] tempChar = s.toCharArray();

        for(int i=0; i<s.length(); i++) {
            if(tempChar[i]=='*') tempStore.pop();
            else tempStore.add(tempChar[i]);
        }
        StringBuilder res = new StringBuilder();
        while(!tempStore.isEmpty()) res.append(tempStore.pop());
        return res.reverse().toString();
    }
    public static void main(String strs[]) {
        String s = "leet**cod*e";
        System.out.println(removeStars(s));
    }
}