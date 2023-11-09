package Leetcode_100;

class Solution {
    public static int tribonacci(int n) {
        int [] tempArray = new int [n+1];

        tempArray[0] = 0;
        tempArray[1] = 1;
        tempArray[2] = 1;

        for(int i=3; i<tempArray.length; i++) {
            tempArray[i] = tempArray[i-1] + tempArray[i-2] + tempArray[i-3];
        }

        return tempArray[n];
    }

    public static void main(String strs[]) {
        //T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2
        int n = 25;
        System.out.println(tribonacci(n));
    }
}