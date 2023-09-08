package Leetcode_100;

import java.util.*;

class Solution {
    public static int eraseOverlapIntervals(int[][] intervals) {
        //Edge cases
        if (intervals.length == 0)  return 0;

        //Overlap when the second index is larger than first index of another array

        //Want to achieve max non overlapping intervals

        //First sort based on ending position in ascending order : Define new comparator
        Arrays.sort(intervals, new Comparator<int []>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int count = 1;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }

        return intervals.length - count;
    }
    public static void main(String strs[]) {
        int [][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }
}