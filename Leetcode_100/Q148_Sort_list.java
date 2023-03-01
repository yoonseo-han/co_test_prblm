package Leetcode_100;

class Solution {
    public static ListNode merge(ListNode leftHead, ListNode rightHead) {
        ListNode tempHead = new ListNode(0);
        ListNode iterator = tempHead;

        while(leftHead!=null && rightHead!=null) {
            if(leftHead.val < rightHead.val) {
                iterator.next = leftHead;
                leftHead = leftHead.next;
            }
            else {
                iterator.next = rightHead;
                rightHead = rightHead.next;
            }
            iterator = iterator.next;
        }
        if(leftHead !=null) iterator.next = leftHead;
        if(rightHead !=null) iterator.next = rightHead;

        return tempHead.next;
    }

    public static ListNode sortList(ListNode head) {
        //Sort list nodes: Using merge sort

        //Base case
        if(head == null || head.next == null) return head;

        //Split list into 2
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast!=null && fast.next!=null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        //Sort left and right side recursively
        ListNode leftHead = sortList(head);
        ListNode rightHead = sortList(slow);

        return merge(leftHead, rightHead);
    }

    public static void main(String strs[]) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        sortList(head);
        ListNode iterator = head;
        while(iterator !=null) {
            System.out.println(iterator.val);
            iterator = iterator.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}