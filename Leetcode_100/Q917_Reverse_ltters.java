package Leetcode_100;

import java.util.*;

class Solution {
    public static String reverseOnlyLetters(String s) {
        Stack <Character> store = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            if((s.charAt(i) >= 'a' && s.charAt(i) <='z') ||(s.charAt(i) >= 'A' && s.charAt(i) <='Z')) store.push(s.charAt(i));
        }
        
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            if((s.charAt(i) >= 'a' && s.charAt(i) <='z') ||(s.charAt(i) >= 'A' && s.charAt(i) <='Z')) sb.append(store.pop());
            else sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    public static void main(String strs[]) {
        String s = "ab-cd";
        System.out.println(reverseOnlyLetters(s));
    }
}