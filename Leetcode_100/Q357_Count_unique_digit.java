package Leetcode_100;

class Solution {
    public static int countNumbersWithUniqueDigits(int n) {
        int res = 10;

        if(n==0) return 1;

        int uniqueDigits = 9;
        int availableNumber = 9;
        while (n-- > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            res += uniqueDigits;
            availableNumber--;
        }

        return res;
    }

    public static void main(String strs[]) {
        int n = 4;
        System.out.println(countNumbersWithUniqueDigits(n));
    }
}