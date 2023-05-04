package Leetcode_100;

class Solution {
    public static int arrangeCoins(int n) {
        int rank = 0;
        for(int i=1; i<=n; i++) {
            rank += i;
            if(rank>=n) return i-1;
        }
        return 0;
    }
    public static void main(String strs[]) {
        int n=5;
        System.out.println(arrangeCoins(n));
    }
}