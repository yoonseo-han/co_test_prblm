import java.util.*;

class Solution {
    public static int solution(int n, int[][] solution) {
        int answer = 0;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Set up undirected graph
        for (int[] curArr : solution) {
            graph.get(curArr[0]).add(curArr[1]);
            graph.get(curArr[1]).add(curArr[0]);
        }

        // Distance store array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        // Priority queue to always select nieghbours having smallest distance form
        // current node: [neighbour ID, distance]
        PriorityQueue<int[]> storeQueue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        storeQueue.add(new int[] { 1, 0 });

        while (!storeQueue.isEmpty()) {
            int[] curArr = storeQueue.poll();
            int curNode = curArr[0];
            int curDist = curArr[1];

            for (int neighbour : graph.get(curNode)) {
                // Update if current distance is larger than neighborDist + 1
                if (dist[neighbour] > curDist + 1) {
                    dist[neighbour] = curDist + 1;
                    storeQueue.add(new int[] { neighbour, dist[neighbour] });
                }
            }
        }

        // Find max length
        int maxLength = 0;
        for (int i = 0; i <= n; i++) {
            maxLength = Math.max(maxLength, dist[i]);
        }

        // Get largest distance value nodes
        for (int i = 1; i <= n; i++) {
            answer += (dist[i] == maxLength) ? 1 : 0;
        }

        return answer;
    }

    public static void main(String strs[]) {
        int[][] vertex = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };
        int n = 6;

        System.out.println(solution(n, vertex));
    }
}