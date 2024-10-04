//https://school.programmers.co.kr/learn/courses/30/lessons/43238

class Solution {
    public static long solution(int n, int[] times) {
        long answer = 0;

        int[] remainingTime = new int[times.length];
        while(n > 0) {
            //Calculate process time for each batch
            int [] escapeTime = new int[times.length];
            int curMin = Integer.MAX_VALUE;
            for(int i = 0; i<times.length; i++) {
                escapeTime[i] = times[i] + remainingTime[i];
            }

        }

        return answer;
    }
    public static void main(String strs[]) {
        int n = 6;
        int[] times = [7, 10];
        System.out.println(solution(n, times));
    }
}