import java.util.*;

class Solution {
    public static String getResult(int n, int t, int m, int p) {
        StringBuilder convertedBase = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i <= t * m; i++) {
            convertedBase.append(Integer.toString(i, n));
        }

        for (int i = p - 1; result.length() < t; i += m) {
            result.append(convertedBase.charAt(i));
        }

        return result.toString().toUpperCase();
    }

    public static void main(String[] args) {
        int n = 2;
        int t = 4;
        int m = 2;
        int p = 1;
        System.out.println(getResult(n, t, m, p));
    }
}