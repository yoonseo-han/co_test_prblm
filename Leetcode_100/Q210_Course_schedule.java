package Leetcode_100;

class Solution {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        
    }
    public static void main(String strs[]) {
        int numCourses = 4;
        int [][] prerequisites = {{1,0}, {2,0}, {3,1}, {3,2}};
        System.out.println(findOrder(numCourses, prerequisites));
    }
}