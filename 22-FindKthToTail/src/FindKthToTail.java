
class ListNode {
    int val;
    ListNode next = null;
    public ListNode() {}
    public ListNode(int val) {this.val = val;}
}
public class FindKthToTail {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(4);
        ListNode node8 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        int k = 0;
        Solution node = new Solution();
        ListNode listNode = node.getKthFromEnd(node1, k);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null || k <= 0) {return null;}
//方法一  遍历链表，得到节点数
//        ListNode node = head;
//        int NodeOfNumber = 0;
//        while(node != null) {
//            NodeOfNumber++;
//            node = node.next;
//        }
//        node = head;
//        System.out.println(NodeOfNumber);
//        int NodeOfNeed = 0;
//        while(node != null) {
//            NodeOfNeed++;
//            if(NodeOfNumber - k + 1 == NodeOfNeed) {
//                System.out.println("============");
//                return node;
//            }
//            node = node.next;
//        }
//        return head;

        //方法二：快慢指针
//        ListNode fast = head;
//        while(fast!=null) {
//            fast = fast.next;
//            if(k==0) {
//                System.out.println("==========");
//                System.out.println(head.val);
//                System.out.println("==========");
//
//                head = head.next;
//            }else {
//                System.out.println("---------");
//                System.out.println(k);
//                k--;
//            }
//        }
//        return head;
        ListNode frontNode = head;
        ListNode behindNode = head;
        while(frontNode != null && k > 0) {
            frontNode = frontNode.next;
            k--;
        }
        while(frontNode != null) {
            frontNode = frontNode.next;
            behindNode = behindNode.next;
        }
        return behindNode;
    }
}