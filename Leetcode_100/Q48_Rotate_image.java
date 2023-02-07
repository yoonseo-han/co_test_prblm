package Leetcode_100;

class Solution {
    public static void print(int [][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }
    }

    public static void rotate(int [][] matrix) {
        

        print(matrix);
    }
    public static void main(String strs[]) {
        int[][] inputArray = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(inputArray);
    }
}