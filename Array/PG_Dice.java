//https://school.programmers.co.kr/learn/courses/30/lessons/258709
import java.util.*;

class Solution {
    static List<Integer> arrA;
    static List<Integer> arrB;
    static int N;
    static int[][] diceCopy;
    static int max = Integer.MIN_VALUE;
    static int[] answer;

    public static void generateDiceCombination(int N, int start, List<Integer> tempArr) {
        if (tempArr.size() == N / 2) {
            int score = generateDiceScore(tempArr);
            if(score > max) {
                max = score;
                for (int i = 0; i < tempArr.size(); i++) {
                    answer[i] = tempArr.get(i);
                }
            }
            return;
        }
        for (int i = start; i <= N; i++) {
            tempArr.add(i);
            generateDiceCombination(N, i + 1, tempArr);
            tempArr.remove(tempArr.size() - 1);
        }
    }

    public static int generateDiceScore(List<Integer> diceList) {
        separateAandB(diceList);

        Collections.sort(arrB);

        int score = 0;

        for(int i = 0; i < arrA.size(); i++) {
            int curA = arrA.get(i);

            int left = 0;
            int right = arrB.size() - 1;
            int index = Integer.MIN_VALUE; // Largest value in B that is smaller than curA

            while(left <= right) {
                int mid = (left + right) / 2;

                if(arrB.get(mid) < curA) {
                    left = mid + 1;
                    index = Math.max(index, mid);
                } else {
                    right = mid - 1;
                }
            }
            if (index != Integer.MIN_VALUE) {
                score += index + 1;
            }
        }
        return score;
    }

    public static void separateAandB(List<Integer> diceList) {
        int[][] diceA = new int[N/2][6];
        int[][] diceB = new int[N/2][6];

        int aInd = 0;
        int bInd = 0;

        for(int i = 1; i <= N; i++) {
            if(diceList.contains(i)) {
                diceA[aInd++] = Arrays.copyOf(diceCopy[i - 1], 6);
            }
            else {
                diceB[bInd++] = Arrays.copyOf(diceCopy[i - 1], 6);
            }
        }

        arrA = new ArrayList<>();
        arrB = new ArrayList<>();

        generateAllSums(0, 0, arrA, diceA);
        generateAllSums(0, 0, arrB, diceB);
    }

    public static void generateAllSums(int depth, int curSum, List<Integer> sumStore, int[][] curDice) {
        if(depth == N / 2) {
            sumStore.add(curSum);
            return;
        }
        for(int i = 0; i < 6; i++) {
            generateAllSums(depth + 1, curSum + curDice[depth][i], sumStore, curDice);
        }
    }

    public static int[] solution(int[][] dice) {
        N = dice.length; 
        diceCopy = new int[N][6];
        answer = new int[N / 2];

        for(int i = 0; i < N; i++) {
            diceCopy[i] = Arrays.copyOf(dice[i], 6);
        }

        generateDiceCombination(N, 1, new ArrayList<>());

        return answer;
    }
    
    public static void main(String strs[]) {
        int [][] dice = {{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}};

        System.out.println(Arrays.toString(solution(dice)));
    }
}