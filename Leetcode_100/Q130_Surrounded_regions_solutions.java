package Leetcode_100;

class Solution {
    public static void solve(char[][] board) {
        //Dealing with edge cases
        if (board.length == 0 || board[0].length == 0) return;
        if (board.length < 3 || board[0].length < 3) return;

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') helper(board, i, 0);
            if (board[i][n - 1] == 'O') helper(board, i, n - 1);
        }

        for (int j = 1; j < n - 1; j++) {
            if (board[0][j] == 'O') helper(board, 0, j);
            if (board[m - 1][j] == 'O') helper(board, m - 1, j);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '*') board[i][j] = 'O';
            }
        }
    }
    
    private static void helper(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r > board.length - 1 || c > board[0].length - 1 || board[r][c] != 'O') return;
        board[r][c] = '*';
        helper(board, r + 1, c);
        helper(board, r - 1, c);
        helper(board, r, c + 1);
        helper(board, r, c - 1);
    }

    public static void main(String strs[]) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','O','X','X'},{'X','X','O','X'}};
        //char [][] board = {{'O', 'X', 'O'},{'O','O','O'},{'O','O','X'}};

        solve(board);

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                System.out.print(board[i][j] +" ");
            }
            System.out.println();
        }
    }
}