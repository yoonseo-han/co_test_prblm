package Leetcode_100;

import java.util.ArrayList;
import java.util.List;

class Solution{
    public static void dfs(List<List<String>> resultList, List<String> tempString, boolean[][] dp, String s, int iterator ) {
        if(iterator == s.length()) resultList.add(new ArrayList<>(tempString));
        else {
            for(int i=iterator; i<s.length(); i++) {
                if(dp[iterator][i]) {
                    tempString.add(s.substring(iterator, i+1));
                    dfs(resultList, tempString, dp, s, i+1);
                    //Clean all string saved in list
                    tempString.remove(tempString.size()-1);
                }
                
            }
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> resultList = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];

        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                }
            }
        }

        dfs(resultList, new ArrayList<>(), dp, s, 0);

        return resultList;
    }  

    public static void main(String strs[]) {
        String inputString = "cbbbcc";

        List<List<String>> resultList = new ArrayList<>();
        resultList = partition(inputString);
        for(List<String> list: resultList) {
            for(String tempString: list) {
                System.out.print(tempString + ",");
            }
            System.out.println();
        }
    }
}