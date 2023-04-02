package Leetcode_100;

class Solution {
    public static boolean isPowerOfTwo(int n) {
        if(n==0) return false;
        if(n==1) return true;
        
        return (n%2==0) && isPowerOfTwo(n/2);
    }
    public static void main(String strs[]) {
        int inputNumber = 0;
        System.out.println(isPowerOfTwo(inputNumber));
    }
}