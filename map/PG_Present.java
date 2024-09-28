//https://school.programmers.co.kr/learn/courses/30/lessons/258712?language=java

import java.util.*;

class Solution {
    public static int calculateScore(int[][] storePresent, int ID) {
        int score = 0;
        for(int i=0; i<storePresent.length; i++) {
            score += storePresent[ID][i];
            score -= storePresent[i][ID];
        }
        return score;
    }
    public static int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int N = friends.length;
        HashMap<String, Integer> storeOrder = new HashMap<String, Integer>();
        int [] storeScore = new int[N];
        int [][] storePresent = new int[N+1][N+1];

        for(int i = 0; i<N; i++) {
            storeOrder.put(friends[i], i);
        }

        for(int i = 0; i<gifts.length; i++) {
            String presenterName = gifts[i].split(" ")[0];
            String receiverName = gifts[i].split(" ")[1];

            int presenterID = storeOrder.get(presenterName);
            int receiverID = storeOrder.get(receiverName);

            storePresent[presenterID][receiverID]++;
        }

        for(int i = 0; i<N; i++) {
            for(int j = i+1; j<N; j++) {
                if(storePresent[i][j] == storePresent[j][i]) {
                    int iScore = calculateScore(storePresent, i);
                    int jScore = calculateScore(storePresent, j);
                    if(iScore == jScore) continue;
                    else if(iScore > jScore){
                        storeScore[i]++;
                    } else {
                        storeScore[j]++;
                    }
                } else if(storePresent[i][j] > storePresent[j][i]){
                    storeScore[i]++;
                } else {
                    storeScore[j]++;
                }
                answer = Math.max(answer, Math.max(storeScore[i], storeScore[j]));
            }
        }

        return answer;
    }
    public static void main(String strs[]) {
        String [] friends = {"muzi", "ryan", "frodo", "neo"};
        String [] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        System.out.println(solution(friends, gifts));
    }
}