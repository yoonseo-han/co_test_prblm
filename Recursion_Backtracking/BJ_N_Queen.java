import java.util.*;

class Main {
    public static int count = 0;

    public static boolean isSafe(int[][] board, int row, int col) {
        int i, j;
        int N = board.length;

        // Check this column on upper side
        for (i = 0; i < row; i++)
            if (board[i][col] == 1)
                return false;

        // Check upper diagonal on left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check upper diagonal on right side
        for (i = row, j = col; i >= 0 && j < N; i--, j++)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    public static void solveNQueens(int[][] board, int row) {
        int N = board.length;
        if (row >= N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 1;
                solveNQueens(board, row + 1);
                board[row][i] = 0; // backtrack
            }
        }
    }

    public static int countMaxScenario(int N) {
        count = 0; // reset count for each new scenario
        int[][] board = new int[N][N];
        solveNQueens(board, 0);
        return count;
    }

    public static void main(String[] strs) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(countMaxScenario(N));
    }
}
