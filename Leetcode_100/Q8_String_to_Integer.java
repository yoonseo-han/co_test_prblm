package Leetcode_100;

import java.lang.Integer;

class Solution {
    public static int myAtoi(String s) {
        //Edge cases
        if(s.length() == 0) return 0;

        //Convert input String to input char array
        char [] inputArray = s.toCharArray();
        //Variable to record sign
        boolean isNegative = false;
        boolean isFirstChar = true;
        boolean numStarted = false;

        long sum = 0;

        for(int i=0; i<s.length(); i++) {
            //If obtain first letter and is - or +
            if(isFirstChar && (inputArray[i] == '-' || inputArray[i] == '+')) {
                isNegative = (inputArray[i] == '-')? true : false;
                isFirstChar = false;
                numStarted = true;
            }
            //Record to queue if array element is number
            else if(inputArray[i] >= '0' && inputArray[i] <= '9') {
                isFirstChar = false;
                sum = (sum*10) + (inputArray[i]-'0');
                numStarted = true;
                if(sum > Integer.MAX_VALUE && !isNegative) sum = Integer.MAX_VALUE;
                else if ((sum > (long)(-1)*Integer.MIN_VALUE) && isNegative) sum = (long)(-1)*Integer.MIN_VALUE;
            }
            //Else if non-digit but also not blankspace, break
            else if(inputArray[i] != ' ') break;
            //Else if blank space but num started, break
            else if(inputArray[i] == ' ' && numStarted) break;
        }
        if(isNegative) sum = (-1)*sum;

        int returnSum = (int) sum;
        return returnSum;
    }
    public static void main(String strs[]) {
        String inpuString = "-2147483648";
        System.out.println(myAtoi(inpuString));
    }
}