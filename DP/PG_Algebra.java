package DP;

import java.util.*;
import java.math.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/1843

class Solution {
    public static int solution(String arr[]) {
        //Definition: dp[i][j] = max value between i and j number
        //dp[i][j] = Math.max(dp[i][j], dp[i][new] +- dp[new][j])

        //Note that to get the max value from subtraction: Max - Min, 
        //Get max value from addition: Max + Max

        //max_dp[i][j] = Math.max(max_dp[i][j], max_dp[i][new] + max_dp[new][j])
        //max_dp[i][j] = Math.max(max_dp[i][j], max_dp[i][new] - min_dp[new][j])
        //min_dp[i][j] = Math.min(min_dp[i][j], min_dp[i][new] - max_dp[new][j])
        //min_dp[i][j] = Math.min(min_dp[i][j], min_dp[i][new] + min_dp[new][j])
        int len =arr.length/2+1;

        int [][] max_dp = new int[len][len];
        int [][] min_dp = new int[len][len];

        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                max_dp[i][j] = Integer.MIN_VALUE;
                min_dp[i][j] = Integer.MAX_VALUE;
            }
        }

        //2D dp initialization: Start and end at i
        for (int i = 0; i < arr.length; i++) {
            int num = Integer.parseInt(arr[i*2]);
            max_dp[i][i] = num;
            min_dp[i][i] = num;
        }

        for(int cnt = 1; cnt<len; cnt++) {
            for(int i=0; i<len - cnt; i++) {
                int j = i + cnt;

                for(int k = i; k<j; k++) {
                    if (arr[k*2+1] == "+") {
                        max_dp[i][j] = Math.max(max_dp[i][j], max_dp[i][k] + max_dp[k+1][j]);
                        min_dp[i][j] = Math.min(min_dp[i][j], min_dp[i][k] + min_dp[k+1][j]);
                    } else {
                        max_dp[i][j] = Math.max(max_dp[i][j], max_dp[i][k] - min_dp[k+1][j]);
                        min_dp[i][j] = Math.min(min_dp[i][j], min_dp[i][k] - max_dp[k+1][j]);
                    }
                }
            }
        }

        return max_dp[0][len-1];
    }
    public static void main(String strs[]) {
        String [] arr = {"1", "-", "3", "+", "5", "-", "8"};
        System.out.println(solution(arr));
    }
}