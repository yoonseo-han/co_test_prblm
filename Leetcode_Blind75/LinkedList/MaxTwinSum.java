class Solution {
    public int pairSum(ListNode head) {
        int n = 1;
        ListNode curNode = head;

        while (curNode.next != null) {
            n++;
            curNode = curNode.next;
        }

        int[] storeArr = new int[n / 2];
        int idx = 0;
        int max = 0;
        curNode = head;
        while (curNode != null) {
            int curVal = curNode.val;
            if (idx >= n / 2) {
                int tempIdx = n - 1 - idx;
                storeArr[tempIdx] += curVal;
                max = Math.max(max, storeArr[tempIdx]);
            } else {
                storeArr[idx] = curVal;
            }
            idx++;
            curNode = curNode.next;
        }

        return max;
    }
}