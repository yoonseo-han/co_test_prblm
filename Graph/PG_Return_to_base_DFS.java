import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    static int minLength;

    public static void makeGraph(int[][] roads, int n) {
        for (int[] curRoad : roads) {
            graph[curRoad[0]].add(curRoad[1]);
            graph[curRoad[1]].add(curRoad[0]);
        }
    }

    public static void dfs(int curPosition, int destination, boolean[] visited, int curLength) {
        // Early-return when already pass length
        if (minLength <= curLength)
            return;

        if (curPosition == destination) {
            minLength = Math.min(minLength, curLength);
            return;
        }

        for (int neighbor : graph[curPosition]) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                dfs(neighbor, destination, visited, curLength + 1);
                visited[neighbor] = false;
            }
        }
    }

    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        makeGraph(roads, n);
        int[] answer = new int[sources.length];

        for (int i = 0; i < sources.length; i++) {
            minLength = Integer.MAX_VALUE;
            boolean[] visited = new boolean[n + 1];
            visited[sources[i]] = true;
            dfs(sources[i], destination, visited, 0);
            answer[i] = minLength == Integer.MAX_VALUE ? -1 : minLength;
        }

        return answer;
    }

    public static void main(String strs[]) {
        int n = 5;
        int[][] roads = { { 1, 2 }, { 1, 4 }, { 2, 4 }, { 2, 5 }, { 4, 5 } };
        int[] sources = { 1, 3, 5 };
        int destination = 5;
        for (int i : solution(n, roads, sources, destination)) {
            System.out.println(i);
        }
    }
}