//https://school.programmers.co.kr/learn/courses/30/lessons/86971

import java.util.*;

class Solution {
    public int getNumNode(int startNode, int n, int[][] map) {
        int answer = 0;
        
        Queue<Integer> tempStore = new LinkedList<Integer>();
        tempStore.add(startNode);
        boolean[] visited = new boolean[n];
        visited[startNode] = true;
        
        while(!tempStore.isEmpty()) {
            int curNode = tempStore.poll();

            for(int i=0; i<n; i++) {
                //If not visited and is connected: Add to queue and change to visited
                if(map[curNode][i] == 1 && visited[i]==false) {
                    visited[i] = true;
                    tempStore.add(i);
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            if(visited[i]) answer++;
        }
        
        return answer;
    }
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        int[][] map = new int[n][n];
        
        int count = 0;
        for(int[] curArr: wires){
            map[curArr[0]-1][curArr[1]-1] = 1;
            map[curArr[1]-1][curArr[0]-1] = 1;
        }
        
        // for(int i=0; i<n; i++) {
        //     for(int j = 0; j<n; j++) System.out.print(map[i][j] + " ");
        //     System.out.println("");
        // }
        
        for(int[] curArr: wires) {
            int firstStartNode = curArr[0]-1;
            int secondStartNode = curArr[1]-1;
            map[firstStartNode][secondStartNode] = 0;
            map[secondStartNode][firstStartNode] = 0;
            
            answer = Math.min(Math.abs(getNumNode(firstStartNode, n, map) - getNumNode(secondStartNode, n, map)), answer);
            
            map[firstStartNode][secondStartNode] = 1;
            map[secondStartNode][firstStartNode] = 1;
        }
        
        return answer;
    }
}