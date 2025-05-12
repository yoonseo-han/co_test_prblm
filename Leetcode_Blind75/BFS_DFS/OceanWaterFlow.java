import java.util.*;

class Solution {
    private int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    private int m, n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0)
            return result;

        m = heights.length;
        n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Top and Bottom edges
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0); // Pacific Left edge
            dfs(heights, atlantic, i, n - 1); // Atlantic Right edge
        }

        // Left and Right edges
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j); // Pacific Top edge
            dfs(heights, atlantic, m - 1, j); // Atlantic Bottom edge
        }

        // Collect cells reachable from both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int row, int col) {
        visited[row][col] = true;

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n)
                continue;
            if (visited[newRow][newCol])
                continue;
            if (heights[newRow][newCol] < heights[row][col])
                continue;

            dfs(heights, visited, newRow, newCol);
        }
    }
}