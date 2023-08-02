package Leetcode_100;

class Solution {
    public static int minDistance(String word1, String word2) {
        //Using dynamic programming

        //Def) dp[i,j] = minimum cost (or steps) required to convert first i characters of word1 to first j characters of word2

        //Case 1: word1[i] == word2[j], i.e. the ith the jth character matches.
        //Case 2: word1[i] != word2[j], then we must either insert(), delete or replace, whichever is cheaper

        //Insert = f(i+1, j)
        //Insert a new character after word1 that matches the jth character of word2. So, now have to match the (i+1)th characters of word1 to j characters of word2

        int m = word1.length();
        int n = word2.length();
        
        int[][] cost = new int[m + 1][n + 1];

        //Base case: f(0, k) = f(k, 0) = k
        for(int i = 0; i <= m; i++) cost[i][0] = i;
        for(int i = 1; i <= n; i++) cost[0][i] = i;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(word1.charAt(i) == word2.charAt(j))
                    cost[i + 1][j + 1] = cost[i][j];
                else {
                    int a = cost[i][j];
                    int b = cost[i][j + 1];
                    int c = cost[i + 1][j];
                    cost[i + 1][j + 1] = a < b ? (a < c ? a : c) : (b < c ? b : c);
                    cost[i + 1][j + 1]++;
                }
            }
        }
        return cost[m][n];



        return 0;
    }
    public static void main(String strs[]) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance(word1, word2));
    }
}