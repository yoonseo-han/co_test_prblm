package Leetcode_100;

class Solution {
    public static int binaryGap(int N) {
        //Constantly divide by 2 and calculate the iteration

        int res = 0;
        //d represents the distance and hence initialized to smallest value achievable
        for (int d = -32; N > 0; N /= 2, d++)
            if (N % 2 == 1) {
                res = Math.max(res, d);
                d = 0;
            }
        return res;
    }
    public static void main(String strs[]) {
        int n = 22;
        System.out.println(binaryGap(n));
    }
}