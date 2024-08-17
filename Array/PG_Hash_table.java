//https://school.programmers.co.kr/learn/courses/30/lessons/147354
import java.util.*;

class Solution {
    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, new Comparator<int []>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[col-1] == b[col-1]) {
                    return Integer.compare(b[0], a[0]); // Sorting in descending order by the first column when the values in col are the same
                } else {
                    return Integer.compare(a[col-1], b[col-1]); // Sorting in ascending order by the col-th column
                }
            }
        });

        for(int i = row_begin-1; i<row_end; i++) {
            int sum = 0;
            for (int value : data[i]) {
                sum += value % (i + 1);
            }
            answer ^= sum;  // XOR operation to compute the final answer
        }

        return answer;
    }
    public static void main(String strs[]) {
        int [][] data = {{2,2,6}, {1,5,10}, {4,2,9}, {3,8,3}};
        System.out.println(solution(data, 2, 2, 3));
    }
}