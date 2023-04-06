package SDS_test;

import java.util.*;
import java.io.*;

class Solution {
	static int N, K, l;
	static HashSet<String> hs;
	public static void main(String[] args) throws IOException {
        //Buffer reader: Used to store system input into buffer
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Seperate the input into string tokens
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
            //
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 숫자의 개수
			K = Integer.parseInt(st.nextToken()); // 순서
			l = N/4; // 자를 문자의 개수 
			hs = new HashSet();
			
			String s = br.readLine(); 
			
			// l 개씩 짤라서 중복을 허락하지 않고 HashSet에 삽입하는 함수.
			input(s);
			
			String s1 = s;
			String s2 = null;
			
			while(true) {
				s2 = s1.charAt(s1.length()-1) + s1.substring(0, s1.length()-1);
				if(s2.equals(s)) break;
				else {
					input(s2);
					s1 = s2;
				}
			}
			
			List list = new ArrayList(hs);
            // 역순 정렬
            // Collections.sort(list, Comparator.reverseOrder());
			Collections.sort(list);

			Long answer = Long.parseLong((String)list.get(list.size()-K), 16);
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	public static void input(String data) {
		for(int i=0; i<data.length()-l+1; i+=l) {
			hs.add(data.substring(i, i+l));
		}
	}
}