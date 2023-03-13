package Leetcode_100;

class Solution {
    public static boolean [][] visited;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};

    public static void dfs(char[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || visited[i][j] == true || grid[i][j] == '0') return;
        else {
            visited[i][j] = true;
            for(int k=0; k<4; k++) {
                int di = i+dx[k];
                int dj = j+dy[k];
                dfs(grid, di, dj);
            }
        }
    }
    
    public static int numIslands(char[][] grid) {
        int count = 0;
        visited = new boolean[grid.length][grid[0].length];

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(visited[i][j] == false && grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }
    public static void main(String strs[]) {
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(numIslands(grid));
    }
}