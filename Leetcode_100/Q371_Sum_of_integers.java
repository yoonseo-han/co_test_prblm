package Leetcode_100;

class Solution {
    public static int getSum(int a, int b) {
        if(b==0) return a;
        else return getSum(a^b, (a&b)<<1);
    }
    public static void main(String strs[]) {
        int a = 1;
        int b = 2;
        System.out.println(getSum(a,b));
    }
}