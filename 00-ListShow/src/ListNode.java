import java.util.ArrayList;

public class ListNode {
    int val;
    ListNode next =null;
    ListNode(int val){
        this.val=val;
    }


    public  static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHead(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }

    public static void test(){
        ListNode ListNode1 = new ListNode(1);
        ListNode ListNode2 = new ListNode(2);
        ListNode ListNode3 = new ListNode(3);
        ListNode ListNode4 = new ListNode(4);
        ListNode ListNode5 = new ListNode(5);
        ListNode1.next=ListNode2;
        ListNode2.next=ListNode3;
        ListNode3.next=ListNode4;
        ListNode4.next=ListNode5;
        System.out.println(ListNode3.val);
        System.out.println("采用递归");
        ArrayList<Integer> ddsfsdf = printListFromTailToHead(ListNode1);

        System.out.println(ddsfsdf);
    }

    public static void main(String[] args) {
        ListNode.test();
    }
}
