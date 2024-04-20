//https://www.acmicpc.net/problem/2178

import java.util.*;

public class Main {
    static int[][] map;
	static int N;
	static int M;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 }; //x방향배열-상하
    static int[] dy = { 0, 0, -1, 1 }; //y방향배열-좌우

    public static void dfs(int curX, int curY) {
        Queue<int []> tempQueue = new LinkedList<>();
        visited = new boolean[N][M];

        //Add the current node to the queue
        tempQueue.add(new int[]{curX, curY});

        while(!tempQueue.isEmpty()) {
            int [] curArray = tempQueue.poll();
            curX = curArray[0];
            curY = curArray[1];

            for(int i=0; i<4; i++) {
                int newX = curX + dx[i];
                int newY = curY + dy[i];
    
                //Continue if out of bounds or visited or not path
                if(newX < 0 || newY < 0 || newX >= N || newY >= M || visited[newX][newY] == true || map[newX][newY] == 0) continue;

                tempQueue.add(new int[]{newX, newY});
                map[newX][newY] = map[curX][curY] + 1;
                visited[newX][newY] = true;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            String curString = scanner.next();
            for(int j = 0; j < M; j++) {
                map[i][j] = curString.charAt(j) - '0';
            }
        }

        dfs(0,0);

        System.out.println(map[N-1][M-1]);
    }
}