class Solution {
    int curMax = 0;

    public void maxNum(int k, int[][] dungeons, boolean[] visited, int curCount) {
        curMax = Math.max(curCount, curMax);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                maxNum(k - dungeons[i][1], dungeons, visited, curCount + 1);
                visited[i] = false; // backtrack
            }
        }
    }

    public int solution(int k, int[][] dungeons) {
        int N = dungeons.length;
        boolean[] visited = new boolean[N];

        // Start the recursion for all possible starting points
        maxNum(k, dungeons, visited, 0);

        return curMax;
    }
}