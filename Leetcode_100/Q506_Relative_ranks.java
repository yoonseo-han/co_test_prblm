package Leetcode_100;

import java.util.*;

class Solution {
    public static String[] findRelativeRanks(int[] score) {
        String [] result = new String[score.length];

        //Able to get the highest score using priority queue
        //Sort based on score[] vaue
        PriorityQueue<Integer> pq =  new PriorityQueue<>((a,b)->score[b]-score[a]);
        for(int i=0; i<score.length; i++) pq.add(i);

        int i=1;
        while(!pq.isEmpty()){
            int idx = pq.poll();
            
            if(i>3){
                result[idx] = Integer.toString(i);
            }else if(i==1){
                result[idx] = "Gold Medal";
            }else if(i==2){
                result[idx] = "Silver Medal";
            }else if(i==3){
                result[idx] = "Bronze Medal";
            }
            i++;
        }
        
        return result;
    }
    public static void main(String strs[]) {
        int [] score = {10,3,8,9,4};
        String [] result = findRelativeRanks(score);
        for(String i: result) System.out.println(i);
    }
}