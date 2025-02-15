import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;

    public static void makeGraph(int[][] roads, int n) {
        for (int[] curRoad : roads) {
            graph[curRoad[0]].add(curRoad[1]);
            graph[curRoad[1]].add(curRoad[0]);
        }
    }

    public static int[] dijkstra(int n, int start) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        // Priority queue: {node, distance}
        PriorityQueue<int[]> tempStore = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        tempStore.add(new int[] { start, 0 });

        while (!tempStore.isEmpty()) {
            int[] curNode = tempStore.poll();
            int node = curNode[0];
            int dist = curNode[1];

            for (int neighbor : graph[node]) {
                int newDist = dist + 1;
                if (newDist < distances[neighbor]) {
                    distances[neighbor] = newDist;
                    tempStore.add(new int[] { neighbor, newDist });
                }
            }
        }
        return distances;
    }

    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        makeGraph(roads, n);
        int[] answer = new int[sources.length];
        int[] distances = dijkstra(n, destination);

        for (int i = 0; i < sources.length; i++) {
            answer[i] = distances[sources[i]] == Integer.MAX_VALUE ? -1 : distances[sources[i]];
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