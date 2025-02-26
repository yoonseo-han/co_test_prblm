import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int count = 0;
        long sum1 = 0;
        long sum2 = 0;

        Queue<Long> temp1 = new LinkedList<>();
        Queue<Long> temp2 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            temp1.add((long) queue1[i]);
        }
        for (int i = 0; i < queue2.length; i++) {
            sum2 += queue2[i];
            temp2.add((long) queue2[i]);
        }

        if ((sum1 + sum2) % 2 != 0)
            return -1;

        int maxCount = queue1.length * 3;

        while (sum1 != sum2) {
            if (count > maxCount)
                return -1;

            if (sum1 > sum2) {
                long tempNum = temp1.poll();
                temp2.add(tempNum);
                sum1 -= tempNum;
                sum2 += tempNum;
            } else {
                long tempNum = temp2.poll();
                temp1.add(tempNum);
                sum1 += tempNum;
                sum2 -= tempNum;
            }
            count++;
        }

        return count;
    }
}