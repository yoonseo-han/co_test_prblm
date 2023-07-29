package Leetcode_100;

class Solution {
    public static int minPathSum(int[][] grid) {
        //For each move there are 2 possibilities: right or down
        //Able to use 2d dp
        int [][] pathLength = new int[grid.length][grid[0].length];

        //Base case: Edge cases
        pathLength[0][0] = grid[0][0];
        for(int i=1; i<grid[0].length; i++) pathLength[0][i] = grid[0][i] + pathLength[0][i-1];
        for(int i=1; i<grid.length; i++) pathLength[i][0] = grid[i][0] + pathLength[i-1][0];

        //Recursive case: Select min for both cases
        for(int i=1; i<grid.length; i++) {
            for(int j=1; j<grid[0].length; j++) pathLength[i][j] = grid[i][j] + Math.min(pathLength[i-1][j], pathLength[i][j-1]);
        }

        return pathLength[grid.length-1][grid[0].length-1];
    }
    public static void main(String strs[]) {
        int [][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }
}