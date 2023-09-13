package Leetcode_100;

class Solution {
    public static int largestAltitude(int[] gain) {
        int max = 0;
        int curAlt = 0;
        for(int i=0; i<gain.length; i++) {
            curAlt += gain[i];
            max = Math.max(max, curAlt);
        }
        return max;
    }
    public static void main(String strs[]) {
        int [] gain = {-5,1,5,0,-7};
        System.out.println(largestAltitude(gain));
    }
}