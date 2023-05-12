package Leetcode_100;

class Solution {
    public static boolean isPowerOfFour(int n) {
        if(n<=0) return false;
        if(n==1) return true;
        if(n%4==0) return isPowerOfFour(n/4);
        else return false;
    }

    public static void main(String strs[]) {
        int n = 16;
        System.out.println(isPowerOfFour(n));
    }
}