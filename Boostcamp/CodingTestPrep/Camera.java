//https://school.programmers.co.kr/learn/courses/30/lessons/42884

import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        //Sort interms of second element
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int [] o1, int [] o2) {
                //Integer.compare(o1[0], o2[0]);
                return Integer.compare(o1[1], o2[1]);
            }
        });
        int routeInd = 0;
        while(routeInd < routes.length-1) {
            int limitInd = routes[routeInd][1];
            for(int i=routeInd+1; i<routes.length; i++) {
                if(routes[i][0] <= limitInd) {
                    if(i == routes.length-1) routeInd = i;
                    continue;
                }
                else {
                    answer++;
                    routeInd = i;
                    break;
                }
            }
        }
        
        return answer;
    }
}