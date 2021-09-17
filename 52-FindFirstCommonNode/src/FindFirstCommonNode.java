class ListNode {
    int val;
    ListNode next = null;
    public ListNode() {}
    public ListNode(int val) {this.val = val;}
}

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //方法一
        if(headA == null || headB == null) return null;
        ListNode n1 = headA;
        ListNode n2 = headB;

        while (n1 != n2){
            n1 = n1 == null ? headB : n1.next;

            n2 = n2 == null ? headA : n2.next;
        }
        return n1;
        //方法二：
//        if(headA == null || headB == null) { return null; }
//        int headALength = getListLength(headA);
//        int headBLength = getListLength(headB);
//        int headDiff = headALength - headBLength;
//        ListNode ListHeadLong = headA;
//        ListNode ListHeadShort = headB;
//        if(headALength < headBLength) {
//            headDiff = headBLength - headALength;
//            ListHeadLong = headB;
//            ListHeadShort = headA;
//        }
////        System.out.println(headDiff);
////        System.out.println(headALength);
//
//        for(int i = 0; i < headDiff; i++) {
//            ListHeadLong = ListHeadLong.next;
//        }
//        //System.out.println(ListHeadLong.val);
//
//        while(ListHeadLong != null && ListHeadShort != null && ListHeadShort != ListHeadLong) {
//            ListHeadLong = ListHeadLong.next;
//            ListHeadShort = ListHeadShort.next;
//
//        }
//        ListNode FirstCommonNode = ListHeadLong;
//        return FirstCommonNode;
//
//    }
//
//    private int getListLength(ListNode list) {
//        ListNode head = list;
//        int nodeOfNumber = 0;
//        while(head != null) {
//            nodeOfNumber++;
//            head = head.next;
//        }
//        return nodeOfNumber;
    }

}

public class FindFirstCommonNode {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(12);
        ListNode node4= new ListNode(13);
        ListNode node15 = new ListNode(5);
        ListNode node16= new ListNode(7);
        ListNode node17 = new ListNode(8);
        ListNode node18 = new ListNode(12);
        ListNode node19 = new ListNode(13);
        node1.next= node2;
        node2.next= node3;
        node3.next= node4;
//        node4.next= node15;
        node15.next= node16;
        node16.next= node17;
        node17.next= node3;
        node18.next = node4;
        Solution node = new Solution();
        ListNode listNode = node.getIntersectionNode(node1, node15);
        while(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}