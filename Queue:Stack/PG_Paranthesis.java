//https://school.programmers.co.kr/learn/courses/30/lessons/12909
//package Queue:Stack;
import java.util.*;

class Solution {
    public static boolean solution(String s) {

        Stack<Character> tempStore = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(c == '(') tempStore.push('(');
            else {
                if(tempStore.isEmpty()) return false;
                else tempStore.pop();
            }
        }

        return (tempStore.isEmpty() == true) ? true:false ;
    }

    public static void main(String strs[]) {
        String s = "(()())(";
        System.out.println(solution(s));
    }
}