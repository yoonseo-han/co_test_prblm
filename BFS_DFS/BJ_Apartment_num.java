//https://www.acmicpc.net/problem/2667

import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] visited;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,1,-1};

    public static void bfs(int y, int x, ArrayList<Integer> storeSize, int[][] map) {
        Queue<int[]> storePosition = new LinkedList<>();
        storePosition.add(new int[]{y,x});
        visited[y][x] = true;
        int size = 1;

        while(!storePosition.isEmpty()) {
            int[] curPos = storePosition.poll();
            int curY = curPos[0];
            int curX = curPos[1];

            for(int i=0; i<4; i++) {
                int dX = curX + dx[i];
                int dY = curY + dy[i];

                if(dX < 0 || dY < 0 || dX >= map[0].length || dY >= map.length || visited[dY][dX] || map[dY][dX] == 0) continue;

                visited[dY][dX] = true;
                size++;
                storePosition.add(new int[]{dY, dX});
            }
        }
        storeSize.add(size);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int [][] map = new int[N][N];
        visited = new boolean[N][N];
        ArrayList<Integer> storeSize = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            String[] newLine = scanner.nextLine().split("");
            for(int j = 0; j < N; j ++) {
                map[i][j] = Integer.parseInt(newLine[j]);
            }
        }
        for(int i=0; i<N; i++) {
            for(int j = 0; j<N; j++) {
                if(visited[i][j] == false && map[i][j] == 1) bfs(i, j, storeSize, map);
                //System.out.print(map[i][j] + ",");
            }
        }

        //Sort array elements
        Collections.sort(storeSize);
        System.out.println(storeSize.size());
        for(int i=0; i<storeSize.size(); i++) System.out.println(storeSize.get(i));
    }
}