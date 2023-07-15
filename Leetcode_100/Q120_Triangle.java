package Leetcode_100;

import java.util.*;

class Solution {
    public static int minimumTotal(List<List<Integer>> triangle) {
        //Use dynamic programming to calculate the min value of reaching the specific point

        //For top-down: Have to remember all the possible sum values hence require large memory

        //For bottom-up:  start from the nodes on the bottom row; the min pathsums for these nodes are the values of the nodes themselves. 
        
        //From there, the min pathsum at the ith node on the kth row would be the lesser of the pathsums of its two children plus the value of itself
        //Base case: minpath[k][i] = triangle[k][i]
        //minpath[k][i] = min( minpath[k+1][i], minpath[k+1][i+1]) + triangle[k][i];
        //Note that min values of previous k+1 row is no longer required when moved up to kth row hence
        //minpath[i] = min( minpath[i], minpath[i+1]) + triangle[k][i]; 

        // corner case
        if(triangle == null || triangle.size() == 0) return 0;
        
        // M[i] represents the min total from bottom to current position
        // copy the last row in triangle to M
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[] M = new int[n];
        for(int i = 0; i < n; i++) M[i] = triangle.get(m - 1).get(i);

        // induction rule
        // M[i] = min(M[i], M[i + 1]) + curVal
        for(int i = n - 2; i >= 0; i--){
            //Get previous row
            List<Integer> cur = triangle.get(i);
            for(int j = 0; j < cur.size(); j++){
                //Compare the 2 possible neighbor and select the smaller one
                M[j] = Math.min(M[j], M[j + 1]) + cur.get(j);
            }
        }
        
        return M[0]; 
    }
    public static void main(String strs[]) {

        // Create the 2D integer list
        List<List<Integer>> twoDList = new ArrayList<>();
        
        // Add the sublists to the 2D list
        twoDList.add(Arrays.asList(2));
        twoDList.add(Arrays.asList(3, 4));
        twoDList.add(Arrays.asList(6, 5, 7));
        twoDList.add(Arrays.asList(4, 1, 8, 3));

        System.out.println(minimumTotal(twoDList));
    }
}