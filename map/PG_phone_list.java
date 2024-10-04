//https://school.programmers.co.kr/learn/courses/30/lessons/42577

import java.util.*;

class Solution {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book, (a,b) -> {
            return a.length() - b.length();
        });
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                if (phone_book[j].startsWith(phone_book[i])) {
                    return false;
                }
            }
        }

        return answer;
    }
    public static void main(String strs[]) {
        String [] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(solution(phone_book));
    }
}