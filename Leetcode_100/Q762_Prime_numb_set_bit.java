package Leetcode_100;

import java.util.*;

class Solution {
    public static int countPrimeSetBits(int left, int right) {
        Set <Integer> primeSet = new HashSet<>(Arrays.asList(2,3,5,7,11,13,17,19));
        int cnt = 0;
        for(int i = left; i<=right; i++) {
            int bit = 0;
            for(int n=i; n>0; n>>=1) bit += (n&1);
            cnt += (primeSet.contains(bit)? 1:0);
        }

        return cnt;
    }
    public static void main(String strs[]) {
        int left = 6;
        int right = 10;
        System.out.println(countPrimeSetBits(left, right));
    }
}