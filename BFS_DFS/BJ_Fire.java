import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static char[][] maze;
    static int[][] fireMap;
    static int[][] jhMap;
    static int R;
    static int C;

    public static boolean isEdge(int x, int y) {
        return x == 0 || x == R - 1 || y == 0 || y == C - 1;
    }

    public static boolean isOutOfRange(int i, int j) {
        return i < 0 || i >= R || j < 0 || j >= C;
    }

    public static String bfs(Queue<int[]> storeJH, Queue<int[]> storeFire) {
        while (!storeFire.isEmpty()) {
            int[] curPos = storeFire.poll();
            int curX = curPos[0];
            int curY = curPos[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (isOutOfRange(nx, ny) || fireMap[nx][ny] != -1 || maze[nx][ny] == '#') {
                    continue;
                }

                fireMap[nx][ny] = fireMap[curX][curY] + 1;
                storeFire.add(new int[] { nx, ny });
            }
        }

        while (!storeJH.isEmpty()) {
            int[] curPos = storeJH.poll();
            int curX = curPos[0];
            int curY = curPos[1];
            int curTime = jhMap[curX][curY] + 1;

            if (isEdge(curX, curY)) {
                return String.valueOf(curTime);
            }

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (isOutOfRange(nx, ny) || jhMap[nx][ny] != -1 || maze[nx][ny] == '#'
                        || (fireMap[nx][ny] != -1 && curTime >= fireMap[nx][ny])) {
                    continue;
                }

                jhMap[nx][ny] = jhMap[curX][curY] + 1;
                storeJH.add(new int[] { nx, ny });
            }
        }

        return "IMPOSSIBLE";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");

        R = Integer.parseInt(firstLine[0]);
        C = Integer.parseInt(firstLine[1]);

        Queue<int[]> storeFire = new LinkedList<>();
        Queue<int[]> storeJH = new LinkedList<>();

        maze = new char[R][C];
        fireMap = new int[R][C];
        jhMap = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                fireMap[i][j] = -1;
                jhMap[i][j] = -1;
            }
        }

        for (int i = 0; i < R; i++) {
            String str = scanner.nextLine();
            for (int j = 0; j < C; j++) {
                maze[i][j] = str.charAt(j);

                if (maze[i][j] == 'J') {
                    if (isEdge(i, j)) {
                        System.out.println(1);
                        return;
                    }
                    jhMap[i][j] = 0;
                    storeJH.add(new int[] { i, j });
                }

                if (maze[i][j] == 'F') {
                    fireMap[i][j] = 0;
                    storeFire.add(new int[] { i, j });
                }
            }
        }

        System.out.println(bfs(storeJH, storeFire));
    }
}