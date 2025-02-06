class Solution {
    public static int solution(int[] money) {
        int answer = 0;
        int n = money.length;

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        // 1st case: Include the first house and dont include last house
        dp1[0] = money[0];
        dp1[1] = Math.max(dp1[0], money[1]);

        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i - 2] + money[i], dp1[i - 1]);
        }

        // 2nd case: Dont include the first house and include last house
        dp2[1] = money[1];

        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 2] + money[i], dp2[i - 1]);
        }

        return Math.max(dp1[n - 2], dp2[n - 1]);
    }

    public static void main(String strs[]) {
        int[] money = { 1, 2, 3, 1 };
        System.out.println(solution(money));
    }
}