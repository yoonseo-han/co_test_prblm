package Leetcode_100;

class Solution {
    public static int findComplement(int num) {
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        return num ^ mask;
    }

    public static void main(String strs[]) {
        int num = 5;
        System.out.println(findComplement(num));
    }
}