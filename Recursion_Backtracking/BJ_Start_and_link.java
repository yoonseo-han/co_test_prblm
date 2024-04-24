//https://www.acmicpc.net/problem/14889

import java.util.Scanner;

public class Main {
    static int [][] S;
    static boolean [] visited;
    static int MIN = Integer.MAX_VALUE;
    static int N;

    public static void getScore() {
        int startScore = 0;
        int linkScore = 0;

        for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				// i 번째 사람과 j 번째 사람이 true라면 스타트팀으로 점수 플러스 
				if (visited[i] == true && visited[j] == true) {
					startScore += S[i][j];
					startScore += S[j][i];
				}
				// i 번째 사람과 j 번째 사람이 false라면 링크팀으로 점수 플러스 
				else if (visited[i] == false && visited[j] == false) {
					linkScore += S[i][j];
					linkScore += S[j][i];
				}
			}
		}

        MIN = Math.min(MIN, Math.abs(startScore - linkScore));

        if (MIN == 0) {
			System.out.println(MIN);
			System.exit(0);
		}
    }

    public static void combination(int curInd, int curPeople) {
        //Base case: If number of people in one team reaches N/2
        if(curPeople == N/2) {
            getScore();
            return;
        }

        else {
            for(int i=curInd; i<N; i++) {
                visited[i] = true;
                combination(curInd+1 , curPeople+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        S = new int[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                S[i][j] = scanner.nextInt();
            }
        }

        visited = new boolean[N];

        combination(0, 0);

        System.out.println(MIN);
    }
}