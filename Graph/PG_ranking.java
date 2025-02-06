//https://school.programmers.co.kr/learn/courses/30/lessons/49191?language=java

import java.util.*;

class Solution {
    public static int BFS(int curNode, List<Integer>[] curGraph, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> tempQueue = new LinkedList<>();
        tempQueue.add(curNode);
        visited[curNode] = true;

        int ans = 0;

        while (!tempQueue.isEmpty()) {
            int tempNode = tempQueue.poll();
            for (int child : curGraph[tempNode]) {
                if (!visited[child]) {
                    visited[child] = true;
                    tempQueue.add(child);
                    ans++;
                }
            }
        }

        return ans;
    }

    public static int solution(int n, int[][] results) {
        int answer = 0;
        List<Integer> winStore[] = new ArrayList[n + 1];
        List<Integer> loseStore[] = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            winStore[i] = new ArrayList<>();
            loseStore[i] = new ArrayList<>();
        }

        // Initialize graph
        for (int[] curArr : results) {
            int winPlayer = curArr[0];
            int lostPlayer = curArr[1];

            winStore[winPlayer].add(lostPlayer);
            loseStore[lostPlayer].add(winPlayer);
        }

        for (int i = 1; i <= n; i++) {
            int winCount = BFS(i, winStore, n);
            int lostCount = BFS(i, loseStore, n);

            if (winCount + lostCount == n - 1) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String strs[]) {
        int n = 5;
        int[][] results = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };
        System.out.println(solution(n, results));
    }
}