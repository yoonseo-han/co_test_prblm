package SDS_test;

import java.util.*;
import java.io.*;

class Solution {

    //Global variable defined for map
    static int[][] map;

    public static void main (String strs[]) while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            System.out.println(str);
        }n {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=TC; tc++) {
            //Define string token: tokenize based on " " (= blank space)
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            map = new int[H][W];

            for(int i=0; i<H; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //Continue
            
        }
    }

}