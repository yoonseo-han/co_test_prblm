package Leetcode_100;

class Solution {
    public static boolean isMonotonic(int[] A) {
        boolean inc = true, dec = true;
        for (int i = 1; i < A.length; ++i) {
            inc &= A[i - 1] <= A[i];
            dec &= A[i - 1] >= A[i];
        }
        return inc || dec;
    }
    public static void main(String strs[]) {
        int [] nums = {1,2,2,3};
        System.out.println(isMonotonic(nums));
    }
}