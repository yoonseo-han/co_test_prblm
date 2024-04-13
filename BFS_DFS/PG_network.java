package DFS;

class Solution {
    public static boolean[] dfs(int[][] computers, int i, boolean[] check) {
        check[i] = true;

        for(int j=0; j<computers.length; j++) {
            //Check thee connectivity between 2 computers (2 computers are not equal)
            if(i!=j && computers[i][j] == 1 && check[j] == false) {
                check = dfs(computers, j, check);
            }
        }

        return check;
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        //Record connectivity: Number of computers for the size of boolean array
        boolean [] check = new boolean[n];

        for(int i=0; i<n; i++) {
            if(!check[i]) {
                dfs(computers, i, check);
                answer++;
            }
        }
        
        return answer;
    }

    public static void main(String strs[]) {
        int [][] inputArray = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        for(int i=0; i<inputArray.length; i++) {
            for(int j=0; j<inputArray[i].length; j++) {
                System.out.print(inputArray[i][j] + " " );
            }
            System.out.println();
        }
        int n = 3;

        System.out.println(solution(n ,inputArray));
    }
}