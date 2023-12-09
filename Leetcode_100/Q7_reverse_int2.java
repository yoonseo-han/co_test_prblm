package Leetcode_100;

class Solution {
    public static int reverse(int x) {
        long result = 0;
        boolean isNegative = false;

        if(x<0) {
            isNegative = true;
            x*=-1;
        }

        while(x!=0) {
            int lastDig = x%10;
            result += lastDig;
            result = result*10;
            x= x/10;
        }
        result /= 10;

        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;

        return isNegative? (int) (result*-1) :(int) result;
    }
    public static void main(String strs[]) {
        int x = 123;
        System.out.println(reverse(x));
    }
}