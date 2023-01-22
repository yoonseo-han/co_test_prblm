package Leetcode_100;

import java.lang.Math;
import java.lang.Integer;

class Solution {
    public static int reverse(int x) {
        //Initialize variable
        long sum = 0;
        boolean isNegative = false;

        //Convert negative to positive first
        if(x<0) {
            x*=(-1);
            isNegative = true;
        }

        while(x>0) {
            int digit = x%10;
            x = x/10;
            sum = (sum*10) + digit;
            if(sum > Integer.MAX_VALUE) return 0;
        }
        
        //If negative is true
        if(isNegative) sum*=(-1);

        int returnSum = (int) sum;

        return returnSum;
    }
    public static void main(String strs[]) {
        int inputNumber = 1534236469;
        System.out.println(reverse(inputNumber));
    }
}