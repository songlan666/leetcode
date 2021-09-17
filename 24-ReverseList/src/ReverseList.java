class ListNode {
    int val;
    ListNode next = null;
    public ListNode() {}
    public ListNode(int val) {this.val = val;}
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode reverseList = null;
        ListNode preNode = null;
        ListNode node = head;
        while(node != null) {
            ListNode pNext = node.next;
            if(pNext == null) {
                reverseList = node;
            }
            node.next = preNode;
            preNode = node;
            node = pNext;
        }
        return reverseList;
    }
}

public class ReverseList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4= new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6= new ListNode(4);
        ListNode node7 = new ListNode(4);
        ListNode node8 = new ListNode(5);
        node1.next= node2;
        node2.next= node3;
        node3.next= node4;
        node4.next= node5;
        node5.next= node6;
        node6.next= node7;
        node7.next= node8;
        Solution node = new Solution();
        ListNode listNode = node.reverseList(node1);
        while(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}