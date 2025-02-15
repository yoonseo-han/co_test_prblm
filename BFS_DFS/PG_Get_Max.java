public class PG_Get_Max {
    public void dfs(int x, int y, int[][][] arr, int depth, int curTip, boolean[][] visited) {
        if (depth > globalMax) {
            return;
        }

        boolean addOrNot = (!visited[x][y]) && (arr[x][y][1] >= depth);
        int tempTip = curTip + ((addOrNot) ? arr[x][y][0] : 0); // Fix precedence issue

        visited[x][y] = true; // Mark as visited
        answer = Math.max(answer, tempTip); // 매 방문마다 answer 갱신

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < R && ny >= 0 && ny < R) {
                dfs(nx, ny, arr, depth + 1, tempTip, visited);
            }
        }

        visited[x][y] = false; // Unmark for backtracking
    }
}
