package Leetcode_100;

import java.util.*;

class Solution {
    public static long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        int[][] tempStore = new int[n][2];
        for (int i = 0; i < n; ++i)
            tempStore[i] = new int[] {nums2[i], nums1[i]};
        //Sort based on the nums2 size
        Arrays.sort(tempStore, (a, b) -> b[0] - a[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
        long res = 0, sumS = 0;
        for (int[] es : tempStore) {
            pq.add(es[1]);
            sumS = (sumS + es[1]);
            if (pq.size() > k) sumS -= pq.poll();
            if (pq.size() == k) res = Math.max(res, (sumS * es[0]));
        }
        return res;
    }
    public static void main(String strs[]) {
        int [] nums1 = {1,3,3,2};
        int [] nums2 = {2,1,3,4};

        int k = 3;

        System.out.println(maxScore(nums1,nums2,k));
    }
}