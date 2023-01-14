package Leetcode_100;

import java.lang.Integer;
import java.lang.Math;

class Solution {
    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            //Retrieve the right end of the input integer : Note that 1 = 000...001
            result += n & 1;
            //Shift the input 1 position to right as rightmost element already dealt
            n >>>= 1;   //  must do unsigned shift
            if (i < 31) //  for last digit, don't shift!
                //As for the result, shift left as need to store in reverse order
                result <<= 1;
        }
        return result;
    }
    public static void main(String strs[]) {
        int inputString = 43261596;

        System.out.println(reverseBits(inputString));
    }
}