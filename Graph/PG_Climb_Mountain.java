import java.util.*;

class Solution {
    public int[] dijkstra(List<List<Node>> graph, int[] gates, int[] summits, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.weight == b.weight) {
                return a.val - b.val; // If intensity is the same, choose smaller node value
            }
            return a.weight - b.weight; // Otherwise, choose smaller intensity
        });

        // HashSet to check if a node is a summit
        Set<Integer> isSummit = new HashSet<>();
        for (int i : summits) {
            isSummit.add(i);
        }

        // Store all the gates first with intensity set as 0
        int[] minIntensity = new int[n + 1];
        Arrays.fill(minIntensity, Integer.MAX_VALUE); // Initialize all nodes with maximum intensity
        for (int gate : gates) {
            pq.add(new Node(gate, 0));
            minIntensity[gate] = 0; // Intensity to reach a gate is 0
        }

        // Best value trackers: FINAL answer
        int bestSummit = -1;
        int bestIntensity = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            // Get the smallest intensity node
            Node curNode = pq.poll();

            // Skip if this path is not optimal
            if (curNode.weight > minIntensity[curNode.val]) {
                continue;
            }

            // If the current node is a summit
            if (isSummit.contains(curNode.val)) {
                // Check if update is needed for best value
                if (minIntensity[curNode.val] < bestIntensity
                        || (minIntensity[curNode.val] == bestIntensity && curNode.val < bestSummit)) {
                    bestSummit = curNode.val;
                    bestIntensity = minIntensity[curNode.val];
                }
                continue; // No need to process neighbors of a summit
            }

            // Process neighbors
            for (Node neighbor : graph.get(curNode.val)) {
                int nextNode = neighbor.val;
                int edgeWeight = neighbor.weight;

                int newIntensity = Math.max(curNode.weight, edgeWeight); // Update intensity
                if (newIntensity < minIntensity[nextNode]) {
                    // Update intensity to reach the neighbor
                    minIntensity[nextNode] = newIntensity;
                    pq.add(new Node(nextNode, newIntensity));
                }
            }
        }

        return new int[] { bestSummit, bestIntensity };
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        // Build the graph as an adjacency list
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            int start = path[0];
            int end = path[1];
            int weight = path[2];

            graph.get(start).add(new Node(end, weight));
            graph.get(end).add(new Node(start, weight));
        }

        return dijkstra(graph, gates, summits, n);
    }
}

class Node {
    int val;
    int weight;

    Node(int val, int weight) {
        this.val = val;
        this.weight = weight;
    }
}