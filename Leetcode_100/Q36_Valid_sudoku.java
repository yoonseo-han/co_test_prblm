package Leetcode_100;

import java.util.Set;
import java.util.HashSet;

class Solution {
    public static boolean isValidSudoku(char [][] board) {
        Set storeSudoku = new HashSet();

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] != '.') {
                    String inputElement = "(" + board[i][j] + ")";
                    if(!storeSudoku.add(inputElement + i) || !storeSudoku.add(j+inputElement) || !storeSudoku.add(j/3 + inputElement + i/3)) return false;
                }
            }
        }

        return true;
    }

    public static void main(String strs[]) {
        char[][] inputBoard = 
        {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
        ,{'6', '.', '.', '1', '9', '5', '.', '.', '.'}
        ,{'.', '9', '8', '.', '.', '.', '.', '6', '.'}
        ,{'8', '.', '.', '.', '6', '.', '.', '.', '3'}
        ,{'4', '.', '.', '8', '.', '3', '.', '.', '1'}
        ,{'7', '.', '.', '.', '2', '.', '.', '.', '6'}
        ,{'.', '6', '.', '.', '.', '.', '2', '8', '.'}
        ,{'.', '.', '.', '4', '1', '9', '.', '.', '5'}
        ,{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(isValidSudoku(inputBoard));
    }
}