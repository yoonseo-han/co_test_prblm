package Leetcode_100;

class Solution {
    public static boolean isOneBitCharacter(int[] bits) {
        int ones = 0;
        //Starting from one but last, as last one is always 0.
        for (int i = bits.length - 2; i >= 0 && bits[i] != 0 ; i--) { 
            ones++;
        }
        //if there is odd amount of 1(10, ...01110, etc) the answer is false as there is a single 1 without pair
        if (ones % 2 > 0) return false; 

        return true;
    }
    public static void main(String strs[]) {
        int [] bits = {1,0,0};
        System.out.println(isOneBitCharacter(bits));
    }
}