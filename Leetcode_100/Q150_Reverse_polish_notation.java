package Leetcode_100;

import java.util.*;

class Solution {
    public static int evalRPN(String[] tokens) {
        Stack<String> store = new Stack<String>();

        for(int i=0; i<tokens.length; i++) {
            if(tokens[i]!="+" && tokens[i]!="-" && tokens[i]!="/" && tokens[i]!="*") store.push(tokens[i]);
            else {
                String temp;
                int secondNum = Integer.parseInt(store.pop());
                int firstNum = Integer.parseInt(store.pop());
                switch(tokens[i]) {
                    case "+" :
                        temp = Integer.toString(firstNum + secondNum);
                        store.push(temp);
                        break;
                    case "-" :
                        temp = Integer.toString(firstNum - secondNum);
                        store.push(temp);
                        break;
                    case "/" :
                        temp = Integer.toString(firstNum / secondNum);
                        store.push(temp);
                        break;
                    case "*" :
                        temp = Integer.toString(firstNum * secondNum);
                        store.push(temp);
                        break;
                }
            }
        }

        return Integer.parseInt(store.pop());
    }

    public static void main(String strs[]) {
        String [] inputString = {"2","1","+","3","*"};
        System.out.println(evalRPN(inputString));
    }
}