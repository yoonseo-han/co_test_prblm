import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        // Initialize graph, distance array
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        // Build graph
        for (int[] curTime : times) {
            int startNode = curTime[0];
            int endNode = curTime[1];
            int time = curTime[2];
            graph.get(startNode).add(new int[]{endNode, time});
        }

        // Start with initial node
        dist[k] = 0;
        pq.add(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] curPosition = pq.poll();
            int curNode = curPosition[0];
            int curDistance = curPosition[1];

            if (visited[curNode]) continue;
            visited[curNode] = true;

            for (int[] neighbour : graph.get(curNode)) {
                int nextNode = neighbour[0];
                int nextWeight = neighbour[1];

                if (curDistance + nextWeight < dist[nextNode]) {
                    dist[nextNode] = curDistance + nextWeight;
                    pq.add(new int[]{nextNode, dist[nextNode]});
                }
            }
        }

        // Find the maximum distance
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}
