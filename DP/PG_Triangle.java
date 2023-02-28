package DP;

import java.lang.*;

class Solution {
    public static int solution(int[][] triangle) {
        int depth = triangle.length;
        int[][] sum = new int[depth][triangle[depth-1].length];

        //base case
        sum[0][0] = triangle[0][0];
        for(int i=1; i<depth; i++) {
            int numOfEl = triangle[i].length;
            for(int j=0; j< numOfEl; j++) {
                if(j==0) sum[i][j] = sum[i-1][j] + triangle[i][j];
                else if(j==numOfEl-1) sum[i][j] = sum[i-1][j-1] + triangle[i][j];
                else sum[i][j] = Math.max(sum[i-1][j-1], sum[i-1][j]) + triangle[i][j];
            }
        }

        //Return largest element stored in last row
        int max = 0;
        for(int i=0; i<triangle[depth-1].length; i++) {
            max = Math.max(max, sum[depth-1][i]);
        }

        return max;
    }
    public static void main(String strs[]) {
        int [][] triangle = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
        System.out.println(solution(triangle));
    }
}