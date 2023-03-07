package Heap;

import java.util.*;

class Solution {
    public static int solution(int[][] jobs) {
        //Intialize variable
        int time = 0;
        int jobIdx = 0;
        int endTime = 0;
        int count = 0;

        //Sort interms of request time
        Arrays.sort(jobs, (o1, o2) -> (o1[0] - o2[0]));

        //Define priority queue : Prioritize based on process time
        PriorityQueue<int[]> store = new PriorityQueue<>((o1, o2) -> (o1[1]-o2[1]));

        while(count < jobs.length) {
            //Add all capable jobs to queue
            while (jobIdx < jobs.length && jobs[jobIdx][0] <= endTime) {
				store.add(jobs[jobIdx++]);
			}

            //If queue is empty: Move end time to next processing one
            if(store.isEmpty()) endTime = jobs[jobIdx][0];

            //Else, process the job wiht smallest process time
            else {
                int[] temp = store.poll();
				time += temp[1] + endTime - temp[0];
				endTime += temp[1];
				count++;
            }
        }


        return (int) Math.floor(time / jobs.length);
    }
    public static void main(String strs[]) {
        int[][] inputArray = {{0,3},{1,9},{2,6}};
        System.out.println(solution(inputArray));
    }
}