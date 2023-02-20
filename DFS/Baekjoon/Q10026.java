package DFS.Baekjoon;

import java.util.Scanner;

class Solution {
    static boolean visited[][];
    static int di[] = {-1,0,0,1};
    static int dj[] = {0,1,-1,0};

    public static void dfs(char[][] storeRGB, int i, int j) {
        visited[i][j]=true;
        char rootChar = storeRGB[i][j];
        int size = storeRGB.length;

        for(int k=0; k<4; k++) {
            int new_i = i + di[k];
            int new_j = j + dj[k];

            //When new index is out of ragne
            if(new_i<0 || new_j < 0 || new_i > size || new_j > size ) continue;

            if(!visited[new_i][new_j] && storeRGB[new_i][new_j] == rootChar) dfs(storeRGB, new_i, new_j);
        }
    }

    public static void main(String strs[]) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();

        //Define 2D array
        char[][] storeRGB = new char[size+1][size+1];
        visited = new boolean[size+1][size+1];

        //Store input
        for(int i=0; i<size; i++) {
            String tempString = input.next();
            for(int j=0; j<size; j++) {
                storeRGB[i][j] = tempString.charAt(j);
            }
        }

        //Process DFS for first case
        int count1 = 0;
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(visited[i][j]==false) {
                    dfs(storeRGB, i, j);
                    count1++;
                }
            }
        }
        System.out.println(count1);

        //For second case, transfer All R to G
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(storeRGB[i][j] == 'G') storeRGB[i][j]='R';
                visited[i][j]=false;
            }
        }
        int count2 = 0;
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(visited[i][j]==false) {
                    dfs(storeRGB, i, j);
                    count2++;
                }
            }
        }
        System.out.println(count2);

    }
}