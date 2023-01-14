package Leetcode_100;

class Solution {
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int count = 0;

        for (int i = 0; i < 32; i++) {
            int tempBit = n&1;

            if(tempBit == 1) count++;

            n>>>=1;
        }

        return count;
    }
    public static void main(String strs[]) {
        int inputNumber = 11;
        System.out.println(hammingWeight(inputNumber));
    }
}