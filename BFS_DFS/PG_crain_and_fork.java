import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int N, M;
    char[][] map;
    boolean[][] isExternal;

    public int solution(String[] storage, String[] requests) {
        N = storage.length;
        M = storage[0].length();
        map = new char[N][M];
        
        for (int i = 0; i < N; i++) {
            map[i] = storage[i].toCharArray();
        }

        // 초기 외부 상태 업데이트
        updateIsExternal();

        for (String curCmd : requests) {
            char target = curCmd.charAt(0);
            if (curCmd.length() == 1) {
                deleteExternal(target);
            } else {
                deleteChar(target);
            }
            // 삭제 후에는 항상 외부 영역을 새로 계산해서 통로를 업데이트함
            updateIsExternal();
        }

        // 남은 컨테이너 개수 계산
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != '.') answer++;
            }
        }
        return answer;
    }

    // 맵 전체를 보면서 외부와 연결된 빈 공간('.')을 찾는 DFS
    public void updateIsExternal() {
        isExternal = new boolean[N][M];
        // 가장자리(테두리)에서 빈 공간인 곳들로부터 DFS 시작
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 가장자리이면서 (빈 공간이거나 이미 외부로 판정된 경우)
                if (i == 0 || j == 0 || i == N - 1 || j == M - 1) {
                    if (map[i][j] == '.' && !isExternal[i][j]) {
                        dfsFillExternal(i, j);
                    }
                }
            }
        }
    }

    private void dfsFillExternal(int r, int c) {
        isExternal[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                // 인접한 곳이 빈 공간인데 아직 외부 체크가 안 됐다면 확산
                if (map[nr][nc] == '.' && !isExternal[nr][nc]) {
                    dfsFillExternal(nr, nc);
                }
            }
        }
    }

    // 지게차: 외부와 접해있거나 가장자리에 있는 것만 삭제
    public void deleteExternal(char curChar) {
        List<int[]> targets = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == curChar) {
                    // 가장자리거나, 인접한 곳 중 하나라도 isExternal인 경우
                    if (isAtEdge(i, j) || hasExternalNeighbor(i, j)) {
                        targets.add(new int[]{i, j});
                    }
                }
            }
        }
        for (int[] pos : targets) map[pos[0]][pos[1]] = '.';
    }

    // 크레인: 위치 상관없이 모두 삭제
    public void deleteChar(char curChar) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == curChar) map[i][j] = '.';
            }
        }
    }

    private boolean isAtEdge(int r, int c) {
        return r == 0 || c == 0 || r == N - 1 || c == M - 1;
    }

    private boolean hasExternalNeighbor(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                if (isExternal[nr][nc]) return true;
            }
        }
        return false;
    }
}