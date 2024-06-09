//https://school.programmers.co.kr/learn/courses/30/lessons/92335

import java.util.*;

class Solution {
    public void getDecimal(int n, int k, Stack<Integer> tempStore) {
        while(n/k != 0) {
            tempStore.add(n%k);
            n = n/k;
        }
        tempStore.add(n);
    }
    public boolean isPrime(long n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {			// n의 제곱근까지 나누기
            if (n % i == 0) return false;
        }
        return true;
    }
    
    public int solution(int n, int k) {
        int answer = 0;
        
        Stack<Integer> tempStore = new Stack<Integer>();
        getDecimal(n,k,tempStore);
        Vector<Long> finalStore = new Vector<Long>();
        
        long curNum = 0;
        while(!tempStore.isEmpty()) {
            int getNum = tempStore.pop();
            if(getNum == 0) {
                if(curNum!=0) finalStore.add(curNum);
                curNum = 0;
            }
            else curNum = (curNum*10) + getNum;
        }
        if(curNum!=0) finalStore.add(curNum);
        
        for(long i: finalStore) {
            if(isPrime(i)) answer++;
        }
        
        return answer;
    }
}