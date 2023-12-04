package Leetcode_100;

import java.util.*;

class Solution {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new LinkedList<>();
        int i = 0;
	    // add all the intervals ending before newInterval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        // merge all overlapping intervals to one considering newInterval : All overlapping intervals considered
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            // we could mutate newInterval here also
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // add the union of intervals we got
        result.add(newInterval); 
        
        // add all the rest
        while (i < intervals.length){
            result.add(intervals[i]); 
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
    public static void main(String strs[]) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        for(int[] i : insert(intervals, newInterval)) {
            System.out.println(i);
        }
    }
}