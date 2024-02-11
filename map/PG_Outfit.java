//https://school.programmers.co.kr/learn/courses/30/lessons/42578

import java.util.*;

class Solution {
    public static int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> tempStore = new HashMap<>();

        for(int i=0; i<clothes.length; i++) {
            tempStore.put(clothes[i][1], tempStore.getOrDefault(clothes[i][1], 0)+1);
        }
        //Calculate sum
        for(String s : tempStore.keySet()){
            answer *= tempStore.get(s) + 1;
        }
        answer -= 1;

        return answer;
    }
    public static void main(String strs[]) {
        String [][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }
}