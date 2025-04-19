import java.tuil.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    // DFS Method
    public static boolean isReachable(List<List<Integer>> relationGraph, int curPos, int target, boolean[] visited) {
        if (curPos == target)
            return true;

        visited[curPos] = true;
        for (int next : relationGraph.get(curPos)) {
            if (!visited[next]) {
                if (isReachable(relationGraph, next, target, visited))
                    return true;
            }
        }
        return false;
    }

    // BFS Method
    public static boolean isReachable(List<List<Integer>> relationGraph, int curPos, int target, int N) {
        boolean[] visited = new boolean[N + 1];
        Queue<E> tempStore = new LinkedList<>();
        tempStore.add(curPos);

        while (!tempStore.isEmpty()) {
            int curPos = tempStore.poll();

            if (curPos == target)
                return true;

            for (int next : relationGraph.get(curPos)) {
                if (!visited[next]) {
                    visited[next] = true;
                    tempStore.add(next);
                }
            }
        }
        return true;
    }

    public static findMinimumInfoToRelate1ToN(int N, List<int[]> relations) {
        List<List<Integer>> relationGraph = new ArrayList<>();

        for(int i = 0; i<=N; i++) {
            relationGraph.add(new ArrayList<>());
        }

        for(int i = 0; i < relations.size(); i++) {
            int[] curRelation = relations.get(i);
            relationGraph.get(curRelation[0]).add(curRelation[1]);
            boolean[] visited = new boolean[N+1];
            if(isReachable(relationGraph, 1, N, visited)) {
                System.out.println(i);
            }
        }

        return -1;
    }

    public static void main(String strs[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // number of cards
        int M = sc.nextInt(); // number of relations

        List<int[]> relations = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            relations.add(new int[] { from, to });
        }

        System.out.println(findMinimumInfoToRelate1ToN(N, relations));
    }
}