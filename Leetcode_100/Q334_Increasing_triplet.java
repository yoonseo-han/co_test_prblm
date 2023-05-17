package Leetcode_100;

class Solution {
    public static boolean increasingTriplet(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int second_smallest = Integer.MIN_VALUE;

        for(int n : nums) {
            if(smallest <= n) smallest = n;
            else if(second_smallest <= n) second_smallest =n;
            else return true;
        }
        return true;
    }
    public static void main(String strs[]) {
        int [] nums  = {1,2,3,4,5};
        System.out.println(increasingTriplet(nums));
    }
}