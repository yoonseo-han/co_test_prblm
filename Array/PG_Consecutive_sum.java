//https://school.programmers.co.kr/learn/courses/30/lessons/178870
import java.util.*;

class Solution {
    public static int[] solution(int[] sequence, int k) {
        int[] answer = {-1, -1}; // Initializing with -1 to signify no answer has been found yet
        int curSum = 0;
        int leftPointer = 0;
        int rightPointer = 0;

        while (rightPointer < sequence.length) {
            curSum += sequence[rightPointer];

            while (curSum > k && leftPointer <= rightPointer) {
                curSum -= sequence[leftPointer++];
            }

            if (curSum == k) {
                if (answer[0] == -1 || (rightPointer - leftPointer < answer[1] - answer[0])) {
                    answer[0] = leftPointer;
                    answer[1] = rightPointer;
                }
            }

            rightPointer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] sequence = {1, 1, 1, 2, 3, 4, 5};
        int k = 5;
        int[] answer = solution(sequence, k);
        for (int i : answer) System.out.println(i);
    }
}