package Leetcode_100;

import java.lang.String;

class Solution {
    public static String longestPalindrome(String s) {
        //Edge cases
        if(s.length() == 1) return s;

        //Change to char array
        char[] inputString = s.toCharArray();

        //Define and initialize variables
        boolean dp[][] = new boolean[s.length()][s.length()];
        int max = 0;
        int max_i = 0;
        int max_j = 0;

        //Use dp for solving problem
        for(int i=s.length()-1; i>=0; i--) {
            for(int j=i; j<s.length(); j++) {
                //Base case
                if(i==j) dp[i][j] = true;
                //Recursive case
                else if(inputString[i] == inputString[j]) {
                    if(j-i == 1) dp[i][j] = true;
                    else dp[i][j] = dp[i+1][j-1];
                }
                //If max is updated
                if(dp[i][j] == true && max<=(j-i)) {
                    max = j-i;
                    max_i = i;
                    max_j = j;
                }
            }
        }

        //Retrive the max
        char[] resultArray = new char[max+1];
        for(int i = max_i, counter = 0; i<=max_j; i++, counter++) {
            resultArray[counter] = inputString[i];
        }

        s = String.valueOf(resultArray);
        return s;    
    }

    public static void main(String strs[]) {
        String inputString = "babad";
        System.out.println(longestPalindrome(inputString));
    }
}