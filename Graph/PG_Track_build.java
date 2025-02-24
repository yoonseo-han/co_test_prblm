import java.util.*;

class Solution {
    // left(0), right(1), up(2), down(3)
    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };
    int[][][] dist;

    public boolean isNeighbour(int curDir, int newDir) {
        if (curDir + newDir == 1 || curDir + newDir == 5)
            return true;
        return false;
    }

    public int solution(int[][] board) {
        int n = board.length;
        dist = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++)
                    dist[i][j][k] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Node> tempStore = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        tempStore.add(new Node(0, 0, 0, 1));
        tempStore.add(new Node(0, 0, 0, 3));

        while (!tempStore.isEmpty()) {
            Node curNode = tempStore.poll();

            // iterate around direct neighbour
            for (int i = 0; i < 4; i++) {
                if (isNeighbour(i, curNode.dir))
                    continue;

                // New position
                int nx = curNode.x + dx[i];
                int ny = curNode.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1)
                    continue;

                int newCost = curNode.cost + 100;
                if (curNode.dir != i) {
                    newCost += 500;
                }

                // Update cost only if smaller
                if (dist[nx][ny][i] > newCost) {
                    dist[nx][ny][i] = newCost;
                    tempStore.add(new Node(nx, ny, newCost, i));
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            if (dist[n - 1][n - 1][i] != Integer.MAX_VALUE) {
                answer = Math.min(answer, dist[n - 1][n - 1][i]);
            }
        }

        return answer;
    }
}

class Node {
    int x;
    int y;
    int cost;
    int dir;

    Node(int x, int y, int cost, int dir) {
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.dir = dir;
    }
}