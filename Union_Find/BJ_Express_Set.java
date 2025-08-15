import java.util.*;
import java.io.*;

class Solution {
    public int find(int curNode, int[] parent) {
        if (parent[curNode] == curNode) {
            return curNode;
        } else {
            parent[curNode] = find(parent[curNode], parent); // Path compression for faster return (optional -> Better
                                                             // performance)
            return parent[curNode];
        }
    }

    public void union(int a, int b, int[] parent, int[] rank) {
        // Merge the two different subsets

        // Find the parent nodes of each
        int aParent = find(a, parent);
        int bParent = find(b, parent);

        if (aParent == bParent) {
            // Already same subset
            return;
        }

        // Get rank of both arrays and merge based on rank
        if (rank[aParent] < rank[bParent]) {
            parent[aParent] = bParent;
        } else if (rank[aParent] > rank[bParent]) {
            parent[bParent] = aParent;
        } else {
            parent[bParent] = aParent;
            rank[aParent]++;
        }
    }

    public static void main(String strs[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] parentStore = new int[n + 1];
        int[] rankStore = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            parentStore[i] = i;
            rankStore[i] = 0;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());

            int operation = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (operation == 0) {
                union(a, b, parent, rank);
            } else {
                if (find(a, parent) == find(b, parent)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }
        System.out.print(sb.toString());
    }
}