package Leetcode_100;

import java.util.*;

class Solution {
    public static List<String> summaryRanges(int[] nums) {
        List<String> answer = new ArrayList<>();
        //Base case
        if(nums.length == 1) {
            answer.add(nums[0] + "");
            return answer;
        }
        //2 Pointer
        for(int i=0; i<nums.length; i++) {
            int start = nums[i];
            while(i<nums.length-1 && (nums[i] + 1 == nums[i+1])) i++;
            if(start != nums[i]) answer.add(start + "->" + nums[i]);
            else answer.add(start + "");
        }

        return answer;
    }
    public static void main(String strs[]) {
        int [] inputArray = {0,2,3,4,6,8,9};
        System.out.println(summaryRanges(inputArray));
    }
}