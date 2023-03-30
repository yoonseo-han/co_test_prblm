package Leetcode_100;

class Solution {
    public static boolean isPrime(int n) {
        for(int i=2; i<n; i++) if(n%i==0) return false;

        return true;
    }
    public static boolean isUgly(int num) {
        for (int i=2; i<6 && num>0; i++)
            while (num % i == 0) num /= i;
        return num == 1;
    }

    public static void main(String strs[]) {
        int inputNum = 1000;
        System.out.println(isUgly(inputNum));
    }
}