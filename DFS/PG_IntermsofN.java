package DFS;

import java.util.*;

class Solution {
    static int min = Integer.MAX_VALUE;

    public static void dfs(int depth, int N, int number, int tempNum) {
        if(depth>8) return;

        if(number == tempNum) {
            min = Math.min(depth, min);
            return;
        }

        int temp = 0;
            
        for (int i = 0; i < 8; i++) {
            if (depth + i < 8) {
                temp = temp * 10 + N;
                dfs(depth + i + 1, N, number, tempNum + temp);
                dfs(depth + i + 1, N, number, tempNum - temp);
                dfs(depth + i + 1, N, number, tempNum / temp);
                dfs(depth + i + 1, N, number, tempNum * temp);     
            }      
        }
    }

    public static int solution(int N, int number) {
        dfs(0, N, number, 0);
        
        if (min == Integer.MAX_VALUE) return -1;
        return min;
    }

    public static void main(String strs[]) {
        int N = 5;
        int number=12;
        System.out.println(solution(N, number));
    }
}