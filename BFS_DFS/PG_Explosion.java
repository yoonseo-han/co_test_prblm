import java.util.*;

public class MinimumInitialNodes {
    public static void main(String[] args) {
        // Example input
        int n = 5;
        int[][] edges1 = { {0,1}, {1, 4}, {4,0}, {2,1}, {3,4} };

        System.out.println(findMinInitialNodes(n, edges1));  // Should output a list of nodes with size 2
        //System.out.println(findMinInitialNodes(n, edges2));  // Should output -1
    }

    public static int findMinInitialNodes(int n, int[][] edges) {
        int[] next = new int[n];
        Arrays.fill(next, -1);
        for (int[] edge : edges) {
            next[edge[0]] = edge[1];
        }

        for (int size = 1; size <= n; size++) {
            List<Integer> combination = new ArrayList<>();
            if (findCombination(next, n, size, 0, combination)) {
                return size;  // Return the size of the smallest valid combination
            }
        }

        return -1;  // No valid combination found
    }

    private static boolean findCombination(int[] next, int n, int size, int start, List<Integer> combination) {
        if (combination.size() == size) {
            return simulatePropagation(next, n, combination);
        }
    
        for (int i = start; i < n; i++) {
            combination.add(i);
            if (findCombination(next, n, size, i + 1, combination)) {
                return true;
            }
            combination.remove(combination.size() - 1); // Remove the last added element
        }
    
        return false;
    }
    

    private static boolean simulatePropagation(int[] next, int n, List<Integer> initialNodes) {
        int[] values = new int[n];
        for (int node : initialNodes) {
            values[node] = 1;
        }

        // Simulate the propagation
        Queue<Integer> queue = new LinkedList<>(initialNodes);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            int neighbor = next[node];
            if (neighbor != -1) {
                values[neighbor] += values[node];
                values[node] = 0;  // Node passes its value to the neighbor

                if (values[neighbor] >= 2) {
                    return true;  // Found a node with value >= 2
                }
                queue.add(neighbor);
            }
        }

        return false;
    }
}
