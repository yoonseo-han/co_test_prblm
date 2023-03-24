package Leetcode_100;

import java.util.*;

class Solution {
    public static void initializeGraph(List<List<Integer>> graph, int [] linkCount ,int [][] prerequisites, int numCourses) {
        for(int i = 0; i<numCourses; i++) graph.add(new ArrayList<>());
        //Update source sink relationship
        for(int [] tempArray : prerequisites) {
            graph.get(tempArray[1]).add(tempArray[0]);
            linkCount[tempArray[0]]++;
        }
    }

    public static int[] solveByBFS(List<List<Integer>> graph, int [] linkCount,int numCourses ) {
        int [] order = new int[numCourses];
        Queue<Integer> tempStore = new PriorityQueue<>();

        for(int i=0; i<numCourses; i++) {
            if(linkCount[i] == 0) tempStore.add(i);
        }

        int iterator = 0;
        while(!tempStore.isEmpty()) {
            int source = tempStore.poll();
            order[iterator++] = source;
            for(int sink: graph.get(source)) {
                linkCount[sink]--;
                if(linkCount[sink] == 0) tempStore.add(sink);
            }
        }

        return iterator == numCourses? order: new int[0];
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        //first have to intialize graph and link count (recrods the number of prereqs)
        int [] linkCount = new int[numCourses];
        //Graph represented by list
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        //Initialize graph
        initializeGraph(graph, linkCount, prerequisites, numCourses);
        //Solve using BFS
        return solveByBFS(graph, linkCount, numCourses);
    }
    public static void main(String strs[]) {
        int numCourses = 4;
        int [][] prerequisites = {{1,0}, {2,0}, {3,1}, {3,2}};
        System.out.println(findOrder(numCourses, prerequisites));
    }
}