package Leetcode_100;

class Solution {
    public static int[] constructRectangle(int area) {
        int w = (int)Math.sqrt(area);
        while (area%w!=0) w--;
        return new int[]{area/w, w};
    }
    public static void main(String strs[]) {
        int area = 37;
        int [] result = constructRectangle(area);
        for(int i:result) System.out.print(i + ",");
    }
}