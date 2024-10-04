//https://school.programmers.co.kr/learn/courses/30/lessons/42577

import java.util.*;

class Solution {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        Set <String> tempStore = new HashSet<>();

        for(String curString: phone_book) tempStore.add(curString);

        for(String curPhone: phone_book) {
            //Iterate around curString length
            for(int i = 0; i<curPhone.length(); i++) {
                String curString = curPhone.substring(0, i);
                if(tempStore.contains(curString)) return false;
            }
        }

        return answer;
    }
    public static void main(String strs[]) {
        String [] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(solution(phone_book));
    }
}