/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static void reorderList(ListNode head) {
        // Step 1: Find the middle of the list
        ListNode slowPtr = head;
        ListNode secondPtr = head;

        while (secondPtr != null && secondPtr.next != null) {
            secondPtr = secondPtr.next.next;
            slowPtr = slowPtr.next;
        }

        // Step 2: Reverse the second half's list
        ListNode prevNode = null;
        ListNode curNode = slowPtr.next;
        slowPtr.next = null; // To be able to break the link between first and second half

        while (curNode != null) {
            ListNode nextNode = curNode.next;

            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }

        // Step 3: Merge the two lists
        ListNode firstPtr = head;
        ListNode secondPtr = prevNode;

        while (secondPtr != null) {
            ListNode temp1 = firstPtr.next;
            ListNode temp2 = secondPtr.next;

            firstPtr.next = secondPtr;
            secondPtr.next = temp1;

            firstPtr = temp1;
            secondPtr = temp2;
        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);

        reorderList(root);
        ListNode curNode = root;
        while (curNode != null) {
            System.out.println(curNode.val);
            curNode = curNode.next;
        }
    }
}

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
        this.val = 0;
        this.next = null;
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}