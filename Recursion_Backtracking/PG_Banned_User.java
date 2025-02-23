import java.util.*;

class Solution {
    boolean[] visited;
    HashSet<HashSet<String>> result = new HashSet<>();

    public boolean check(String user_id, String banned_id) {
        if (user_id.length() != banned_id.length()) {
            return false;
        }

        for (int i = 0; i < user_id.length(); i++) {
            if (banned_id.charAt(i) == '*')
                continue;

            if (user_id.charAt(i) != banned_id.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public void dfs(String[] user_id, String[] banned_id, int depth, HashSet<String> curSet) {
        if (curSet.size() == banned_id.length) {
            result.add(new HashSet<>(curSet));
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (check(user_id[i], banned_id[depth]) && !visited[i]) {
                visited[i] = true;
                curSet.add(user_id[i]);
                dfs(user_id, banned_id, depth + 1, curSet);
                curSet.remove(user_id[i]);
                visited[i] = false;
            }
        }
    }

    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        int depth = banned_id.length;

        dfs(user_id, banned_id, 0, new HashSet<>() {
        });

        return result.size();
    }
}