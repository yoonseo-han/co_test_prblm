package Leetcode_100;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void dfs(int n, int left, int right, List<String> returnList, String currentString) {
        //Termination condition: When length of string reaches n*2 => Max number of string
        if(currentString.length() == n*2) {
            //ADd current string to list
            returnList.add(currentString);
            return;
        }
        else {
            //Condition to add left parenthesis: When number of left parenthesis is less than n
            if(left<n) dfs(n, left+1, right, returnList, currentString + "(");
            //Condition to add right parantheis: When number of right parenthesis is less than number of left paranthesis
            if(right<left) dfs(n, left, right+1, returnList, currentString + ")");
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> returnList = new ArrayList<>();

        //Use recursive approach to generate parenthesis
        if(n!=0) dfs(n, 0, 0, returnList, "");

        return returnList;
    }

    public static void main(String strs[]) {
        int inputNumber = 3;
        System.out.println(generateParenthesis(inputNumber));
    }
}