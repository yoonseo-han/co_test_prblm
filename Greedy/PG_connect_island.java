package Greedy;

//https://school.programmers.co.kr/learn/courses/30/lessons/42861

import java.util.*;

class Solution {
    static int [] parent;

    public static int getParentNode(int curNode) {
        if(curNode == parent[curNode]) return curNode;
        return parent[curNode] = getParentNode(parent[curNode]);
    }

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        //Sort array interms of costs
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

        //Initialize parent array
        parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;

        for(int [] edges: costs) {
            int start = edges[0];
            int end = edges[1];
            int cost = edges[2];

            //Get parent node
            int startNode = getParentNode(start);
            int endNode = getParentNode(end);

            //If both of them are equal: Already connected -> ignore current edge
            if(startNode == endNode) continue;

            //If both edge are not connected: make them connected by having same parent
            answer+=cost;

            //One of the parent node having same parent as other's parent
            if(startNode<endNode) parent[endNode] = parent[startNode];
            else parent[startNode] = parent[endNode];
            //parent[start] = endNode;
        }

        return answer;
    }
    public static void main(String strs[]) {
        int n = 4;
        int [][] costs = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};

        System.out.println(solution(n, costs));
    }
}