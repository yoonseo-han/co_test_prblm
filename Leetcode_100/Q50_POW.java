package Leetcode_100;

class Solution {
    public static double myPow(double x, int n) {
        double returnNum = 0;

        //Take note that x^4 = (x^2)^2

        //Use recursive approach and deal n in more efficient mannger

        //Special case: When power is negative: if n<0, start multiplying 1/x n times
        if(n<0) return 1/x*myPow(1/x, -(n+1));

        //Edge case: When power is 0,1,2
        if(n==0) return 1;
        if(n==1) return x;
        if(n==2) return x*x;

        //Recursive case 1 : When power is even number
        if(n%2==0) return myPow(x*x, n/2);

        //Recursive case 2: When power is odd number
        else return x*myPow(x*x, n/2);
    }

    public static void main(String[] strs) {
        double inputDouble = 2;
        int powerNum = 5;
        System.out.println(myPow(inputDouble, powerNum));
    }
}