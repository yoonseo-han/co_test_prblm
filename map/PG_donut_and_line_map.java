package map;

import java.util.*;

class Solution {
    private static List<List<Integer>> graph;
    private static boolean[] visited;
    private static int startVertex;
    private static int maxVertex;
    private static int graphNum;
    // Stores the number of incoming edges
    private static int[] incomingEdges;

    public static void initGraph(int[][] edges) {
        //Initialize vertex
        maxVertex = 0;

        //Max vertex reached for the max number to be provided
        for(int i=0; i<edges.length; i++) maxVertex = Math.max(maxVertex, Math.max(edges[i][0], edges[i][1]));

        //Initialize the data structures
        visited = new boolean[maxVertex + 1];
        incomingEdges = new int[maxVertex + 1];
        graph = new ArrayList<>(maxVertex + 1);

        for (int i = 0; i <= maxVertex; i++) {
            graph.add(i, new LinkedList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]); //단방향 그래프
            incomingEdges[edges[i][1]]++;
        }
    }

    public static int findCreatedVertex() {
        //Find the newly added created vertex: Does no have any incoming edges and have 2 outgoing edges
        int startingVertex = -1;
        for(int i=0; i<maxVertex; i++) {    
            if(incomingEdges[i] == 0 && graph.get(i).size() >=2 ) {
                startingVertex = i;
                break;
            }
        }
        visited[startingVertex] = true;
        return startingVertex;
    }

    public static int countNumOfBar(int startVertex) {
        int numOfBar = 0;

        //Examine all edges in graph
        for(int i=1; i< graph.size(); i++) {
            if(i == startVertex) continue;
            if(graph.get(i).isEmpty()) {
                numOfBar++;
                visited[i] = true;
            }
        }

        return numOfBar;
    }

    //Num of Eight graph = Num of node with 2 out 2 in
    public static int countNumOfEight(int startVertex) {
        int numOfEight=0;

        for(int i=0; i<graph.size(); i++) {
            if(graph.get(i).size() == 2 && incomingEdges[i] == 2) {
                numOfEight++;
            }
        }

        return numOfEight;
    }

    public static int[] solution(int[][] edges) {
        int[] answer = new int[4];

        initGraph(edges);

        //Find the start vertex
        startVertex = findCreatedVertex();
        //Num of subgraph = Num of direct edges with the start vertex
        graphNum = graph.get(startVertex).size();
        answer[0] = startVertex;

        //Have to remove the info related to start vertex
        for(int end:graph.get(startVertex)){
            incomingEdges[end]--;
        }
        graph.set(startVertex, new LinkedList<>());

        answer[2] = countNumOfBar(startVertex);

        answer[3] = countNumOfEight(startVertex);
        answer[1] = graphNum - (answer[2] + answer[3]);

        return answer;
    }
    public static void main(String strs[]) {
        int [][] edges = {{4,11}, {1,12}, {8,3}, {12,7}, {4,2}, {7,11}, {4, 8}, {9,6}, {10,11}, {6,10}, {3,5}, {11, 1}, {5,3}, {11,9}, {3,8}};
        for (int i: solution(edges)) {
            System.out.println(i);
        }
    }
}