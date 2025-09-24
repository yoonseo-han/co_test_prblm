import java.util.*;
import java.io.*;

public class Main {

    static class Group implements Comparable<Group> {
        int groupID;
        int size;
        List<int[]> points;

        public Group(int groupID, List<int[]> points) {
            this.groupID = groupID;
            this.size = points.size();
            this.points = points;
        }

        @Override
        public int compareTo(Group otherGroup) {
            if (this.size != otherGroup.size)
                return otherGroup.size - this.size;
            // One with smaller ID
            return this.groupID - otherGroup.groupID;
        }
    }

    static int N;
    static int Q;
    static int[][] map;
    static int dx = { -1, 1, 0, 0 };
    static int dy = { 0, 0, 1, -1 };
    static int microCnt = 0;
    List<Group> groupStore;

    public static void main(String[] args) throws IOException {
        // Please write your code here.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        groupStore = new ArrayList<>();

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        microCnt++;

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            // Always add new group to desired position
            setMap(r1, c1, r2, c2);

            if (microCnt > 1) {
                checkAndRemoveDividedGroups();
            }
            moveGroups(groupStore);
        }
    }

    public static void setMap(int r1, int c1, int r2, int c2) {
        for (int i = r1; i < r2; i++) {
            for (int j = c1; j < c2; j++) {
                map[i][j] = microCnt;
            }
        }
        microCnt++;
    }

    public static void checkAndRemoveDividedGroups() {
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // Already visited (previously dealt microgorup) or empty
                if (map[i][j] == 0 || visited[i][j] == true)
                    continue;

                int groupID = map[i][j];

                // Run BFS from here: Collect all of the points of outer line
                List<int[]> connectedCells = bfsCollectGroup(i, j, groupID, visited);

                // Determine if there is divided group -> Another one with same groupID
                if (!groupDivideExist(groupID, connectedCells.size())) {
                    // If so, remove the whole group from map
                    groupStore.add(new Group(groupID, connectedCells));
                } else {
                    removeGroup(groupID);
                }
            }
        }
    }

    public static List<int[]> bfsCollectGroup(int i, int j, int groupID, boolean[][] visited) {
        Queue<int[]> tempQueue = new LinkedList<>();
        List<int[]> tempResult = new ArrayList<>();

        tempQueue.offer(new int[] { i, j });
        visited[i][j] = true;

        while (!tempQueue.isEmpty()) {
            int[] cur = tempQueue.poll();

            tempResult.add(cur);
            // Check all 4 directions
            for (int i = 0; i < 4; i++) {
                int nX = cur[0] + dx[i];
                int nY = cur[1] + dy[i];

                // Check if within map range
                if (nX < 0 || nY < 0 || nX >= N || nY >= N)
                    continue;
                // Check if equal to groupID and not visited
                if (visited[nX][nY])
                    continue;
                if (map[nX][nY] != groupID)
                    continue;

                visited[nX][nY] = true;
                tempQueue.offer(new int[] { nX, nY });
            }
        }
        return tempResult;
    }

    public static boolean groupDivideExist(int groupID, int connectedCount) {
        int totalCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == groupID)
                    totalCount++;
            }
        }
        // BFS로 찾은 연결 덩어리 크기 < 전체 크기 → 끊어졌다
        return connectedCount < totalCount;
    }

    public static void removeGroup(int groupId) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == groupId) {
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void moveGroups(List<Group> groups) {
        PriorityQueue<Group> tempStore = new PriorityQueue<>();
        tempStore.addAll(groups);

        boolean[][] visited = new boolean[N][N];
        int[][] newMap = new int[N][N];

        // Queue에서 하나씩 꺼내면서 배치 가능 여부 확인 및 가능 시 배치 진행
        while (!tempStore.isEmpty()) {
            Group curGroup = tempStore.poll();
            List<int[]> curPoints = curGroup.points;

            int baseRow = curPoints.get(0)[0];
            int baseCol = curPoints.get(0)[1];

            outerLoop: for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // i, j being the target to move the base position too
                    if (canPlaceGroupAt(curPoints, baseRow, baseCol, i, j, visited)) {
                        placeGroup(curPoints, baseRow, baseCol, i, j, visited, newMap, curGroup.groupID);
                        break outerLoop;
                    }
                }
            }
        }
        map = newMap;
    }

    public static boolean canPlaceGroupAt(List<int[]> points, int baseRow, int baseCol,
            int targetRow, int targetCol, boolean[][] visited) {
        for (int[] curPoint : points) {
            int newRow = curPoint[0] - baseRow + targetRow;
            int newCol = curPoint[1] - baseCol + targetCol;

            // Check out of range or visited
            if (newRow < 0 || newCol < 0 || newRow >= N || newCol >= N)
                return false;
            if (visited[newRow][newCol])
                return false;
        }

        return true;
    }

    public static void placeGroup(List<int[]> points, int baseRow, int baseCol, int targetRow, int targetCol,
            boolean[][] visited, int[][] map, int groupID) {
        for (int[] curPoint : points) {
            int newRow = curPoint[0] - baseRow + targetRow;
            int newCol = curPoint[1] - baseCol + targetCol;

            visited[newRow][newCol] = true;
            map[newRow][newCol] = groupID;
        }
    }
}