package Leetcode_100;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<>();

        //Edge cases
        if(nums.length == 0) return 0;

        //Add elements to set
        for(int i: nums) num_set.add(i);

        //Intialize variable
        int longestStreak = 0;

        //Iterate over set
        for(int num: num_set) {
            if(!num_set.contains(num-1)) {
                int currentStreak = 1;
                int curNum = num;
                while(num_set.contains(curNum+1)) {
                    currentStreak++;
                    curNum++;
                }
                longestStreak = Math.max(currentStreak, longestStreak);
            }
        }
        return longestStreak;
    }

    public static void main(String strs[]) {
        int [] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
}