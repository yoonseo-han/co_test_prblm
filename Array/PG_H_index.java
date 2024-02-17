package Array;

//https://school.programmers.co.kr/learn/courses/30/lessons/42747

import java.util.*;

class Solution {
    public static int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        int n = citations.length;

        for(int  i=0; i<n; i++) {
            int numOfQualified = Math.min(n-i, citations[i]);
            answer = Math.max(answer, numOfQualified);
        }

        return answer;
    }
    public static void main(String strs[]) {
        int [] citations = {3,0,6,1,5};
        System.out.println(solution(citations));
    }
}