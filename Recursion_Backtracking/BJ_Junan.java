import java.util.*;
import java.io.*;
import static java.lang.Integer.*;

class Main {
    static int N, M;
    static int[][] map;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        M = parseInt(st.nextToken());
        map = new int[N][M];
        dist = new int[N][M];

        int sx, sy, ex, ey;
        st = new StringTokenizer(br.readLine());
        sy = parseInt(st.nextToken()) - 1;
        sx = parseInt(st.nextToken()) - 1;
        ey = parseInt(st.nextToken()) - 1;
        ex = parseInt(st.nextToken()) - 1;

        for (int y = 0; y < N; y++) {
            String line = br.readLine();
            for (int x = 0; x < M; x++) {
                char val = line.charAt(x);
                if (val == '1' || val == '0') {
                    map[y][x] = val - '0';
                } else {
                    map[y][x] = 0; // Default to 0 for invalid characters
                }
            }
        }

        map[ey][ex] = 1; // Ensure destination is always marked as reachable
        dijkstra(sx, sy);

        // Check if the destination is reachable
        if (dist[ey][ex] == MAX_VALUE) {
            System.out.println("Not Reachable");
        } else {
            System.out.println(dist[ey][ex]);
        }
    }

    static void dijkstra(int curX, int curY) {
        for (int[] ints : dist) {
            Arrays.fill(ints, MAX_VALUE);
        }
        PriorityQueue<Node> tempStore = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        dist[curY][curX] = 0;
        tempStore.offer(new Node(curX, curY, 0));

        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };

        while (!tempStore.isEmpty()) {
            Node curNode = tempStore.poll();

            if (dist[curNode.y][curNode.x] < curNode.dist)
                continue;

            for (int i = 0; i < 4; i++) {
                int newX = curNode.x + dx[i];
                int newY = curNode.y + dy[i];

                if (newX < 0 || newY < 0 || newX >= M || newY >= N) {
                    continue;
                }

                if (dist[newY][newX] > dist[curNode.y][curNode.x] + map[newY][newX]) {
                    dist[newY][newX] = dist[curNode.y][curNode.x] + map[newY][newX];
                    tempStore.offer(new Node(newX, newY, dist[newY][newX]));
                }
            }
        }
    }
}

class Node {
    int x;
    int y;
    int dist;

    public Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}