package Leetcode_100;

class Solution{
    public static int hammingDistance(int x, int y) {
        int result = 0;
        if(x == y) return result;
        int diffOfBit = x^y;

        while(diffOfBit != 0){
            diffOfBit = diffOfBit & (diffOfBit-1);
            result++;
        }

        return result;
    }

    public static void main(String strs[]) {
        int x = 4;
        int y = 1;
        System.out.println(hammingDistance(x, y));
    }
}