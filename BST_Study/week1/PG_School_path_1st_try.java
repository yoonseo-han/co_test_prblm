class Solution {
    public static int solution(int m, int n, int[][] puddles) {
        final int MOD = 1000000007;

        // Get min length of all
        int[][] minLengthDP = new int[n][m];
        for (int i = 0; i < m; i++)
            minLengthDP[0][i] = i;
        for (int i = 0; i < n; i++)
            minLengthDP[i][0] = i;

        for (int[] temp : puddles) {
            minLengthDP[temp[1] - 1][temp[0] - 1] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (minLengthDP[i][j] == Integer.MAX_VALUE)
                    continue;
                minLengthDP[i][j] = Math.min(minLengthDP[i - 1][j], minLengthDP[i][j - 1]) + 1;
            }
        }

        int[][] pathDP = new int[n][m];
        pathDP[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 && j == 0) || (minLengthDP[i][j] == Integer.MAX_VALUE))
                    continue;
                if (i > 0 && minLengthDP[i - 1][j] == minLengthDP[i][j] - 1) {
                    pathDP[i][j] = (pathDP[i][j] + pathDP[i - 1][j]) % MOD;
                }
                if (j > 0 && minLengthDP[i][j - 1] == minLengthDP[i][j] - 1) {
                    pathDP[i][j] = (pathDP[i][j] + pathDP[i][j - 1]) % MOD;
                }
            }
        }

        return pathDP[n - 1][m - 1];
    }

    public static void main(String strs[]) {
        int m = 4;
        int n = 3;
        int[][] puddles = { { 2, 2 } };
        System.out.println(solution(m, n, puddles));
    }
}