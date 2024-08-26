//https://school.programmers.co.kr/learn/courses/30/lessons/43165

class Solution {
    public static int recursiveSolution(int[] numbers, int target, int iterator, int tempNum) {
        if(iterator == numbers.length ) {
            if(tempNum == target) return 1;
            else return 0;
        }
        int leftCurNum = tempNum + numbers[iterator];
        // recursiveSolution(numbers, target, iterator++, newCurNum);
        int rightCurNum = tempNum - numbers[iterator];
        // recursiveSolution(numbers, target, iterator++, newCurNum);

        return recursiveSolution(numbers, target, iterator+1, leftCurNum) + recursiveSolution(numbers, target, iterator+1, rightCurNum);
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;

        answer = recursiveSolution(numbers, target, 0, 0);

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }
}