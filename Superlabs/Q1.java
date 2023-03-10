package Superlabs;

import java.util.*;

class Solution {
    public static String[] solution(String[] teamIDs, String[] additional) {
        String[] answer;

        HashMap<String, Integer> store = new HashMap<>();
        int cnt = 0;
        //Add all teamID into hashset
        for(int i=0; i<teamIDs.length; i++) {
            store.put(teamIDs[i], -1);
        }

        //Add additional in order
        for(int i=0; i<additional.length; i++) {
            if(store.containsKey(additional[i])) continue;
            else {
                store.put(additional[i], cnt++);
            }
        }

        //Convert hashmap to string[]
        answer = new String[cnt];

        for(String i: store.keySet()) {
            if(store.get(i) == -1) continue;
            answer[store.get(i)] = i;
        }

        return answer;
    }

    public static void main(String strs[]) {
        String [] teamID = {"world", "prog"};
        String [] additional = {"hello", "world", "try", "code", "hello"};

        String [] result = solution(teamID, additional);
        for(String i: result) System.out.println(i);
    }
}