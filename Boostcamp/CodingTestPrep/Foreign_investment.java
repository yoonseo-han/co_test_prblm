//https://level.goorm.io/exam/150257/00%EC%A6%9D%EA%B6%8C-%EC%A3%BC%EC%8B%9D%ED%88%AC%EC%9E%90%EC%9E%90-a/quiz/1

import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [][] answer = new int[N][2];
		//HashMap<Integer,Integer> tempStore = new HashMap<>();
		for(int i=0; i<N; i++) {
			double curVal = sc.nextDouble();
			double numStock = sc.nextDouble();
			
			int finalVal = (int) (curVal * numStock * 10);
			
			answer[i][0] = finalVal;
			answer[i][1] = i+1;
		}
		Arrays.sort(answer, (a, b) -> {
				if(a[0] == b[0]) return Integer.compare(a[1], b[1]);
				return Integer.compare(b[0], a[0]); // Descending order
		});

		for(int[] i:answer) System.out.print(i[1] + " ");
	}
}