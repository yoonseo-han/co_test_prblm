import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int n = gems.length;
        List<int[]> storeAns = new ArrayList<>();
        Set<String> storeSet = new HashSet<>();
        Map<String, Integer> trackGem = new HashMap<>();

        for (int i = 0; i < gems.length; i++) {
            storeSet.add(gems[i]);
        }

        // Sliding window
        int leftIdx = 0;
        int rightIdx = 0;
        int totalGem = storeSet.size();

        trackGem.put(gems[0], 1);

        while (true) {
            if (trackGem.size() == totalGem) {
                int length = rightIdx - leftIdx;
                int[] tempAns = new int[] { leftIdx + 1, rightIdx + 1, length };
                storeAns.add(tempAns);
            }

            if (trackGem.size() < totalGem) {
                rightIdx++;
                if (rightIdx == n)
                    break;
                trackGem.put(gems[rightIdx], trackGem.getOrDefault(gems[rightIdx], 0) + 1);
            } else {
                trackGem.put(gems[leftIdx], trackGem.get(gems[leftIdx]) - 1);
                if (trackGem.get(gems[leftIdx]) == 0) {
                    trackGem.remove(gems[leftIdx]);
                }
                leftIdx++;
            }
        }

        storeAns.sort((a, b) -> {
            if (a[2] == b[2])
                return a[0] - b[0];
            else
                return a[2] - b[2];
        });

        return new int[] { storeAns.get(0)[0], storeAns.get(0)[1] };
    }
}