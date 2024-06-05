//https://school.programmers.co.kr/learn/courses/30/lessons/1844

import java.util.*;

class Solution {
    public static int[] dx = {0, -1, 1, 0};
    public static int[] dy = {1, 0, 0, -1};
    
    public static int solution(int[][] map) {
        int M = map.length;
        int N = map[0].length;

        Queue<int[]> tempStore = new LinkedList<int[]>();
        boolean[][] visited = new boolean[M][N];
        
        tempStore.add(new int[]{0, 0});
        map[0][0] = 1; // Start point
        
        while (!tempStore.isEmpty()) {
            int[] curPos = tempStore.poll();
            int curX = curPos[1];
            int curY = curPos[0];
            
            for (int i = 0; i < 4; i++) {
                int newX = curX + dx[i];
                int newY = curY + dy[i];
                
                if (newX < 0 || newY < 0 || newX >= N || newY >= M || map[newY][newX] == 0 || visited[newY][newX]) 
                    continue;
                
                tempStore.add(new int[]{newY, newX});
                visited[newY][newX] = true;
                
                if (map[newY][newX] == 1) {
                    map[newY][newX] = map[curY][curX] + 1;
                } else {
                    map[newY][newX] = Math.min(map[newY][newX], map[curY][curX] + 1);
                }
            }
        }

        return map[M-1][N-1] == 1 ? -1 : map[M-1][N-1]; // Return -1 if no path found
    }
}
