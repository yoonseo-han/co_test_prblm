package Leetcode_100;

import java.util.*;

class Solution {
    public static int findLUSlength(String a, String b) {
        if (a.equals(b))
            return -1;
        return Math.max(a.length(), b.length());
    }
    public static void main(String strs[]) {
        String a = "aba";
        String b = "cdc";

        System.out.println(findLUSlength(a,b));
    }
}