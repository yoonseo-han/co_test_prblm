package BFS;

import java.util.*;

class Solution {
    public static int[] dx = {0,-1,1,0};
    public static int[] dy = {1,0,0,-1};
    public static int solution(int[][] maps) {
        int answer = 0;

        int[][] visited = new int[maps.length][maps[0].length];
        Queue<int[]> store = new LinkedList<>();

        //Initialize variables
        visited[0][0] = 1;
        store.add(new int[]{0,0});

        while(!store.isEmpty()) {
            int[] temp = store.remove();
            int x = temp[0];
            int y = temp[1];

            //Traverfse all 4 directions
            for(int i=0; i<4; i++) {
                int nX = x+dx[i];
                int nY = y+dy[i];

                if(nX <0 || nY < 0 || nX > maps.length-1 || nY>maps[0].length-1) continue;

                if(visited[nX][nY]==0 && maps[nX][nY] ==1) {
                    visited[nX][nY] += visited[x][y] + 1;
                    store.add(new int[]{nX, nY});
                }
            }
        }
        answer = (visited[maps.length-1][maps[0].length-1] !=0)? visited[maps.length-1][maps[0].length-1]:-1;

        return answer;
    }

    public static void main(String strs[]) {
        int [][] maps = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}};
        System.out.println(solution(maps));
    }
}