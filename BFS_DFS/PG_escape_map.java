//https://school.programmers.co.kr/learn/courses/30/lessons/159993
import java.util.*;

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};

    public static int bfs(char[][] map, int[] startPosition, int[] endPosition) {
        Queue <int[]> tempStore = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        int steps = 0;

        tempStore.add(new int[]{startPosition[0], startPosition[1]});

        while(!tempStore.isEmpty()) {
            int curSize = tempStore.size();

            for(int i = 0; i<curSize; i++) {
                int [] curPosition = tempStore.poll();
                int curX = curPosition[0];
                int curY = curPosition[1];

                // Check if we've reached the end position
                if (curX == endPosition[0] && curY == endPosition[1]) {
                    return steps;
                }

                for(int j = 0; j<4; j++) {
                    int newX = curPosition[0] + dx[j];
                    int newY = curPosition[1] + dy[j];

                    if(newX < 0 || newY < 0 || newX >= map[0].length || newY >= map.length || map[newY][newX] == 'X' || visited[newY][newX] == true) continue;

                    tempStore.add(new int[]{newX, newY});
                    visited[newY][newX] = true;
                }
            }
            steps++;
        }
        return -1;
    }

    public static int solution(String[] maps) {
        int answer = 0;

        char [][] map = new char[maps.length][maps[0].length()];
        int [] startPosition = new int[2];
        int [] endPosition = new int[2];
        int [] leverPosition = new int[2];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                char tempChar = maps[i].charAt(j);
                map[i][j] = tempChar;
                if (tempChar == 'S') {
                    startPosition[0] = j;
                    startPosition[1] = i;
                } else if (tempChar == 'E') {
                    endPosition[0] = j;
                    endPosition[1] = i;
                } else if (tempChar == 'L') {
                    leverPosition[0] = j;
                    leverPosition[1] = i;
                }
            }
        }

        int startToLever = bfs(map, startPosition, leverPosition);
        if (startToLever == -1) return -1;

        int leverToEnd = bfs(map, leverPosition, endPosition);
        if (leverToEnd == -1) return -1;

        answer = startToLever + leverToEnd;

        return answer;
    }
    public static void main(String strs[]) {
        String[] maps = {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};
        System.out.println(solution(maps));
    }
}