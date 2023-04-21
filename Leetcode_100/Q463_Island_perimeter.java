package Leetcode_100;

class Solution {
    public static int getPerimeter(int [][] grid, int i, int j) {
        //Out of range: Reach end
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return 1;
        //Reach the end of followig direction: Add 1
        if (grid[i][j] == 0) return 1;
        //Already visited: return 0
        if (grid[i][j] == -1) return 0;

        int count = 0;
        grid[i][j] = -1;
        
        count += getPerimeter(grid, i-1, j);
        count += getPerimeter(grid, i, j-1);
        count += getPerimeter(grid, i, j+1);
        count += getPerimeter(grid, i+1, j);
        
        return count;
    }

    public static int islandPerimeter(int[][] grid) {
        if (grid == null) return 0;
        for (int i = 0 ; i < grid.length ; i++){
            for (int j = 0 ; j < grid[0].length ; j++){
                if (grid[i][j] == 1) {
                    return getPerimeter(grid,i,j);
                }
            }
        }
        return 0;
    }
    public static void main(String strs[]) {
        int [][] grid = {{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}};
        System.out.println(islandPerimeter(grid));
    }
}