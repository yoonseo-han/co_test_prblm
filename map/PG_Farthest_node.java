//

package map;

import java.util.*;

class Solution {
    public static int solution(int n, int[][] edge) {
        int answer = 0;
        //Return longest distance from node 1: Use BFS 
        
        //Setup the graph: 2d array to record the directly connected nodes for each node
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        //Distance of node from node 1 stored
        int [] distance = new int[n+1];
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        Queue <Integer> bfs = new LinkedList<>();

        for(int i=0; i<n+1; i++) adj.add(new ArrayList<>());
        for(int i=0; i<edge.length; i++) {
            adj.get(edge[i][0]).add(edge[i][1]);
            adj.get(edge[i][1]).add(edge[i][0]);
        }

        //Do BFS and calculate distance of each node from node 1
        bfs.add(1);
        while(bfs.size() !=0) {
            int curNode = bfs.poll();
            ArrayList<Integer> node = adj.get(curNode);

            //Get all of the direct nodes from curNoce
            for(int i=0; i<node.size(); i++) {
                if(visited[node.get(i)]==false) {
                    bfs.add(node.get(i));
                    visited[node.get(i)] = true;
                    distance[node.get(i)] = distance[curNode] + 1; 
                }
            }
        }
        Arrays.sort(distance);
        int max = distance[distance.length-1];
        for(int i = distance.length-1; distance[i] == max; i--) answer++;

        return answer;
    }
    public static void main(String strs[]) {
        int n = 6;
        int [][] edge = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
        System.out.println(solution(n, edge));
    }
}