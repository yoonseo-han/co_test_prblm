package Leetcode_100;

import java.util.Stack;

class Solution {
    public static boolean isValid(String str) {

        char[] LP = {'(', '[', '{'};
        char[] RP = {')', ']', '}'};
        
        //Change input string to char array to iterate
        char[] inputString = str.toCharArray();

        //Stack for input
        Stack<Character> recordStack = new Stack<Character>();

        for(int i=0; i<str.length(); i++) {
            //If parenthesis is left parenthesis
            if(inputString[i] == LP[0] || inputString[i] == LP[1] || inputString[i] == LP[2]) {
                //Push input to stack
                recordStack.push(inputString[i]);
            }
            //If Parenthesis is Right parenthesis
            else {
                //When there is only RP
                if(recordStack.isEmpty()) return false;
                //Pop element in stack
                char temp = recordStack.pop();
                //Check if parenthesis matches 
                //First retrieve index in LP and compare in index in RP
                for(int j=0; j<3; j++) {
                    if(temp == LP[j]) {
                        if (RP[j] == inputString[i]) break;
                        else return false;
                    }
                }
            }
        }

        //If there is element remaining in stack
        if(!recordStack.isEmpty()) return false;
        
        return true;
    }

    public static void main(String strs[]) {
        String inputString = "]";
        System.out.println(isValid(inputString));
    }
}