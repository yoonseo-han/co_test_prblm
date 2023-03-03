package DFS;

class Solution {
    static int answer = 0;

    public static void dfs(String begin, String target, String[] words, boolean[] visited, int cnt) {
        if(begin.equals(target)) {
            answer = cnt;
            return;
        }

        for(int i=0; i<words.length; i++) {
            if(visited[i]) continue;

            //Count number of letters equal
            int k=0;
            for(int j=0; j<words[i].length(); j++) {
                if(begin.charAt(j) == words[i].charAt(j)) k++;
            }
            if(k == begin.length()-1) {
                visited[i] = true;
                dfs(words[i], target, words, visited, cnt+1);
                visited[i] = false;
            }
        }
    }

    public static int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];

        dfs(begin, target, words, visited, 0);
        return answer;
    }
    public static void main(String strs[]){
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(solution(begin, target, words));
    }
}