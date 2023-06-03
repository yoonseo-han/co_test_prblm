package Leetcode_100;

class Solution {
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        //Size of original matrix
        int size = mat.length * mat[0].length;
        if(r*c != size) return mat;

        int[][] res = new int[r][c];
        for (int i=0;i<r*c;i++) 
            res[i/c][i%c] = mat[i/mat[0].length][i%mat[0].length];
        return res;
    }
    public static void main(String strs[]) {
        int [][] mat = {{1,2},{3,4}};
        int r = 1;
        int c = 4;
        System.out.println(matrixReshape(mat,r,c));
    }
}