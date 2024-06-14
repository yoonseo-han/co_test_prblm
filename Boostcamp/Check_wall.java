//https://school.programmers.co.kr/learn/courses/30/lessons/60062

import java.util.*;

class Solution {
    public void deleteElement(Vector<Integer> weakStore, int startPos, int dist, int n) {
        int lastPos = startPos + dist;
        for(int i = startPos; i < lastPos+1; i++) {
            int ind = i % n;
            weakStore.remove((Integer) ind);
        }
    }
    
    public int returnNumCover(Vector<Integer> weakStore, int dist, int startPos, int n) {
        int lastPos = startPos + dist;
        int count = 0;
        for(int i = startPos; i < lastPos+1; i++) {
            int ind = i % n;
            if(weakStore.contains(ind)) count++;
        }
        return count;
    }
    
    public int solution(int n, int[] weak, int[] dist) {
        int answer = 0;
        Arrays.sort(dist);
        int [] reverseDist = new int[dist.length];
        Vector<Integer> weakStore = new Vector<>();
        for(int i = 0; i < dist.length; i++) reverseDist[i] = dist[dist.length - i - 1];
        for(int i : weak) weakStore.add(i);
        
        int coverDistInd = 0;
        while(!weakStore.isEmpty()) {
            if (coverDistInd >= reverseDist.length) {
                return -1; // Not enough people to cover all weak points
            }
            int coverDist = reverseDist[coverDistInd++];
            int numCover = 0;
            int startPos = 0;
            for(int i = 0; i < n; i++) {
                int currentCover = returnNumCover(weakStore, coverDist, i, n);
                if(currentCover >= numCover) {
                    numCover = currentCover;
                    startPos = i;
                }
            }
            // Remove the selected elements from the startPos
            deleteElement(weakStore, startPos, coverDist, n);
            answer++;
            if(coverDistInd == reverseDist.length && !weakStore.isEmpty()) return -1;
        }
        return answer;
    }
}
