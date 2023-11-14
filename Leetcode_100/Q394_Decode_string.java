package Leetcode_100;

import java.util.*;

class Solution {
    public static String decodeString(String s) {
        Stack <Character> tempStore = new Stack<>();

        for(char c: s.toCharArray()) {
            if(c != ']') tempStore.push(c);

            else {
                // If find ] then retrieve the string till reach number next to [
                StringBuilder sb = new StringBuilder();
                while(!tempStore.isEmpty() && Character.isLetter(tempStore.peek())) sb.insert(0, tempStore.pop());
                
                String sub = sb.toString();
                tempStore.pop();

                //Retrieve the number stored in tempStore
                sb = new StringBuilder();
                while(!tempStore.isEmpty() && Character.isDigit(tempStore.peek())) {
                    sb.insert(0, tempStore.pop());
                }

                int num = Integer.valueOf(sb.toString());

                while(num > 0)
                {
                    for(char ch : sub.toCharArray())  tempStore.push(ch);
                    num--;
                }
            }
        }

        //final fetching and returning the value in stack 
        StringBuilder retv = new StringBuilder();
        while(!tempStore.isEmpty())
            retv.insert(0, tempStore.pop());

        return retv.toString();
    }
    public static void main(String strs[]) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }
}