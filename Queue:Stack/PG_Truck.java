//https://school.programmers.co.kr/learn/courses/30/lessons/42583?language=java

import java.util.*;

class Solution {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int sum = 0;

        Queue<Integer> tempStore = new LinkedList<>();

        for(int i = 0; i<truck_weights.length; i++ ) {
            while(true) {
                //Get weight of cur truck
                int curTruck = truck_weights[i];
                //Case where queue is empty: Add new truck
                if(tempStore.isEmpty()) {
                    tempStore.add(curTruck);
                    time++;
                    sum+= curTruck;
                    break;
                }
                //Case where queue is full: pop the upfront value
                else if(tempStore.size() == bridge_length) {
                    sum -= tempStore.poll();
                }
                //Now try to add new truck
                if(sum+curTruck <= weight) { //Following case: Able to add new truck in bridge
                    tempStore.add(curTruck);
                    time++;
                    sum+= curTruck;
                    break;
                }
                //Following case: not able to add new truck: hence add 0
                else {
                    tempStore.add(0);
                    time++;
                }
            }
        }

        //Last truck has to pass the bridge length
        return time + bridge_length;
    }
    public static void main(String strs[]) {
        int bridge_length = 2;
        int weight = 10;
        int [] truck_weights = {7,4,5,6};
        System.out.println(solution(bridge_length, weight, truck_weights));
    }
}