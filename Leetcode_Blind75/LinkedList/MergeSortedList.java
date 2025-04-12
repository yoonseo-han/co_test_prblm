import java.util.PriorityQueue;

class Solution {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode rootNode = new ListNode(0);
        ListNode current = rootNode;

        // Priority Queue to track smallest value node's index
        PriorityQueue<ListNode> orderStore = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add head node to PQ
        for (ListNode curHead : lists) {
            if (node != null) {
                orderStore.add(curHead);
            }
        }

        // While heap not empty
        while (!orderStore.isEmpty()) {
            ListNode curSmallestNode = orderStore.poll();
            current.next = curSmallestNode;
            current = current.next;

            if (curSmallestNode.next != null) {
                orderStore.add(curSmallestNode.next);
            }
        }

        return rootNode.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        mergeKLists(lists);
    }
}

// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
