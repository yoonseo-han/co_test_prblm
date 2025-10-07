import java.util.*;

class Solution {
    // 1️⃣ 지원자 정보 저장용 map: "java#backend#junior#pizza" -> [150, 200, ...]
    Map<String, List<Integer>> scoreMap = new HashMap<>();
    
    // 2️⃣ 각 카테고리별 가능한 값들 (query에서 '-'일 때 사용)
    private String[][] values = {
        {"cpp", "java", "python"},
        {"backend", "frontend"},
        {"junior", "senior"},
        {"chicken", "pizza"}
    };

    // 3️⃣ '-'가 들어왔을 때 모든 가능한 값 반환
    private List<String> getCandidates(int idx) {
        return Arrays.asList(values[idx]);
    }

    // 4️⃣ DFS로 query 조건에서 가능한 모든 key 조합 생성
    private void dfs(int idx, String[] category, String curString, List<String> possibleKeys) {
        if (idx == 4) {
            // 맨 앞에 붙은 '#' 제거
            possibleKeys.add(curString.substring(1));
            return;
        }

        if (category[idx].equals("-")) {
            for (String curCandidate : getCandidates(idx)) {
                dfs(idx + 1, category, curString + "#" + curCandidate, possibleKeys);
            }
        } else {
            dfs(idx + 1, category, curString + "#" + category[idx], possibleKeys);
        }
    }

    // 5️⃣ 외부에서 호출하는 key 생성기
    private List<String> generateKeys(String[] category) {
        List<String> possibleKeys = new ArrayList<>();
        dfs(0, category, "", possibleKeys);
        return possibleKeys;
    }

    // 6️⃣ 직접 구현한 lower bound (target 이상 첫 번째 위치 찾기)
    private int lowerBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 7️⃣ 최종 solution
    public int[] solution(String[] info, String[] query) {
        // ---- info 전처리 ----
        for (String curInfo : info) {
            String[] curArr = curInfo.split(" ");
            String key = String.join("#", curArr[0], curArr[1], curArr[2], curArr[3]);
            int score = Integer.parseInt(curArr[4]);

            scoreMap.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
        }

        // 각 key별 점수 리스트 정렬
        for (List<Integer> scores : scoreMap.values()) {
            Collections.sort(scores);
        }

        // ---- query 처리 ----
        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            // "and" 제거 + 공백 단위 분리
            String temp = query[i].replaceAll(" and ", " ");
            String[] category = temp.split(" ");
            int targetScore = Integer.parseInt(category[4]);

            // 가능한 key 조합 전부 생성
            List<String> possibleKeys = generateKeys(category);

            // 각 key에 대해 점수 기준 필터링
            int count = 0;
            for (String key : possibleKeys) {
                if (!scoreMap.containsKey(key)) continue;
                List<Integer> scores = scoreMap.get(key);
                int idx = lowerBound(scores, targetScore);
                count += scores.size() - idx;
            }

            answer[i] = count;
        }

        return answer;
    }
}