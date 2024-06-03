//https://school.programmers.co.kr/learn/courses/30/lessons/77485

class Solution {
    public static int[][] map;

    public static void moveTopRight(int x1, int y1, int x2, int y2) {
        
    }
    public static void moveRightDown(int x1, int y1, int x2, int y2) {

    }
    public static void moveBottomLeft(int x1, int y1, int x2, int y2) {

    }
    public static void moveRightUp(int x1, int y1, int x2, int y2) {

    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        map = new int[rows][columns];
        int[] answer = {};

        int cnt = 1;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) map[i][j] = cnt++;
        }
        

        return answer;
    }
    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int [][] queries = {{2,2,5,4}, {1,2,2,3}, {2,1,3,2}, {2,2,3,3}};
        int [] result = solution(rows, columns, queries);
        for(int i: result)System.out.println(i);
    }
}