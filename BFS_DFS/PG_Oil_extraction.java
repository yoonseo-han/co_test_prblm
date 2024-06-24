import java.util.*;

class Solution {
    int [] dX = {1,-1,0,0};
    int [] dY = {0,0,-1,1};
    boolean [][] visited;
    int[] oilStore;
    
    public void getSize(int[][] land, boolean[][] visited, int curX, int curY){
        Queue<int[]> tempStore = new LinkedList<>();
        int size = 0;
        tempStore.add(new int[]{curX, curY});
        visited[curY][curX] = true;

        // 석유 덩어리의 열 위치 저장: HashSet to remove duplicates
        Set<Integer> storeColumn = new HashSet<>();
        
        while(!tempStore.isEmpty()) {
            int [] curInd = tempStore.poll();
            curX = curInd[0];
            curY = curInd[1];
            storeColumn.add(curX);
            
            for(int i=0; i<4; i++) {
                int tempX = curX + dX[i];
                int tempY = curY + dY[i];
                
                if(tempX < 0 || tempY < 0 || tempX >= land[0].length || tempY >= land.length || land[tempY][tempX] == 0 || visited[tempY][tempX] == true) continue;
                
                tempStore.add(new int[]{tempX, tempY});
                visited[tempY][tempX] = true;
            }
            size++;
        }

        for (int index : storeColumn) {
            oilStore[index] += size;
        }
    }
    
    public int solution(int[][] land) {
        int answer = 0;
        int N = land.length;
        int M = land[0].length;
        oilStore = new int[M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (land[i][j] == 1 && visited[i][j] == false) {
                    getSize(land, visited, j, i);
                }
            }
        }

        answer = Arrays.stream(oilStore).max().getAsInt();
        System.out.println(answer);
        return answer;
    }
}