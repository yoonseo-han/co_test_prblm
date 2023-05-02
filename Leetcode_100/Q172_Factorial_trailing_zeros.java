package Leetcode_100;

class Solution {
    public static int trailingZeroes(int n) {
        if(n==0) return 0;
        else return n/5 + trailingZeroes(n/5);
    }

    public static void main(String strs[]) {
        int n = 3;
        System.out.println(trailingZeroes(n));
    }
}