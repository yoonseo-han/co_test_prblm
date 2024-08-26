//https://school.programmers.co.kr/learn/courses/30/lessons/42862?language=java

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int [] tempStore = new int[n];
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        int lostInd = 0;
        for(int i=0; i<reserve.length; i++) {
            tempStore[reserve[i]-1] = 2; 
        }

        for(int i=0; i<n; i++) {
            int curLost = 0;
            if(lostInd<lost.length) curLost = lost[lostInd]-1;
            if(i == curLost) {
                if(tempStore[i] == 2) tempStore[i] = 1;
                else tempStore[i] = 0;
                lostInd++;
            }
            else if (tempStore[i]!=2) tempStore[i] = 1;
        }
        if(tempStore[0]==2 && tempStore[1]==0) {
            tempStore[0] = 1;
            tempStore[1] = 1;
        }
        if(tempStore[n-1]==2 && tempStore[n-2]==0) {
            tempStore[n-1] = 1;
            tempStore[n-2] = 1;
        }
        for(int i=1; i<n-1; i++) {
            if(tempStore[i]==2) {
                if(tempStore[i-1] != 0 && tempStore[i+1] != 0) continue;
                else if(tempStore[i-1] == 0) tempStore[i-1] = 1;
                else if(tempStore[i+1] == 0) tempStore[i+1] = 1;
                tempStore[i] = 1;
            }
        }
        
        for(int i=0; i<n; i++) if(tempStore[i]!=0) answer++;
        
        return answer;
    }
}