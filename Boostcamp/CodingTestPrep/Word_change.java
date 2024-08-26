//https://school.programmers.co.kr/learn/courses/30/lessons/43163?language=java

import java.util.*;

class Solution {
    boolean[] visited;
    int minVal = Integer.MAX_VALUE;
    
    public boolean canTransform(String firstString, String secondString) {
        int count = 0;
        for(int i = 0; i < firstString.length(); i++) {
            if(firstString.charAt(i) != secondString.charAt(i)) count++;
        }
        return count == 1;
    }
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        int answer = dfs(begin, target, words, 0);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    public int dfs(String curWord, String target, String[] words, int curLen) {
        if(curWord.equals(target)) return curLen;
        
        for (int i = 0; i < words.length; i++) { 
            if (!visited[i] && canTransform(curWord, words[i])) {
                visited[i] = true;
                int result = dfs(words[i], target, words, curLen + 1);
                visited[i] = false;
                if (result != Integer.MAX_VALUE) {
                    minVal = Math.min(minVal, result);
                }
            }
        }
        
        return minVal;
    }
}
