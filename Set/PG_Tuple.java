import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        String newSubstring = s.substring(1, s.length() - 1);
        List<List<Integer>> store = new ArrayList<>();
        int idx = 1;
        int n = s.length();

        while (idx < n) {
            String tempString = "";
            while (newSubstring.charAt(idx) != '}') {
                tempString += newSubstring.charAt(idx++);
            }
            String[] elements = tempString.split(",");
            List<Integer> tempList = new ArrayList<>();
            for (String element : elements) {
                tempList.add(Integer.parseInt(element));
            }
            store.add(tempList);
            idx += 3;
        }

        store.sort((a, b) -> a.size() - b.size());
        Set<Integer> duplicateCheck = new HashSet<>();
        List<Integer> answerStore = new ArrayList<>(); // Preserver order

        for (List<Integer> tempList : store) {
            for (int i : tempList) {
                if (!duplicateCheck.contains(i)) {
                    duplicateCheck.add(i);
                    answerStore.add(i);
                }
            }
        }

        return answerStore.stream().mapToInt(i -> i).toArray();
    }
}