package Superlabs;

import java.util.*;

class Solution {
    public static int[] solution(int n, int[][] quests) {
        int[] answer = new int[n];

        HashMap<Integer, Integer> storeRelation = new HashMap<>();
        for(int i=0; i<quests.length; i++) {
            if(!storeRelation.containsKey(quests[i][1]))storeRelation.put(quests[i][1], 1);
            else storeRelation.put(quests[i][1], storeRelation.get(quests[i][1])+1);
        }
        // for(int key: storeRelation.keySet()) System.out.print(key);
        // System.out.println("");
        // for(int value: storeRelation.values()) System.out.print(value);

        //Store jobs that are able to process in min heap
        PriorityQueue<Integer> capableJobs = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            if(storeRelation.containsKey(i+1)) continue;
            else capableJobs.add(i+1);
        }
        int cnt = 0;
        while(cnt < n) {
            //First store least number into answer
            if(!capableJobs.isEmpty()) {
                answer[cnt] = capableJobs.poll();
                //Decrement count for any jobs that had relation to it
                for(int i=0; i<quests.length; i++) {
                    if(answer[cnt] == quests[i][0]) storeRelation.put(quests[i][1], storeRelation.get(quests[i][1])-1);
                }
                cnt++;
            }

            //Add any new jobs that are able to process
            for(int i: storeRelation.keySet()) {
                if(storeRelation.get(i) == 0) {
                    capableJobs.add(i);
                    storeRelation.put(i, storeRelation.get(i)-1);
                }
            }
        }

        return answer;
    }
    public static void main(String strs[]) {
        int [][] quests = {{1,3},{1,4},{3,5},{5,4}};
        int n = 5;

        int [] result = solution(n, quests);
        for(int i: result) System.out.print(i);
    }
}