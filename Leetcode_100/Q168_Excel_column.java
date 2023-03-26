package Leetcode_100;

class Solution {
    public static String convertToTitle(int columnNumber) {
        return columnNumber == 0 ? "" : convertToTitle(--columnNumber / 26) + (char)('A' + (columnNumber % 26));
    }

    public static void main(String strs[]) {
        int columnNumber = 28;
        System.out.println(convertToTitle(columnNumber));
    }
}