package Leetcode_100;

import java.lang.Math;

class Solution {
    public static int maxArea(int[] height) {
        //Initialize variable
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;

        while(i<j) {
            int area = (j-i)*Math.min(height[i], height[j]);
            maxArea = (area>maxArea)? area: maxArea;
            if(height[i]<height[j]) i++;
            else j--;
        }

        return maxArea;
    }
    public static void main(String strs[]) {
        int [] inputArray = {2,3,4,5,18,17,6};
        System.out.println(maxArea(inputArray));
    }
}