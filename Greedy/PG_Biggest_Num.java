package Greedy;

import java.util.*;
import java.lang.*;

class Solution {
    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        int len = number.length()-k;
        int startIndex = 0;
        int rightNum = len-1;

        while(startIndex < number.length()&& answer.length() != len) {
            int max = 0;
            for(int j = startIndex; j<(number.length()-rightNum); j++) {
                if(max<number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    startIndex = j+1;
                }
            }
            answer.append(Integer.toString(max));
            rightNum--;
        }

        return answer.toString();
    }

    public static void main(String strs[]) {
        String inputNumber = "1924";
        int k = 2;
        System.out.println(solution(inputNumber, k));
    }
}