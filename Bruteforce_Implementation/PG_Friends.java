class Solution {

    // 2x2 블록 체크
    public boolean checkBlock(char[][] board, int r, int c) {
        char curChar = board[r][c];
        if (curChar == '.')
            return false;
        if (r + 1 >= board.length || c + 1 >= board[0].length)
            return false;

        for (int i = r; i < r + 2; i++) {
            for (int j = c; j < c + 2; j++) {
                if (board[i][j] != curChar)
                    return false;
            }
        }
        return true;
    }

    // 삭제 표시된 블록을 '.'으로 변경
    public void updateRemoveStatus(boolean[][] remove, char[][] board, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (remove[i][j])
                    board[i][j] = '.';
            }
        }
    }

    // 중력 처리 (StringBuilder 활용)
    public void applyGravity(char[][] board, int m, int n) {
        for (int j = 0; j < n; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                if (board[i][j] != '.')
                    sb.append(board[i][j]);
            }

            int idx = m - 1;
            for (int k = sb.length() - 1; k >= 0; k--) {
                board[idx--][j] = sb.charAt(k);
            }

            while (idx >= 0) {
                board[idx--][j] = '.';
            }
        }
    }

    // 삭제할 블록 찾고 제거 + 중력 적용
    public boolean removeBlock(int m, int n, char[][] board) {
        boolean[][] removeStatus = new boolean[m][n];
        boolean isRemoved = false;

        // 2x2 체크 후 삭제 표시
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (checkBlock(board, i, j)) {
                    isRemoved = true;
                    removeStatus[i][j] = true;
                    removeStatus[i + 1][j] = true;
                    removeStatus[i][j + 1] = true;
                    removeStatus[i + 1][j + 1] = true;
                }
            }
        }

        // 블록 제거
        updateRemoveStatus(removeStatus, board, m, n);

        // 중력 적용
        applyGravity(board, m, n);

        return isRemoved;
    }

    public int solution(int m, int n, String[] input) {
        int answer = 0;

        // 문자열 배열 → char 2D 배열
        char[][] board = new char[m][n];
        for (int i = 0; i < m; i++) {
            board[i] = input[i].toCharArray();
        }

        // 반복: 삭제할 블록이 없을 때까지
        while (removeBlock(m, n, board)) {
        }

        // 결과 계산: '.' 개수 세기
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.')
                    answer++;
            }
        }

        return answer;
    }
}
