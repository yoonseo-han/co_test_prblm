//https://school.programmers.co.kr/learn/courses/30/lessons/181188
import java.util.*;

class Solution {
    public static int solution(int[][] targets) {
        int answer = 0;

        // Sort the targets by their end time (second element of each pair)
        Arrays.sort(targets, (a1, a2) -> a1[1] - a2[1]);
        // for(int i = 0; i<targets.length; i++) {
        //     System.out.println(targets[i][0]+","+targets[i][1]);
        // }

        int lastEndTime = Integer.MIN_VALUE;

        for (int[] target : targets) {
            int start = target[0];
            int end = target[1];

            // If the start of the current target is after the last selected end time,
            // it means we need a new range.
            if (start >= lastEndTime) {
                answer++;
                lastEndTime = end;  // Update the last end time to the current end time
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int [][] targets = {{4,5}, {4,8}, {10,14}, {11,13}, {5,12}, {3,7}, {1,4}};
        System.out.println(solution(targets));  
    }
}
