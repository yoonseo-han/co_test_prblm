package Leetcode_100;

class Solution {
    public static String convertToBase7(int num) {
        //Recursive approach

        //For negative numbers
        if (num < 0) return "-" + convertToBase7(-num);

        //Concatenate result to string : Final result
        if (num < 7) return Integer.toString(num);

        //Concatenate latest result
        return convertToBase7(num / 7) + Integer.toString(num % 7);
    }
    public static void main(String strs[]) {
        int num = 100;
        System.out.println(convertToBase7(num));
    }
}