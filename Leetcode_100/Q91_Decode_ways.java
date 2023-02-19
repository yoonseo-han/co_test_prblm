package Leetcode_100;

class Solution {
    public static int numDecodings(String s) {
        //Edge cases
        if(s == null || s.length() == 0) return 0;
        if(s.charAt(0) == '0') return 0;

        //Define dp
        int n = s.length();
        int [] dp = new int[n+1];

        //Base cases
        dp[0] = 1;
        dp[1] = (s.charAt(0) != 0)? 1:0;

        //Recursive cases
        for(int i=2; i<=n; i++) {
            int curInt = s.charAt(i-1) - '0';
            int prevInt = s.charAt(i-2) - '0';
            int tempNum = (prevInt*10) + curInt;

            if(curInt >=1 && curInt<=9) dp[i] += dp[i-1];
            if(tempNum>=10 && tempNum <=26) dp[i] += dp[i-2];
        }

        return dp[n];
    }

    public static void main(String strs[]) {
        String inputString = "226";
        System.out.println(numDecodings(inputString));
    }
}