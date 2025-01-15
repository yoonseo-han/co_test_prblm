class Solution {
    public static int solution(int m, int n, int[][] puddles) {
        final int MOD = 1000000007;

        int[][] dp = new int[n][m];
        for (int[] temp : puddles) {
            dp[temp[1] - 1][temp[0] - 1] = -1;
        }
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 && j == 0) || (dp[i][j] == -1))
                    continue;

                if (i > 0 && dp[i - 1][j] != -1)
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                if (j > 0 && dp[i][j - 1] != -1)
                    dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
            }
        }

        return dp[n - 1][m - 1];
    }

    public static void main(String strs[]) {
        int m = 4;
        int n = 3;
        int[][] puddles = { { 2, 2 } };
        System.out.println(solution(m, n, puddles));
    }
}