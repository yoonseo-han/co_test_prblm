import java.util.*;

class Solution {
    public static int[] solution(int N, int k, int[][] questions) {
        Arrays.sort(questions, (a, b) -> b[0] - a[0]);

        int[] minValue = new int[k];
        int[] maxValue = new int[k];

        for (int i = 0; i < k; i++) {
            minValue[i] = 1;
            maxValue[i] = N;
        }

        for (int[] q : questions) {
            int value = q[0], count = q[1];

            if (count == 0) {
                // count가 0이면 모든 자리가 value 미만이어야 함
                for (int i = 0; i < k; i++) {
                    maxValue[i] = Math.min(maxValue[i], value - 1);
                }
            } else {
                // 뒤에서부터 count개는 value 이상이어야 함
                for (int i = k - 1; i >= 0; i--) {
                    if (k - i <= count) {
                        // count 범위 안에 있음 -> 최소값 갱신
                        minValue[i] = Math.max(minValue[i], value);
                    } else {
                        // count 범위 밖 -> 최대값 제한
                        maxValue[i] = Math.min(maxValue[i], value - 1);
                    }
                }
            }
        }
        // 앞에서 뒤로 가면서 최솟값 조정
        for (int i = 1; i < k; i++) {
            minValue[i] = Math.max(minValue[i], minValue[i - 1] + 1);
        }

        // 뒤에서 앞으로 가면서 최대값 조정
        for (int i = k - 2; i >= 0; i--) {
            maxValue[i] = Math.min(maxValue[i], maxValue[i + 1] - 1);
        }

        // 각 자리에서 가능한 숫자의 개수 계산
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            System.out.println("MIN: " + minValue[i] + ", MAX: " + maxValue[i]);
            result[i] = maxValue[i] - minValue[i] + 1;
        }

        return result;
    }

    public static void main(String strs[]) {
        int N = 15;
        int k = 4;
        int[][] questions = { { 5, 2 }, { 11, 0 } };
        for (int i : solution(N, k, questions)) {
            System.out.println(i);
        }
    }
}