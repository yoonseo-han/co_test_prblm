//https://school.programmers.co.kr/learn/courses/15008/lessons/121683

import java.util.*;

class Solution {
    public String solution(String input_string) {
        String answer = "";
        
        int firstInd = 0;
        int secondInd = firstInd+1;
        int count = 0;
        HashSet<Character> tempStore = new HashSet<>();
        HashSet<Character> ansStore = new HashSet<>();
        
        while(firstInd < input_string.length() && secondInd < input_string.length() ) {
            if(input_string.charAt(firstInd) == input_string.charAt(secondInd)) secondInd++;
            else {
                char curChar = input_string.charAt(firstInd);
                if(tempStore.contains(curChar)) {
                    ansStore.add(curChar);
                    count++;
                }
                else tempStore.add(curChar);
                firstInd = secondInd;
                secondInd++;
            }
        }
        char lastChar = input_string.charAt(firstInd);
        if(tempStore.contains(lastChar)) {
            ansStore.add(lastChar);
            count++;
        }
        char realLastChar = input_string.charAt(input_string.length()-1);
        if(Character.compare(lastChar,realLastChar)!=0 && tempStore.contains(realLastChar)) {
            ansStore.add(realLastChar);
            count++;
        }
        for(char c: ansStore) answer += String.valueOf(c);
        char[] chars = answer.toCharArray();

        Arrays.sort(chars);
        String sorted = new String(chars);
        
        return (count != 0)? sorted: "N";
    }
}