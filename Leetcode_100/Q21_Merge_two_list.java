package Leetcode_100;

class Solution {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //Merge the sorted input 2 lists

        //Result list initialize
        ListNode resultList = new ListNode();
        //Head pointer to result list
        ListNode headPointer = resultList;

        while(list1!=null && list2!=null) {
            if(list1.val <= list2.val) {
                resultList.val = list1.val;
                list1 = list1.next;
            }
            else {
                resultList.val = list2.val;
                list2 = list2.next;
            }
            //Generate next list node
            ListNode tempNode = new ListNode();
            resultList.next = tempNode;
            resultList = resultList.next;
        }
        
        //If both list reached end
        if(list1 == null && list2 == null) {
            //Erase last node
            headPointer = null;
            return headPointer;
        }
        //Between the 2 list check the list that has remaining node and add
        //Temp pointer
        ListNode tempPointer = (list1 == null)? list2: list1;
        while(tempPointer!=null){
            resultList.val = tempPointer.val;
            tempPointer = tempPointer.next;

            if(tempPointer!=null) {
                ListNode tempNode = new ListNode();
                resultList.next = tempNode;
                resultList = resultList.next;
            }
        }

        return headPointer;
    }

    public static void main(String strs[]) {
        ListNode list1 = new ListNode(2);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(8);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(7);
        list2.next.next = new ListNode(8);

        ListNode resultList = mergeTwoLists(list1,list2);
        ListNode traverse = resultList;
        while(traverse!=null) {
            System.out.println(traverse.val);
            traverse = traverse.next;
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