package Leetcode_100;

import java.lang.Integer;
import java.lang.Math;

class Solution {
    public static int divide(int dividend, int divisor) {

        //Edge case
        if(dividend == divisor) return 1;
        
        //Intialize variable
        long sum = 0;
        //get the abolute value of both dividend and divisor
        long dividendAbs = Math.abs((long)dividend);
        long divisorAbs = Math.abs((long)divisor);
        //Determine if anwer is positive : If both have same sign, then answer is positive
        boolean isPositive = (dividend>0 == divisor>0);

        while(dividendAbs >= divisorAbs) {
            int count = 0;
            while(dividendAbs > (divisorAbs << count+1)) {
                count++;
            }
            dividendAbs -= (divisorAbs << count);
            sum += (1<<count);
        }

        //If answer cant be stored in INT MAX
        if(isPositive && sum > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(!isPositive && sum > (long)(-1)*Integer.MIN_VALUE) return Integer.MIN_VALUE;
        System.out.println(sum);
        return (int) ((isPositive)? sum: (-1)*sum);
    }

    public static void main(String strs[]) {
        int dividend = -2147483648;
        int divisor = -1;
        System.out.println(divide(dividend, divisor));
    }
}