//https://school.programmers.co.kr/learn/courses/30/lessons/84021

import java.util.*;

class newTableComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] o1, int[] o2) {
        if(o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
        else return Integer.compare(o1[0], o2[0]);
    }
}

class Solution {
    int[] dX = {-1,1,0,0};
    int[] dY = {0,0,-1,1};
    List<List<int[]>> tableParts = new ArrayList<>();
    List<List<int[]>> gameParts = new ArrayList<>();
    
    public void retrieveShape(int x, int y, int[][] table, boolean[][] visited, List<List<int[]>> parts) {
        Queue<int[]> tempStore = new LinkedList<>();
        List<int[]> storePart = new ArrayList<>();
        
        tempStore.add(new int[]{x, y});
        storePart.add(new int[]{0, 0});
        visited[x][y] = true;
        
        while(!tempStore.isEmpty()) {
            int[] curPos = tempStore.poll();
            int curX = curPos[0];
            int curY = curPos[1];
            
            for(int i=0; i<4; i++) {
                int tempX = curX + dX[i];
                int tempY = curY + dY[i];
                if(tempX<0 || tempY<0 || tempX>=table.length || tempY>=table.length) continue;
                
                if(table[tempX][tempY] == 1 && !visited[tempX][tempY]) {
                    visited[tempX][tempY] = true;
                    tempStore.add(new int[]{tempX, tempY});
                    storePart.add(new int[]{tempX - x, tempY - y});
                }
            }
        }
        parts.add(storePart);
    }
    
    public boolean findMatchByRotate(List<int[]> gameParts, List<int[]> tableParts) {
        Collections.sort(gameParts, new newTableComparator());
        
        for(int i=0; i<4; i++) {
            Collections.sort(tableParts, new newTableComparator());
            
            // Normalize the coordinates to make sure the first element is at (0, 0)
            int offsetX = tableParts.get(0)[0];
            int offsetY = tableParts.get(0)[1];
            for(int[] coord : tableParts) {
                coord[0] -= offsetX;
                coord[1] -= offsetY;
            }
            
            boolean flag = true;
            for(int j=0; j<gameParts.size(); j++){
                if(gameParts.get(j)[0] != tableParts.get(j)[0] || gameParts.get(j)[1] != tableParts.get(j)[1]) {
                    flag = false;
                    break;
                }
            }
            if(flag) return true;
            
            // Rotate 90 degrees
            for(int[] coord : tableParts) {
                int temp = coord[0];
                coord[0] = coord[1];
                coord[1] = -temp;
            }
        }
        
        return false;
    }
    
    public int matchParts(List<List<int[]>> tableParts, List<List<int[]>> gameParts, int answer) {
        boolean[] visited = new boolean[gameParts.size()];
        
        for(List<int[]> tablePart : tableParts) {
            for(int j=0; j<gameParts.size(); j++) {
                if(!visited[j] && gameParts.get(j).size() == tablePart.size() && findMatchByRotate(gameParts.get(j), tablePart)) {
                    visited[j] = true;
                    answer += gameParts.get(j).size();
                    break;
                }
            }
        }
        
        return answer;
    }
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        int N = table.length;
        
        boolean[][] visited_t = new boolean[N][N];
        boolean[][] visited_g = new boolean[N][N];
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                game_board[i][j] = Math.abs(game_board[i][j] - 1);
            }
        }
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(table[i][j] == 1 && !visited_t[i][j]) {
                    retrieveShape(i, j, table, visited_t, tableParts);
                }
                if(game_board[i][j] == 1 && !visited_g[i][j]) {
                    retrieveShape(i, j, game_board, visited_g, gameParts);
                }
            }
        }
        
        answer = matchParts(tableParts, gameParts, answer);
        
        return answer;
    }
}
