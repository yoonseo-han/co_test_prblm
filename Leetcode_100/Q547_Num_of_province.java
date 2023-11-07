package Leetcode_100;

class Solution {
    public static void dfs(boolean[] visited, int[][] isConnected, int i) {
        //Recursive approach starting from current index
        for(int j=0; j<isConnected[i].length; j++) {
            //Continue to traverse based on the landing index
            if(!visited[j] && isConnected[i][j] != 0) {
                visited[j] = true;
                dfs(visited, isConnected, j);
            }
        }
    }

    public static int findCircleNum(int[][] isConnected) {
        //Check the connectivity: Run DFS for each unvisited noge

        //Boolean to track the visitivity of each component
        boolean [] visited = new boolean[isConnected.length];
        int count = 0;

        for(int i=0; i<isConnected.length; i++) {
            if(visited[i] == false) {
                count++;
                dfs(visited, isConnected, i);
            }
        }

        return count;
    }
    public static void main(String strs[]) {
        int [][] isConnected = {{1,1,0},{1,1,0}, {0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }
}