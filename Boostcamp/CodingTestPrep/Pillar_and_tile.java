import java.util.*;

class Solution {
    public boolean isValid(int[][] map, int n) {
        for(int x = 0; x <= n; x++) {
            for(int y = 0; y <= n; y++) {
                if (map[y][x] == 1) { // Check 기둥
                    if (!(y == 0 || (map[y-1][x] == 1) || (x > 0 && map[y][x-1] == 2) || map[y][x] == 2)) {
                        return false;
                    }
                } else if (map[y][x] == 2) { // Check 보
                    if (!((x > 0 && map[y][x-1] == 2 && x<n && map[y][x+1] == 2) || (map[y-1][x] == 1) || (map[y-1][x+1] == 1))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int[][] solution(int n, int[][] build_frame) {
        int[][] tempArray = new int[n+1][n+1];
        ArrayList<int[]> answer = new ArrayList<>();
        
        for (int[] curArray : build_frame) {
            // Get x,y position of current
            int curX = curArray[0];
            int curY = curArray[1];
            int typeAdd = curArray[2];
            // When add
            if (curArray[3] == 1) {
                tempArray[curY][curX] = typeAdd + 1;
                if (!isValid(tempArray, n)) {
                    tempArray[curY][curX] = 0;
                }
            }
            // When delete
            else {
                int originalStore = tempArray[curY][curX];
                tempArray[curY][curX] = 0;
                if (!isValid(tempArray, n)) {
                    tempArray[curY][curX] = originalStore;
                }
            }
        }
        
        // Add to array
        for (int x = 0; x < n+1; x++) {
            for (int y = 0; y < n+1; y++) {
                if (tempArray[y][x] == 1 || tempArray[y][x] == 2) {
                    int[] tempStore = new int[3];
                    tempStore[0] = x;
                    tempStore[1] = y;
                    tempStore[2] = tempArray[y][x] - 1;
                    answer.add(tempStore);
                }
            }
        }
        
        int[][] answerReturn = new int[answer.size()][];
        for (int i = 0; i < answer.size(); i++) {
            answerReturn[i] = answer.get(i);
        }
        
        return answerReturn;
    }
}
