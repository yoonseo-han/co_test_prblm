package Leetcode_100;

class Solution {
    public static boolean hasAlternatingBits(int n) {
        while(n!=0){
            int a=(n&1);
            n>>=1;
            int b=(n&1);
            if(a==b)
                return false;
        }
        return true;
    }
    public static void main(String strs[]) {
        int n = 11;
        System.out.println(hasAlternatingBits(n));
    }
}