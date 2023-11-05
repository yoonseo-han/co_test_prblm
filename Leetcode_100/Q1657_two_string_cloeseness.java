package Leetcode_100;

import java.util.*;

class Solution {
    private static int N = 26;

    public static boolean closeStrings(String word1, String word2) {
		// count the English letters
        int[] arr1 = new int[N], arr2 = new int[N];
        for (char ch : word1.toCharArray()) arr1[ch - 'a']++;
        for (char ch : word2.toCharArray()) arr2[ch - 'a']++;

        // if one has a letter which another one doesn't have, dont exist
        for (int i = 0; i < N; i++) {
            if (arr1[i] == arr2[i]) {
                continue;
            }
            if (arr1[i] == 0 || arr2[i] == 0) {
                return false;
            }
        }

        //Sort 2 arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < N; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String strs[]) {
        String word1 = "abc";
        String word2 = "bca";
        System.out.println(closeStrings(word1,word2));
    }
}