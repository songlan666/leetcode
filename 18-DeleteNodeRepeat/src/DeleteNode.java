class ListNode {
    int val;
    ListNode next = null;
    public ListNode() {}
    public ListNode(int val) {this.val = val;}
}

class Node{
    public ListNode DeleteNodeRepeat(ListNode head) {
        //如果节点只有一个或者为空
        if(head ==null || head.next == null) {
            return head;
        }

        if(head.val == head.next.val) {
            ListNode repeatNode = head.next;
            while(repeatNode != null && repeatNode.val == head.val) {
                repeatNode = repeatNode.next;
                //System.out.println(repeatNode.val);
            }
            System.out.println("===============");
            while(head != null) {
                System.out.println(head.val);
                head = head.next;
            }
            System.out.println("==============");
            return DeleteNodeRepeat(repeatNode);
        }
        else{
            //当前节点不是重复结点，保留当前结点，从下一个结点开始递归
            head.next = DeleteNodeRepeat(head.next);
            return head;
        }
    }
}

public class DeleteNode {
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
        Node node = new Node();
        ListNode listNode = node.DeleteNodeRepeat(node1);
        while(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}