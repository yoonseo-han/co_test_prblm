package Leetcode_100;

import java.util.*;

class Solution {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int length = p.length();

        Hashtable <Character, Integer> tempStore = new Hashtable<>();
        // Record the appearance of the following character in string p
        for(char c: p.toCharArray()) tempStore.put(c, tempStore.getOrDefault(c, 0)+1);

        int start = 0;
        int end = 0;
        int size = tempStore.size();

        while(end < s.length()) {
            char endChar = s.charAt(end);
            if(tempStore.containsKey(endChar)) {
                if(tempStore.get(endChar) == 1) {
                    size--;
                }
                tempStore.put(endChar, tempStore.get(endChar)-1);
            }
            end++;

            //Check if all sub strng is reflected
            if (end - start > length) {
                char startChar = s.charAt(start);
                if (tempStore.containsKey(startChar)) {
                    int count = tempStore.get(startChar);
                    if (count == 0) {
                        size++;
                    }
                    tempStore.put(startChar, count + 1);
                }
                start++;
            }

            if (size == 0) {
                System.out.println("SIZE = 0");
                result.add(start);
            }
        }

        return result;
    }
    public static void main(String strs[]) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = findAnagrams(s, p);
        for(int i: result) System.out.println(i+",");
    }
}