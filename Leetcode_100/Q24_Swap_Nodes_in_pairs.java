package Leetcode_100;

class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void PrintListNode(ListNode head) {
        ListNode traverseNode = head;
        while(traverseNode!=null) {
            System.out.print(traverseNode.val + " ");
            traverseNode = traverseNode.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        //Initialize dummy head and cur Node for traversal
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode curNode = dummyHead;

        while(curNode.next!=null && curNode.next.next!=null) {
            ListNode firstNode = curNode.next;
            ListNode secondNode = curNode.next.next;

            firstNode.next = secondNode.next;
            curNode.next = secondNode;
            secondNode.next = firstNode;
            curNode = curNode.next.next;
        }

        return dummyHead.next;
    }

    public static void main(String strs[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        head = swapPairs(head);

        PrintListNode(head);
    }
}