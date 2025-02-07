class Solution {
    public static int N, M, K;
    static int[] dx = { 1, 0, 0, -1 };
    static int[] dy = { 0, -1, 1, 0 };
    static String[] dir = { "d", "l", "r", "u" };
    static boolean globalFlag = false;
    static String result = "impossible";

    public static int getMinDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static void backtrack(int x, int y, StringBuilder curPath, int length, int endX, int endY) {
        int remainingDist = getMinDist(x, y, endX, endY);
        if (length + remainingDist > K)
            return;

        if (length == K) {
            if (x == endX && y == endY) {
                result = curPath.toString();
                globalFlag = true;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];

            if (nX >= 1 && nX <= N && nY >= 1 && nY <= M) {
                curPath.append(dir[i]);
                backtrack(nX, nY, curPath, length + 1, endX, endY);
                if (!result.equals("impossible"))
                    return;
                curPath.deleteCharAt(curPath.length() - 1);
            }
        }
    }

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        K = k;

        int minDist = getMinDist(x, y, r, c);
        if (k < minDist || (k - minDist) % 2 != 0)
            return "impossible";

        backtrack(x, y, new StringBuilder(), 0, r, c);

        return result;
    }

    public static void main(String strs[]) {
        int n = 3;
        int m = 4;
        int x = 2;
        int y = 3;
        int r = 3;
        int c = 1;
        int k = 5;
        System.out.println(solution(n, m, x, y, r, c, k));
    }
}