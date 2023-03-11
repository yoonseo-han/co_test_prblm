package Leetcode_100;

import java.util.*;

class Solution {
    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder answer = new StringBuilder();

        //Deal with edge cases
        if(numerator == 0) return "0";

        //Deal with different signs
        // "+" or "-"
        answer.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");

        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        //Integer part
        answer.append(num/den);
        num%= den;
        if(num==0) return answer.toString();

        //Fractional part
        answer.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, answer.length());

        while(num!=0) {
            num *= 10;
            answer.append(num/den);
            num %= den;
            if(map.containsKey(num)) {
                int index = map.get(num);
                answer.insert(index, "(");
                answer.append(")");
                break;
            }
            else map.put(num, answer.length());
        }

        return answer.toString();
    }
    public static void main(String strs[]) {
        int numerator = 4;
        int denominator = 333;

        System.out.println(fractionToDecimal(numerator, denominator));
    }
}