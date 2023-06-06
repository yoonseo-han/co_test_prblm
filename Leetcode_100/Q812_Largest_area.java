package Leetcode_100;

class Solution {
    //Use equation to calculate area of triangle
    //S=[x1(y2−y3)+x2(y3−y1)+x3(y1−y2)]/2
    public static double calculateArea(int[] x1, int[] x2, int[] x3) {
        int t1 = x1[0] * ( x2[1] - x3[1]);
        int t2 = x2[0] * ( x3[1] - x1[1]);
        int t3 = x3[0] * ( x1[1] - x2[1]);
        return (double)( t1 + t2 + t3 )/2;

    }

    public static double largestTriangleArea(int[][] points) {
        double area = 0;

        //Brute force approach: Calculate all possible triangles to be made
        int n = points.length;

        for(int i=0; i<n; i++) {
            for(int j =i+1; j<n; j++)
                for(int k =j+1; k<n; k++)
                    area = Math.max(area , Math.abs(calculateArea(points[i], points[j], points[k])));
        }

        return area;
    }
    public static void main(String strs[]) {
        int [][] points = {{0,0}, {0,1}, {1,0}, {0,2}, {2,0}};
        System.out.println(largestTriangleArea(points));
    }
}