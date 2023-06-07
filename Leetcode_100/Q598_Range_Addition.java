package Leetcode_100;

class Solution {
    public static int maxCount(int m, int n, int[][] ops) {
        //Have to find the min value of row and column and calculate the overlap 

        //Edge cases
        if (ops == null || ops.length == 0) return m * n;

        //Get min for each value
        int colMin = Integer.MAX_VALUE;
        int rowMin = Integer.MAX_VALUE;

        for(int[] op : ops) {
            rowMin = Math.min(rowMin, op[0]);
            colMin = Math.min(colMin, op[1]);
        }

        return rowMin * colMin;
    }
    public static void main(String strs[]) {
        int m = 3;
        int n = 3;
        int [][] ops = {{2,2},{3,3}};
        System.out.println(maxCount(m,n,ops));
    }
}