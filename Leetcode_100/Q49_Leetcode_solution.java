package Leetcode_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Solution{

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        //Create hashmap to store elements
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            //Sorted string is the key of the map
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            //If map does not contain key, add new keyu
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            //ADd the original string as value that matches the sorted string key
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String strs[]) {
        String [] inputString = {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(inputString);
    }
}