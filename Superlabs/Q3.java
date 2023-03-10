package Superlabs;

import java.lang.*;

class Solution {
    public static int calculateMaxPow(int n) {
        for(int i=0; i<n; i++) {
            if(n>= Math.pow(5, i) && n<Math.pow(5, i+1)) return i;
        }
        return 0;
    }

    public static int solution(int n) {
        int answer = 0;
        int maxPow = calculateMaxPow(n);
        //System.out.println(maxPow);
        for(int i= maxPow; i>0; i--) {
            int add = (int) Math.pow(5, i);
            int addToAnswer = n/add;
            // for(int j = add; j<=n; j=j+add) answer++;
            answer += addToAnswer;
        }

        return answer;
    }
    public static void main(String strs[]) {
        int inputNum = 25;
        System.out.println(solution(inputNum));
    }
}