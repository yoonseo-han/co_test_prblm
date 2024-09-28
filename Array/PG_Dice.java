//https://school.programmers.co.kr/learn/courses/30/lessons/258709

import java.util.*;

class Solution {
    static List<List<Integer>> diceCombinations = new ArrayList<>();

    public static void generateDiceCombination(int N, int start, List<Integer> tempArr) {
        if (tempArr.size() == N / 2) {
            diceCombinations.add(new ArrayList<>(tempArr));
            return;
        }
        for (int i = start; i <= N; i++) {
            tempArr.add(i);
            generateDiceCombination(N, i + 1, tempArr);
            tempArr.remove(tempArr.size() - 1);
        }
    }
    public static int[] solution(int[][] dice) {
        int[] answer = {};
        int N = dice.length; 

        generateDiceCombination(N, 1, new ArrayList<>());
        for(List<Integer> curList: diceCombinations) {
            for(int i: curList) System.out.print(i + ",");
            System.out.println();
        }

        return answer;
    }
    public static void main(String strs[]) {
        int [][] dice = {{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}};
        System.out.println(solution(dice));
    }
}