import java.util.*;

class Solution {
    int [] dX = {1,-1,0,0};
    int [] dY = {0,0,-1,1};
    boolean [][] visited;
    
    public int getSize(int[][] land, boolean[][] visited, int curX, int curY){
        Queue<int[]> tempStore = new LinkedList<>();
        int size = 0;
        tempStore.add(new int[]{curX, curY});
        visited[curY][curX] = true;
        
        while(!tempStore.isEmpty()) {
            int [] curInd = tempStore.poll();
            curX = curInd[0];
            curY = curInd[1];
            
            for(int i=0; i<4; i++) {
                int tempX = curX + dX[i];
                int tempY = curY + dY[i];
                
                if(tempX < 0 || tempY < 0 || tempX >= land[0].length || tempY >= land.length || land[tempY][tempX] == 0 || visited[tempY][tempX] == true) continue;
                
                tempStore.add(new int[]{tempX, tempY});
                visited[tempY][tempX] = true;
            }
            size++;
        }
        
        return size;
    }
    
    public int solution(int[][] land) {
        int answer = 0;
        int N = land.length;
        int M = land[0].length;
        
        for(int i=0; i<M; i++) {
            visited = new boolean[N][M];
            int curSize = 0;
            for(int j=0; j<N; j++) {
                if(land[j][i] == 0 || visited[j][i] == true) continue;
                curSize += getSize(land, visited, i, j);
            }
            answer = Math.max(answer, curSize);
        }
        
        return answer;
    }
}