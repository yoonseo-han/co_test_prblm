package Leetcode_100;

import java.util.*;

class Solution {
    public static boolean dfs(ArrayList<Integer> [] graph, boolean[] visited, int course) {
        if(visited[course]) return false;

        visited[course] = true;

        for(int i=0; i<graph[course].size(); i++) {
            if(!dfs(graph,visited,(int)graph[course].get(i))) return false;
        }
        visited[course] = false;

        return true;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        //Set up graph structure
        ArrayList<Integer> [] graph = new ArrayList[numCourses];
        //Boolean to track visited node
        boolean [] visited = new boolean[numCourses];

        //Insert nodes to graph
        for(int i=0; i<numCourses; i++) graph[i] = new ArrayList<>();
        for(int i=0; i<prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for(int i=0; i<numCourses; i++) {
            if(!dfs(graph, visited, i)) return false;
        }

        return true;
    }

    public static void main(String strs[]) {
        int numCourses = 2;
        int [][] prerequisites = {{1,0}};

        System.out.println(canFinish(numCourses, prerequisites));
    }
}