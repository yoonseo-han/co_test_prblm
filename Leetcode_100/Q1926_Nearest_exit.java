package Leetcode_100;

import java.util.*;

class Solution {
    public static int nearestExit(char[][] maze, int[] entrance) {
        //Loop till reach end
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        int step = 0;

        int row = maze.length;
        int col = maze[0].length;

        //BFS implement: add the possible path to queue
        Queue<int[]> tempStore = new LinkedList<>();

        boolean[][] visited = new boolean[row][col];

        int [] curPos;

        tempStore.add(entrance);
        visited[entrance[0]][entrance[1]] = true;

        while(!tempStore.isEmpty()){
            step++; 
            int queueSize = tempStore.size();
            for(int i=0; i<queueSize; i++) {
                curPos = tempStore.poll();

                for(int j = 0; j<4; j++) {
                    int x = curPos[0] + dir[j][0];
                    int y = curPos[1] + dir[j][1];

                    //Check validity
                    // check for all conditions
                    if(x>=0 && x<row && y >=0 && y<col && visited[x][y] == false && maze[x][y] == '.')
                    {
                        tempStore.add(new int[]{x,y});
                        visited[x][y] = true;
                        
                        // if the control is on the boundary just return.
                        if(x == 0 || y == 0 || x ==row-1 || y== col-1) return step;
                    }
                }
            }
        }   

        //No solution
        return -1;
    }
    public static void main(String strs[]) {
        char [][] maze = {{'+','+','.','+'},{'.','.','.','+'},{'+','+','.','+'}};
        int [] entrance = {1,2};
        System.out.println(nearestExit(maze, entrance));
    }
}