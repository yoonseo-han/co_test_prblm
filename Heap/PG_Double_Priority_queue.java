//https://school.programmers.co.kr/learn/courses/30/lessons/42628#

import java.util.*;

public class doubleQueue {
    //낮은 숫자가 우선 순위인 int 형 우선순위 큐 선언
    PriorityQueue<Integer> pqLowest = new PriorityQueue<>();
    //높은 숫자가 우선 순위인 int 형 우선순위 큐 선언
    PriorityQueue<Integer> pqHighest = new PriorityQueue<>(Collections.reverseOrder());
    
    int size=0;
}

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        doubleQueue tempStore = new doubleQueue();
        for(String tempString: operations) {
            //Add number
            if(tempString.charAt(0) == 'I') {
                String[] parseString = tempString.split(" ");
                int numToAdd = Integer.parseInt(parseString[1]);
                tempStore.size++;
                tempStore.pqLowest.offer(numToAdd);
                tempStore.pqHighest.offer(numToAdd);
            }
            //Delete smallest number
            else {
                if(tempStore.size == 0) continue;
                else {
                    if(tempString.equals("D 1")) {
                        tempStore.size--;
                        tempStore.pqHighest.poll();
                    }
                    else {
                        tempStore.size--;
                        tempStore.pqLowest.poll();
                    }
                }
                if(tempStore.size == 0) {
                    tempStore.pqHighest = new PriorityQueue<>(Collections.reverseOrder());
                    tempStore.pqLowest = new PriorityQueue<>();
                }
            }
        }
        if(tempStore.size <= 0) answer = new int[]{0,0};
        else {
            answer[0] = tempStore.pqHighest.poll();
            answer[1] = tempStore.pqLowest.poll();
        }
        
        return answer;
    }
}