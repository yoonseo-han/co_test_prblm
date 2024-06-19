//https://school.programmers.co.kr/learn/courses/30/lessons/118668?language=java

import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        
        int goal_alp = 0;
        int goal_cop = 0;
        for(int [] curArr : problems) {
            goal_alp = Math.max(goal_alp, curArr[0]);
            goal_cop = Math.max(goal_cop, curArr[1]);
        }
        //Alreach achieved goal
        if(goal_alp <= alp && goal_cop <= cop) return 0;
        
        if(goal_alp <= alp) alp = goal_alp;
        if(goal_cop <= cop) cop = goal_cop;
        
        int [][] dp = new int[goal_alp+2][goal_cop+2];
        
        for(int i=alp;i<=goal_alp;i++){
            for(int j=cop;j<=goal_cop;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        dp[alp][cop]=0;
        
        for(int i=alp;i<=goal_alp;i++){
            for(int j=cop;j<=goal_cop;j++){
                
                dp[i+1][j]=Math.min(dp[i+1][j],dp[i][j]+1);
                
                dp[i][j+1]=Math.min(dp[i][j+1],dp[i][j]+1);
                
                for(int[] p :problems){
                    //Select the ones with lower quality requirements
                    if(i>=p[0]&&j>=p[1]){
                        if(i+p[2]>goal_alp&&j+p[3]>goal_cop){
                            dp[goal_alp][goal_cop]=Math.min(dp[goal_alp][goal_cop],dp[i][j]+p[4]);
                        }
                        else if(i+p[2]>goal_alp){
                            dp[goal_alp][j+p[3]]=Math.min(dp[goal_alp][j+p[3]],dp[i][j]+p[4]);
                        }
                        else if(j+p[3]>goal_cop){
                            dp[i+p[2]][goal_cop]=Math.min(dp[i+p[2]][goal_cop],dp[i][j]+p[4]);
                        }
                        else if(i+p[2]<=goal_alp&&j+p[3]<=goal_cop){
                            dp[i+p[2]][j+p[3]]=Math.min(dp[i+p[2]][j+p[3]],dp[i][j]+p[4]); 
                        }
                    }
                }
            }
        }
        
        return dp[goal_alp][goal_cop];
    }
}