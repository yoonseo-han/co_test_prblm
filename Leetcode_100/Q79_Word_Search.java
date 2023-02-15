package Leetcode_100;

class Solution {
    static boolean[][] visited;
    public static boolean existsRecursive(char[][] board, String word, int x, int y, int charIter) {
        //Base case
        if(charIter == word.length()) return true;

        //All other failure cases
        if(x<0||y<0||x>board.length-1||y>board[0].length-1||visited[x][y]==true||word.charAt(charIter) != board[x][y]) return false;

        //Recursively check all 4 directions
        visited[x][y] = true;
        if(existsRecursive(board,word,x+1,y,charIter+1) || 
        existsRecursive(board,word,x,y+1,charIter+1) ||
        existsRecursive(board,word,x-1,y,charIter+1) ||
        existsRecursive(board,word,x,y-1,charIter+1)) return true;

        //After one DFS, it moves up the path and changes all of the elements to not visited
        visited[x][y] = false;

        return false;
    }

    public static boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == word.charAt(0) && existsRecursive(board, word, i, j, 0)) return true;
            }
        }

        return false;
    }

    public static void main(String strs[]) {
        char[][] inputArray = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String word = "ABCCED";

        System.out.println(exist(inputArray, word));
    }
}