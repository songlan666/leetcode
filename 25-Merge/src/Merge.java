class ListNode {
    int val;
    ListNode next = null;
    public ListNode() {}
    public ListNode(int val) {this.val = val;}
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if(l1 == null) {return l2;}
//        else if(l2 == null) {return l1;}
//        ListNode mergeNode = null;
//        if(l1.val > l2.val) {
//            mergeNode = l2;
//            mergeNode.next = mergeTwoLists(l1, l2.next);
//        }
//        else {
//            mergeNode = l1;
//            mergeNode.next = mergeTwoLists(l1.next,l2);
//        }
//        return mergeNode;

//方法二：迭代
//        ListNode merge = new ListNode();
//        ListNode node = merge;
//        while (l1 != null && l2 != null) {
//            if (l1.val <= l2.val) {
//                node.next = l1;
//                l1 = l1.next;
//            } else {
//                node.next = l2;
//                l2 = l2.next;
//            }
//            node = node.next;
//        }
////        while(pre != null) {
////            System.out.println(pre.val);
////            pre = pre.next;
////        }
//        if (l1 != null) {
//            node.next = l1;
//        }
//        if (l2 != null) {
//            node.next = l2;
//        }
//
//        return merge.next;

        if (l1 == null || l2 == null) return null;

//        ListNode node = null;
        ListNode merge = new ListNode();
        ListNode node = merge;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                node.next = l2;
                l2 = l2.next;
            } else {
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;
        }
        if (l1 == null) node.next = l2;
        if (l2 == null) node.next = l1;
        return merge.next;

    }
}

public class Merge {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(8);
        ListNode node4= new ListNode(12);
        ListNode node15 = new ListNode(5);
        ListNode node16= new ListNode(7);
        ListNode node17 = new ListNode(9);
        ListNode node18 = new ListNode(15);
        node1.next= node2;
        node2.next= node3;
        node3.next= node4;
        // node4.next= node15;
        node15.next= node16;
        node16.next= node17;
        node17.next= node18;
        Solution node = new Solution();
        ListNode listNode = node.mergeTwoLists(node1, node15);
        while(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}