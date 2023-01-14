package Leetcode_100;

import java.lang.Integer;
import java.lang.Math;

class Solution {
    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;   //  must do unsigned shift
            if (i < 31) //  for last digit, don't shift!
                result <<= 1;
        }
        return result;
    }
    public static void main(String strs[]) {
        int inputString = 43261596;

        System.out.println(reverseBits(inputString));
    }
}