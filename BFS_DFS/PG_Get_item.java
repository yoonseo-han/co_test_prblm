import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/87694

class Solution {
    static int[][] map;

    public static void draw(int [][] map) {
        for(int i=0; i<map.length; i++) {
            for (int j = 0; j<map[0].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    //Helper function to fill the following coordinates
    public static void fill(int x1, int y1, int x2, int y2){
        for(int i=y1; i<=y2; i++){
            for(int j=x1; j<=x2; j++){
                //If already part of inner side: Leave it (Never will be border anyway)
                if(map[i][j]==2) continue;
                map[i][j]=2;
                //Fill 1 for the borders
                if(i==y1||i==y2||j==x1||j==x2){
                    map[i][j]=1;
                }
            }
        }
    }

    public static int bfs(int X, int Y, int itemX, int itemY) {
        int count = 0;
        int dy[]={-1,1,0,0};
        int dx[]={0,0,-1,1};

        Queue<Integer []> tempStore = new LinkedList<>();
        tempStore.add(new Integer[]{X,Y,0});
        System.out.println(map[Y][X+1]);
        System.out.println(itemY);
        System.out.println(itemX);

        //Boolean 2d array to track visited 
        boolean [][] visited = new boolean[101][101];

        while(!tempStore.isEmpty()) {
            //Current position
            Integer[] currInd = tempStore.poll();
            int curX = currInd[0];
            int curY = currInd[1];
            int curCnt = currInd[2];

            //If matches the item position
            if(curX == itemX && curY == itemY) return curCnt/2;

            for(int i=0; i<4; i++) {
                int newX = curX + dx[i];
                int newY = curY + dy[i];

                //Out of range: Prevent run time error
                if(newX < 0 || newY < 0 || newX >= map[0].length || newY >= map.length) continue;
                //Visited or is not border line
                if(visited[newY][newX] == true || map[newY][newX] != 1) continue;
                
                visited[newY][newX] = true;
                tempStore.add(new Integer[]{newX,newY,curCnt+1});
            }
        }

        return count;
    }

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        map = new int[101][101];
        for(int i=0; i<rectangle.length; i++) {
            //Fill in the borders in the 2D array
            //fill(rectangle[i][0], rectangle[i][1], rectangle[i][2], rectangle[i][3]);
            fill(2*rectangle[i][0], 2*rectangle[i][1], 2*rectangle[i][2], 2*rectangle[i][3]);
        }
        //draw(map);

        answer = bfs(characterX*2, characterY*2, itemX*2, itemY*2);

        return answer;
    }
    public static void main(String strs[]) {
        int [][] rectangle = {{1,1,7,4}, {3,2,5,5}, {4,3,6,9}, {2,6,8,8}};
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;
        System.out.println(solution(rectangle,characterX,characterY,itemX, itemY));
    }
}