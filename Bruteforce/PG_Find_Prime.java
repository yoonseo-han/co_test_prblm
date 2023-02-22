//https://school.programmers.co.kr/learn/courses/30/lessons/42839?language=java

package Bruteforce;

import java.util.HashSet;
import java.util.Set;

class Solution {
    //Global variable to store set
    static Set<Integer> storeNum = new HashSet<>();

    //Determine if prime or not
    public static boolean isPrime(int num) {
        //Edge cases
        if(num==1||num==0) return false;
        if(num==2) return true;
        for(int i=2; i<num; i++) {
            if(num%i == 0) return false;
        }
        return true;
    }

    public static void generateCombination(String curString, String remaining) {
        if(!curString.equals("")) storeNum.add(Integer.valueOf(curString));

        //Continue and generate all possible combinations
        //Append one character from remaining into curString
        for(int i=0; i<remaining.length(); i++) {
            generateCombination(curString + remaining.charAt(i), remaining.substring(0,i) + remaining.substring(i+1));
        }
    }

    public static int solution(String numbers) {
        int answer = 0;

        //Generate all combinations recursively
        generateCombination("", numbers);

        //Iterate all numbers stored in set and determine if prime or not
        for(int i: storeNum) {
            System.out.println(i);
            if(isPrime(i)) answer++;
        }

        return answer;
    }
    public static void main(String strs[]) {
        String inputString = "011";

        System.out.println(solution(inputString));
    }
}