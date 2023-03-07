package DFS;

import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<String> allRoute; 

    public static void dfs(String start, String route, String[][] ticekts, int cnt) {
        if(cnt == ticekts.length) {
            allRoute.add(route);
            return;
        }
        else {
            for(int i=0; i<ticekts.length; i++) {
                if(start.equals(ticekts[i][0]) && !visited[i]) {
                    visited[i] = true;
                    dfs(ticekts[i][1], route + " " + ticekts[i][1], ticekts, cnt+1);
                    visited[i] = false;
                }
            }
        }
    }

    public static String[] solution(String[][] tickets) {
        String[] answer = {};
        int cnt = 0;
        visited = new boolean[tickets.length];
        allRoute = new ArrayList<>();

        dfs("ICN", "ICN", tickets, cnt);
        Collections.sort(allRoute);
        answer = allRoute.get(0).split(" ");

        return answer;
    }

    public static void main(String strs[]) {
        String[][] inputString = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[] result = solution(inputString);
        for(String i: result) System.out.println(i);
    }
}