package Leetcode_100;

import java.util.*;

class Solution {
    public static String[] uncommonFromSentences(String s1, String s2) {
        ArrayList<String> res = new ArrayList<>();

        Map<String, Integer> count = new HashMap<>();
        //Store each word by using blank space as separator
        String [] tempStore = (s1+ " "+ s2).split(" ");
        for (String w : tempStore)
            count.put(w, count.getOrDefault(w, 0) + 1);

        for(String w: tempStore)
            if(count.get(w) == 1) res.add(w);
        return res.toArray(new String[0]);
    }
    public static void main(String strs[]) {
        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";
        String [] result = uncommonFromSentences(s1, s2);
        for(String s: result) System.out.print(s + ", ");
    }
}