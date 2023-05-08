package Leetcode_100;

import java.util.Arrays;

class Solution {
    public static int findContentChildren(int[] g, int[] s) {
        //First sort each of the received array in ascending order
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;

        //Approach: Using 2 pointer approach
        int i = 0; // pointer to the current child's greed factor
        int j = 0; // pointer to the current cookie size
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) { // if the current cookie can satisfy the current child's greed factor
                count++;
                i++;
            }
            j++;
        }

        return count;
    }

    public static void main(String strs[]) {
        int [] g = {1,2,3};
        int [] s = {1,1};

        System.out.println(findContentChildren(g,s));
    }
}