package BFS.Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    //Define boolean 2D array
    static boolean [][] visited;

    //4 Directions stored in prehand
    static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };

    //Recursive function for BFS
    public static void BFSRecursive(int [][] landArray, int x, int y) {
        //Define Queue
        Queue<int[]> storeQueue = new LinkedList<>();
        storeQueue.add(new int[] {y,x});
        
        while(!storeQueue.isEmpty()) {
            y = storeQueue.peek()[0];
            x = storeQueue.peek()[1];

            visited[y][x] = true;

            storeQueue.poll();

            for(int i=0; i<4; i++) {
                int cx = x + dx[i];
				int cy = y + dy[i];

				if (cx >= 0 && cy >= 0 && cx < landArray[0].length && cy < landArray.length) {
					if (!visited[cy][cx] && landArray[cy][cx] == 1) {
						storeQueue.add(new int[] {cy , cx});
						visited[cy][cx] = true;
					}
				}
            }
        }
    }

    public static void main(String [] strs) {
        Scanner newScanner = new Scanner(System.in);
        //Receive Num of TC
        int numOfTC = newScanner.nextInt();
        //Define output to stroe results
        int [] output = new int[numOfTC];

        for(int i=0; i<numOfTC; i++) {
            int heightLength = newScanner.nextInt();
            int wideLength = newScanner.nextInt();
            int tcResult = 0;

            //Create 2D Array : Initialized with 0
            int [][] landArray = new int[heightLength][wideLength];
            //Create visited track array
            visited = new boolean[heightLength][wideLength];

            //Get number of land
            int numOfLand = newScanner.nextInt();
            for(int j=0; j<numOfLand; j++) {
                int y =  newScanner.nextInt();
                int x =   newScanner.nextInt();
                landArray[y][x] = 1;
            }

            //Now Process and find number of lands
            for(int y = 0; y<heightLength; y++) {
                for(int x=0; x<wideLength; x++) {
                    if(landArray[y][x]==1 && visited[y][x]==false) {
                        BFSRecursive(landArray, x, y);
                        tcResult++;
                    }
                }
            }

            //Store result in output array
            output[i] = tcResult;
        }

        for(int i=0; i<numOfTC; i++) {
            System.out.println(output[i]);
        }
    }
}