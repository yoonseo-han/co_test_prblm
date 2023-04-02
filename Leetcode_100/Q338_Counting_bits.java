package Leetcode_100;

class Solution{
    public static int[] countBits(int n) {
        int[] result = new int[n+1];
        int offset = 1;
        result[0] = 0;

        for(int i=1; i<=n; i++) {
            if(offset*2 == i) offset*=2;
            result[i] = result[i - offset] + 1;
        }

        return result;
    }
    public static void main(String strs[]) {
        int inputNumber = 5;
        System.out.println(countBits(inputNumber));
    }
}