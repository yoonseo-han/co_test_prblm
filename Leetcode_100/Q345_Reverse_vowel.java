package Leetcode_100;

import java.util.*;

class Solution {
    public static String reverseVowels(String s) {
        HashSet<Character> store = new HashSet<>();
        store.add('a');
        store.add('e');
        store.add('i');
        store.add('o');
        store.add('u');
        store.add('A');
        store.add('E');
        store.add('I');
        store.add('O');
        store.add('U');

        char[] arr = s.toCharArray();

        int start = 0;
        int end = s.length()-1;
        while(start<end) {
            if(!store.contains(s.charAt(start))) start++;
            if(!store.contains(s.charAt(end))) end--;
            if(store.contains(s.charAt(end))&&store.contains(s.charAt(start))) {
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        return new String(arr);
    }
    public static void main(String strs[]) {
        String s = "hello";
        System.out.println(reverseVowels(s));
    }
}