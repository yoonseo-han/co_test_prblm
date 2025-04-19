package DFS;

import java.util.*;

class Solution {
    static Map<String, ArrayList<String>> mapStore = new ArrayList<>();
    static List<String> result = new ArrayList<>();
    static int N;

    public static boolean dfs(String curPos, List<String> path) {
        if (path.size() == N + 1) {
            result.add(new ArrayList<>(path));
            return true;
        }

        // Iterate over the possible values it can have
        List<String> curDestinations = mapStore.get(curPos);

        for (int i = 0; i < curDestinations.size(); i++) {
            String nextDest = curDestinations.get(i);

            // Remove the map for now
            curDestinations.remove(i);
            path.add(nextDest);

            if (dfs(nextDest, path))
                return true;

            // Remove it from path and add it back to map
            curDestinations.add(i, next);
            path.remove(path.size() - 1);
        }
    }

    public static String[] solution(String[][] tickets) {
        Map<String, ArrayList<String>> mapStore = new ArrayList<>();
        N = tickets.length;

        for (String[] curString : tickets) {
            mapStore.putIfAbsent(curString[0], new ArrayList<>());
            mapStore.get(curString[0]).add(curString[1]);
        }

        // Sort each destination list lexicographically to ensure that path always
        // follow alphabetical order
        for (List<String> curVal : mapStore.values()) {
            Collections.sort(curVal);
        }

        // Start dfs
        List<String> path = new ArrayList<>();
        path.add("ICN");
        dfs("ICN", path);

        return path.toArray(new String[0]);
    }

    public static void main(String strs[]) {
        String[][] inputString = { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } };
        String[] result = solution(inputString);
        for (String i : result)
            System.out.println(i);
    }
}