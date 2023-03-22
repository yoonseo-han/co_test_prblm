package Leetcode_100;

class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int l = 0;
        int r = (n*m)-1;

        while(l!=r) {
            int mid = (l+r-1)/2;
            if(matrix[mid/m][mid%m] == target) return true;
            else if(matrix[mid/m][mid%m] < target) l = mid+1;
            else r = mid;
        }

        return matrix[r / m][r % m] == target;
    }

    public static void main(String strs[]) {
        int target = 3;
        int [][] matrix = {{1,3,5,7}, {10,11,12,13}, {23,24,25,26}};
        System.out.println(searchMatrix(matrix, target));
    }
}