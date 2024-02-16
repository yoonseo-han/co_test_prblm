package Greedy;

//https://school.programmers.co.kr/learn/courses/30/lessons/42885

import java.util.*;

class Solution {
    public static int solution(int[] people, int limit) {
        int answer = 0;

        //Sort array in ascending order
        Arrays.sort(people);
        
        int start = 0;
        int end = people.length-1;

        while(start <= end) {
            if(people[start] + people[end] <= limit) {
                //Increase start and decrease end, increase count
                start++;
                end--;
            }
            else {
                //Only 1 person in boat: Lighter one gets rescued first
                start++;
            }
            answer++;
        }

        return answer;
    }
    public static void main(String strs[]) {
        int [] people = {1,3,19,55,74,90};
        int limit = 100;
        System.out.println(solution(people, limit));
    }
}