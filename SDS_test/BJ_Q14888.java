//https://www.acmicpc.net/problem/14888

package SDS_test;

import java.util.*;

class Solution {
    public static int MAX = Integer.MIN_VALUE;	// 최댓값 
	public static int MIN = Integer.MAX_VALUE;	// 최솟값 
	public static int[] operator = new int[4];	// 연산자 개수 
	public static int[] number;					// 숫자 
	public static int N;						// 숫자 개수 

    public static void dfs(int curNum,  int idx){
        if(idx == N) {
            MAX = Math.max(MAX, curNum);
            MIN = Math.min(MIN, curNum);
            return;
        }
        for(int i=0; i<4; i++) {
            if(operator[i] > 0) {
                // 해당 연산자를 1 감소시킨다.
                operator[i]--;
                    
                switch (i) {
                    case 0 : dfs(curNum + number[idx], idx + 1); break;
                    case 1 : dfs(curNum - number[idx], idx + 1); break; 
                    case 2 : dfs(curNum * number[idx], idx + 1); break;
                    case 3 : dfs(curNum / number[idx], idx + 1); break;
                }
                // 재귀호출이 종료되면 다시 해당 연산자 개수를 복구한다.
                operator[i]++;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        number = new int[N];

        for(int i=0; i<N; i++) arr[i] = scanner.nextInt();
        for(int i=0; i<4; i++) operator[i] = scanner.nextInt();

        dfs(number[0], 1);

		System.out.println(MAX);
		System.out.println(MIN);
    }
}