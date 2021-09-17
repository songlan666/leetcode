public class DeleteNode {

    public static void main(String[] args) {
        ListNode data = new ListNode(1);
        ListNode data1 = new ListNode(2);
        ListNode data2 = new ListNode(3);
        data.next = data1;
        data1.next = data2;
        int val = 5;
        Solution solution = new Solution();
        ListNode node  = solution.deleteNode(data, val);

        //System.out.println(node.val);
        while(node != null) {
            System.out.println(node.val);
            node = node.next;
        }


    }
}


    class Solution {
        public ListNode deleteNode(ListNode head, int val) {
            //判断头节点是否为空
            if(head == null) {
                return null;
            }
            ListNode deleteNode = head;
            //ListNode previousNode = null;
            //判断删除节点是否为头节点
            if(deleteNode.val == val) {
                return deleteNode.next;
            }
            while(deleteNode.next.val != val && deleteNode.next != null) {
                //previousNode = deleteNode.next;

                deleteNode = deleteNode.next;
                if(deleteNode.next == null) {
                    return head;
                }
            }

            if(deleteNode.next != null) {
                deleteNode.next = deleteNode.next.next;
            }
            return head;
        }
    }
//节点定义
class ListNode {
    //存放数据
    int val;
    //下一个节点
    ListNode next = null;
    //无参构造方法
    public ListNode() {};
    //创建一个有参数构造方法，便于给结点传数据
    public ListNode(int val) {
        this.val = val;
    }
}