package Leetcode_100;

import java.util.*;

class Solution {
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] pairs = new int[n];

        //Sort arrays first based on potions
        Arrays.sort(potions);

        for (int i = 0; i < n; i++) {
            //Get current spell
            int spell = spells[i];
            int left = 0;
            int right = m - 1;

            //Do binary search based on the product of spell and potion
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long product = (long) spell * potions[mid];
                if (product >= success) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            //Number of success calculated
            pairs[i] = m - left;
        }
        return pairs;

    }
    public static void main(String strs[]) {
        int [] spells = {5,1,3};
        int [] potions = {1,2,3,4,5};
        long success = 7;

        for(int i: successfulPairs(spells, potions, success)) {
            System.out.print(i + ",");
        }
    }
}