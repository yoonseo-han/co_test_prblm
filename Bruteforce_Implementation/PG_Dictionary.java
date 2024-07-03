package Bruteforce;

import java.util.*;

/*
1   A
2   AA
3   AAA
4   AAAA
5   AAAAA
6   AAAAE
7   AAAAI
8   AAAAO
9   AAAAU
10  AAAE
11  AAAEA
    .
    .
    .
16  AAAI
    .
    .
    .
22  AAAO
    .
    .
    .
28  AAAU
    .
    .
    .
34  AAE

- Fill the characters starting from left and consider the null to be characters aswell
- Order: [nullchar, A, E, I, O, U]

x 가 0이 아닐 때 : f(x) = f(x - 1) + 5^x
f(0) = 1
f(1) = 1 + 5^1 = 6
f(2) = 6 + 5^2 = 31
f(3) = 31 + 5^3 = 156
f(4) = 156 + 5^4 = 781
-> Represents the rate of increase
-> Ex) Changing from AAAA to AAAE causes increase of 6\
-> EA = (781*1) + 1
*/ 

class Solution {
    static final String MAPPING = "AEIOU";
    static final int[] RATE_OF_INCREASE = {781, 156, 31, 6, 1};

    public static int solution(String word) {
        int answer = word.length();

        for(int i=0; i<word.length(); i++) {
            answer += RATE_OF_INCREASE[i]*MAPPING.indexOf(word.charAt(i));
        }

        return answer;
    }
    public static void main(String strs[]) {
        String word = "";
        System.out.println(solution(word));
    }
}