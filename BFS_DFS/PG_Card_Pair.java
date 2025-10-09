import java.util.*;

class Node {
    int r;   // row (y)
    int c;   // col (x)
    int cnt;

    Node(int r, int c, int cnt) {
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }
}

class Solution {
    // 방향: 위, 아래, 왼쪽, 오른쪽 (row, col)
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    int width;   // columns
    int height;  // rows

    int minCnt;

    Map<Integer, List<int[]>> storePoints;
    List<Integer> keyList;
    List<List<Integer>> keyPermutation;

    // move with Ctrl: move in direction until hit a card or boundary.
    // coordinates use (row, col).
    public int[] moveWithCtrl(int[][] board, int curR, int curC, int dR, int dC) {
        int nR = curR;
        int nC = curC;

        while (true) {
            int nextR = nR + dR;
            int nextC = nC + dC;

            // if next would leave board -> stop at current
            if (nextR < 0 || nextR >= height || nextC < 0 || nextC >= width) {
                return new int[]{nR, nC};
            }

            // if there's a card at next -> stop there
            if (board[nextR][nextC] != 0) {
                return new int[]{nextR, nextC};
            }

            // otherwise step forward and continue
            nR = nextR;
            nC = nextC;
        }
    }

    public boolean isInRange(int r, int c) {
        return !(r < 0 || r >= height || c < 0 || c >= width);
    }

    // BFS: returns minimum button clicks from (startR,startC) to (targetR,targetC)
    public int bfs(int[][] board, int startR, int startC, int targetR, int targetC) {
        if (startR == targetR && startC == targetC) return 0;

        boolean[][] visited = new boolean[height][width];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startR, startC, 0));
        visited[startR][startC] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                // 1) one step
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (isInRange(nr, nc) && !visited[nr][nc]) {
                    if (nr == targetR && nc == targetC) return cur.cnt + 1;
                    visited[nr][nc] = true;
                    q.offer(new Node(nr, nc, cur.cnt + 1));
                }

                // 2) ctrl + direction
                int[] ctrl = moveWithCtrl(board, cur.r, cur.c, dr[i], dc[i]);
                int cr = ctrl[0];
                int cc = ctrl[1];
                if (!visited[cr][cc]) {
                    if (cr == targetR && cc == targetC) return cur.cnt + 1;
                    visited[cr][cc] = true;
                    q.offer(new Node(cr, cc, cur.cnt + 1));
                }
            }
        }

        return Integer.MAX_VALUE; // unreachable (shouldn't happen in valid boards)
    }

    // DFS: try all orders in storeOrder (which contains actual card numbers)
    public void dfs(int idx, List<Integer> storeOrder, int[][] board, int curR, int curC, int curCnt) {
        // pruning: if current count already >= best found, stop
        if (curCnt >= minCnt) return;

        if (idx == storeOrder.size()) {
            minCnt = Math.min(curCnt, minCnt);
            return;
        }

        int targetID = storeOrder.get(idx);
        List<int[]> pts = storePoints.get(targetID);
        int[] p1 = pts.get(0); // stored as {row, col}
        int[] p2 = pts.get(1);

        // Case 1: go p1 -> p2
        int dist1 = bfs(board, curR, curC, p1[0], p1[1]);
        int dist1b = bfs(board, p1[0], p1[1], p2[0], p2[1]);
        int total1 = dist1 + dist1b + 2; // +2 for two Enter presses

        // remove cards
        board[p1[0]][p1[1]] = 0;
        board[p2[0]][p2[1]] = 0;
        dfs(idx + 1, storeOrder, board, p2[0], p2[1], curCnt + total1);
        // restore
        board[p1[0]][p1[1]] = targetID;
        board[p2[0]][p2[1]] = targetID;

        // Case 2: go p2 -> p1
        int dist2 = bfs(board, curR, curC, p2[0], p2[1]);
        int dist2b = bfs(board, p2[0], p2[1], p1[0], p1[1]);
        int total2 = dist2 + dist2b + 2;

        board[p1[0]][p1[1]] = 0;
        board[p2[0]][p2[1]] = 0;
        dfs(idx + 1, storeOrder, board, p1[0], p1[1], curCnt + total2);
        board[p1[0]][p1[1]] = targetID;
        board[p2[0]][p2[1]] = targetID;
    }

    // generate permutations of actual key values (not indices)
    public void generatePermutation(List<Integer> curList, boolean[] used) {
        if (curList.size() == keyList.size()) {
            keyPermutation.add(new ArrayList<>(curList));
            return;
        }

        for (int i = 0; i < keyList.size(); i++) {
            if (used[i]) continue;
            used[i] = true;
            curList.add(keyList.get(i)); // add actual card number
            generatePermutation(curList, used);
            curList.remove(curList.size() - 1);
            used[i] = false;
        }
    }

    public int solution(int[][] board, int r, int c) {
        // assign width/height to class fields
        this.height = board.length;
        this.width = board[0].length;

        minCnt = Integer.MAX_VALUE;

        storePoints = new HashMap<>();
        keyList = new ArrayList<>();
        keyPermutation = new ArrayList<>();

        // collect card positions. store as {row, col}
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] != 0) {
                    storePoints.computeIfAbsent(board[i][j], k -> new ArrayList<>()).add(new int[]{i, j});
                }
            }
        }

        if (storePoints.isEmpty()) return 0; // no cards

        keyList = new ArrayList<>(storePoints.keySet());
        // generate permutations of keyList values
        boolean[] used = new boolean[keyList.size()];
        generatePermutation(new ArrayList<>(), used);

        // for each permutation, run dfs
        for (List<Integer> order : keyPermutation) {
            // clone board? not necessary because dfs restores, but to be safe we can pass the original
            dfs(0, order, board, r, c, 0);
        }

        return minCnt;
    }
}
