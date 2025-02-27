import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> ansStore = new ArrayList<>();
        Map<String, Integer> tempStore = new HashMap<>();

        // 1. 사전 초기화 (A-Z)
        for (int i = 0; i < 26; i++) {
            tempStore.put(String.valueOf((char) ('A' + i)), i + 1);
        }

        int maxValue = 26;
        int idx = 0;

        while (idx < msg.length()) {
            String w = String.valueOf(msg.charAt(idx));
            int i = idx + 1;

            // 사전에 있는 가장 긴 문자열을 찾는다
            while (i < msg.length() && tempStore.containsKey(w + msg.charAt(i))) {
                w += msg.charAt(i);
                i++;
            }

            // 현재 문자열의 색인 번호 출력
            ansStore.add(tempStore.get(w));

            // 다음 글자가 있다면 새로운 단어를 사전에 추가
            if (i < msg.length()) {
                tempStore.put(w + msg.charAt(i), ++maxValue);
            }

            idx += w.length();
        }

        return ansStore.stream().mapToInt(Integer::intValue).toArray();
    }
}