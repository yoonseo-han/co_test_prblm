import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static Stack<int[]> medusaPath;

    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // Get medusa information
        st = new StringTokenizer(bf.readLine());
        int startR = Integer.parseInt(st.nextToken());
        int startC = Integer.parseInt(st.nextToken());

        int endR = Integer.parseInt(st.nextToken());
        int endC = Integer.parseInt(st.nextToken());

        List<int[]> enemyInfo = new ArrayList<>();
        medusaPath = new Stack<>();

        // Read enemy info
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++) {
            int enemyR = Integer.parseInt(st.nextToken());
            int enemyC = Integer.parseInt(st.nextToken());

            enemyInfo.add(new int[] { enemyR, enemyC });
        }

        // Read Map info
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                int mapInfo = Integer.parseInt(st.nextToken());
                map[i][j] = mapInfo;
            }
        }

        // Calculate min distance for path of Medusa
    }

    public static void findMinPath(int startR, int startC, int endR, int endC) {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> storePath = new LinkedList<>();

        storePath.add(new int[] { startR, startC });
        visited[startR][startC] = true;

        // Parent를 항상 트랙하며 Min path를 담을 int[][]
        int[][] parentR = new int[N][N];
        int[][] parentC = new int[N][N];

        // Cant initialize as 0 since 0 can also be an index
        for (int i = 0; i < N; i++) {
            Arrays.fill(parentR[i], -1);
            Arrays.fill(parentC[i], -1);
        }

        while (!storePath.isEmpty()) {
            int[] curNode = storePath.poll();
            int curR = curNode[0];
            int curC = curNode[1];

            // Base case -> read destination
            if (curR == endR && curC == endC) {
                trackPath(startR, startC, endR, endC, parentR, parentC);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int newR = curR + dy[i];
                int newC = curC + dx[i];

                if (newR < 0 || newC < 0 || newR >= N || newC >= N)
                    continue;
                if (visited[newR][newC] || map[newR][newC] != 0)
                    continue;

                tempStore.add(new int[] { newR, newC });
                visited[newR][newC] = true;
                parentR[newR][newC] = curR;
                parentC[newR][newC] = curC;
            }
        }
    }

    public static trackPath(int startR, int startC, int endR, int endC, int[][] parentR, int[][] parentC) {
        int curR = endR;
        int curC = endC;

        while(curR != -1 && curC != -1) {
            medusaPath.add(new int[]{curR, curC});
            int pR = parentR[curR][curC];
            int pC = parentC[curR][curC];

            curR = pR;
            curC = pC;
        }
    }
}