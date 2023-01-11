package Leetcode_100;

import java.lang.Math;

class Solution {
    //Calculate 

    public static int titleToNumber(String columnTitle) {
        //Transform string to char
        char[] inputArray = columnTitle.toCharArray();
        int count = 0;

        for(int i=0; i<columnTitle.length(); i++) {
            int charVal = (inputArray[i] - 'A' + 1);
            System.out.println(charVal);
            count = (int) (count + (Math.pow(26, columnTitle.length()-i-1) * charVal));
        }
        return count;
    }
    
    public static void main(String strs[]) {
        String inputString = "ZY";

        System.out.println(titleToNumber(inputString));
    }
}