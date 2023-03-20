package Leetcode_100;

import java.util.*;
import java.lang.*;

class Solution {
    public static int calculate(String s) {
        //Edge case
        if(s == null || s.length() == 0) return 0;

        //Use stack
        Stack<Integer> store = new Stack<>();
        int num = 0;
        char operator = '+';

        for(int i=0; i<s.length(); i++) {
            //If integer: Store to num
            if(Character.isDigit(s.charAt(i))) num = (num*10) +(s.charAt(i) - '0');

            //Store intermediate result based on operation
            if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length()-1) {
                if(operator == '+') store.push(num);
                else if(operator == '-') store.push(-num);
                else if (operator == '*') store.push(store.pop() * num);
                else store.push(store.pop() / num);
                num = 0;
                operator = s.charAt(i);
            }
        }

        int answer = 0;
        for(int i: store) answer += i;

        return answer;
    }

    public static void main(String strs[]) {
        String inputString = "3+2*2";
        System.out.println(calculate(inputString));
    }
}