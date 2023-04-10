package Leetcode_100;

import java.util.*;

class Solution {
    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> curList = new ArrayList<>();

        for(int i=0; i<expression.length(); i++) {
            char c = expression.charAt(i);
            if(c=='+' || c=='-' || c=='*') {
                String a = expression.substring(0, i);
                String b = expression.substring(i+1);

                List<Integer> firstList = diffWaysToCompute(a);
                List<Integer> secondList = diffWaysToCompute(b);

                for(int x : firstList) {
                    for(int y: secondList) {
                        if(c=='+') curList.add(x+y);
                        else if(c=='*') curList.add(x*y);
                        else if(c=='-') curList.add(x-y);
                    }
                }
            }
        }
        if(curList.size()==0) curList.add(Integer.valueOf(expression));

        return curList;
    }
    public static void main(String strs[]) {
        String expression = "2*3-4*5";
        System.out.println(diffWaysToCompute(expression));
    }
}