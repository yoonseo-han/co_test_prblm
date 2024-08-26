//https://school.programmers.co.kr/learn/courses/30/lessons/42860?language=java

class Solution {
    public int solution(String name) {
        int answer = 0;
        int [] storeCount = new int[name.length()];
        int zeroCount = 0;
        int move = name.length()-1;
        int len = name.length();
        
        for(int i = 0; i<name.length(); i++) {
            int leftDist = name.charAt(i) - 'A';
            int rightDist = 26 - leftDist;
            int dist = (leftDist > rightDist)? rightDist : leftDist;
            // 연속된 'A'가 끝나는 지점 찾기
            int next = i + 1;
            while(next < len && name.charAt(next) == 'A') {
                next++;
            }
            if(dist == 0) zeroCount = 1;
            storeCount[i] = dist;
            
            // 좌우이동 최소 횟수 구하기 (순서대로 가기 vs 뒤로 돌아가기)
            move = Math.min(move, (i * 2) + len - next);
            move = Math.min(move, (len - next) * 2 + i);
        }
        for(int i : storeCount) answer += i;
        
        return answer+move;
    }
}