package Leetcode_100;

import java.util.Set;
import java.util.HashSet;

class Solution {
    public static void setZeroes(int[][] matrix) {
        //Define hash set
        Set<String> hashSet = new HashSet<>();

        //Store size of each array
        int row = matrix.length;
        int col = matrix[0].length;

        //Traverse around each element
        for(int i=0; i<row*col; i++) {
            int curRow = i/col;
            int curCol = i%col;

            //If matrix element is 0
            if(matrix[curRow][curCol] == 0) {
                hashSet.add("0," + curRow);
                hashSet.add("1," + curCol);
            }
        }

        for(int i=0; i<row*col; i++) {
            int curRow = i/col;
            int curCol = i%col;
            //Else if matrix element is not 0 and contains hash set value
            if(hashSet.contains("0," + curRow) ||hashSet.contains("1," + curCol)) matrix[curRow][curCol] = 0;
        }
    }

    public static void main(String strs[]) {
        int [][] inputArray = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(inputArray);

        for(int i=0; i<inputArray.length; i++) {
            for(int j=0; j<inputArray[0].length; j++) {
                System.out.print(inputArray[i][j]);
            }
            System.out.println("");
        }
    }
}