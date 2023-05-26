package Leetcode_100;

class Solution {
    public static String reverseStr(String s, int k) {
        //Convert string to char array
        char[] arr = s.toCharArray();
        int idx = 0;
        int n = s.length();

        while(idx<n) {
            int j = Math.min(idx+k-1, n-1);
            reverse(arr, idx, j);
            idx += (k*2);
        }
        return String.valueOf(arr);
    }

    public static void reverse(char [] arr, int l, int r) {
        while(l<r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }
    public static void main(String strs[]) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(s,k));
    }
}