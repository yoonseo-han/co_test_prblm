//https://school.programmers.co.kr/learn/courses/30/lessons/43163

package DFS;

class Solution {
    static int min = Integer.MAX_VALUE;

    public static boolean canTransform(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        int differences = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                differences++;
                if (differences > 1) return false;
            }
        }
        return differences == 1;
    }

    public static void dfs(String curWord, String target, String[] words, boolean[] visited, int depth) {
        if(curWord.equals(target)) {
            min = Math.min(min, depth);
            return;
        }
        for(int i = 0; i<words.length; i++) {
            if (!visited[i] && canTransform(curWord, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, visited, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean [] visited = new boolean[words.length];

        dfs(begin, target, words, visited, 0);

        return (min==Integer.MAX_VALUE)? 0 : min;
    }
    public static void main(String strs[]){
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log"};

        System.out.println(solution(begin, target, words));
    }
}