package Leetcode_100;

class Solution {
    static boolean[][] isFlip;
    static int []di={-1,0,1,0};
    static int []dj={0,1,0,-1};
    static boolean flag = false;

    public static void recursiveSolve(char[][] board,boolean[][] isFlip, int i, int j ){
        if(board[i][j]== 'X') return;
        if(i == 0 || i == board.length-1 || j==0 || j==board[0].length) {
            isFlip[i][j] = false;
        }
        else {
            //Check all 4 directions
            for(int k=0; k<4; k++) {
                int new_i = i + di[k];
                int new_j = j + dj[k];
                System.out.println("Checking : "+new_i + " , "+ new_j);

                //recursiveSolve(board, isFlip, new_i, new_j);

                //Check range
                if(new_i <= 0 || new_i >= board.length-1 || new_j<=0 || new_j>=board[0].length) continue;
                if(board[new_i][new_j]=='O' && isFlip[new_i][new_j] == false) {
                    isFlip[i][j]=false;
                    break;
                }
            }
            //If all 4 directionflip, then flip
            if(isFlip[i][j] == true){
                System.out.println("===");
                board[i][j] = 'X';
            }
        }
    }

    public static void solve(char[][] board) {
        isFlip = new boolean[board.length][board[0].length];
        //Intialize values
        for(int i=0; i<isFlip.length; i++) {
            for(int j=0; j<isFlip[0].length; j++) {
                if(board[i][j] == 'O') isFlip[i][j]=true;
                if(board[i][j] == 'X') flag = true;
            }
        }
        //Recursive call
        if(flag == false) return;
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == 'O') {
                    System.out.println(i + " , "+j+isFlip[i][j]);
                    recursiveSolve(board, isFlip, i, j);
                }
            }
        }

        return;
    }
    public static void main(String strs[]) {
        //char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','O','X','X'},{'X','X','O','X'}};
        char [][] board = {{'O', 'O', 'O'},{'O','O','O'},{'O','O','O'}};

        solve(board);

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                System.out.print(board[i][j] +" ");
            }
            System.out.println();
        }
    }
}