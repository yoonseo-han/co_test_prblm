//https://school.programmers.co.kr/learn/courses/30/lessons/92334?language=java

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        int[] answer = new int[n];
        //Get report ID and frequency\
        HashMap<String, Integer> tempStore = new HashMap<>();
        HashMap<String, Integer> storeReport = new HashMap<>();
        
        //Remove duplicates
        List<String> curListArr = Arrays.asList(report);
        List<String> listWithoutDuplicates = new ArrayList<>(new HashSet<>(curListArr));
        
        for(String curString : listWithoutDuplicates) {
            String [] tempStringArr = curString.split(" ");
            tempStore.put(tempStringArr[1], tempStore.getOrDefault(tempStringArr[1], 0)+1);
        }
        for(String curString : listWithoutDuplicates) {
            String [] tempStringArr = curString.split(" ");
            if(tempStore.get(tempStringArr[1]) >= k) storeReport.put(tempStringArr[0], storeReport.getOrDefault(tempStringArr[0],0) + 1);
        }
        int i=0;
        for(String curString: id_list) {
            answer[i++] = storeReport.getOrDefault(curString, 0);
        }
        
        return answer;
    }
}