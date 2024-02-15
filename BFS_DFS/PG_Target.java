//https://school.programmers.co.kr/learn/courses/30/lessons/43165

package BFS;

class Solution {
    public static int recursiveSolution(int[] numbers, int target, int iterator, int tempNum) {
        if(iterator == numbers.length) {
            if(tempNum==target) return 1;
            else return 0;
        }
        return recursiveSolution(numbers, target, iterator+1, tempNum-numbers[iterator]) + recursiveSolution(numbers, target, iterator+1, tempNum+numbers[iterator]);
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;

        answer = recursiveSolution(numbers, target, 0, 0);

        return answer;
    }

    public static void main(String strs[]) {
        int[] inputArray = {4, 1, 2, 1};
        int targetNum = 4;
        System.out.println(solution(inputArray, targetNum));
    }
}