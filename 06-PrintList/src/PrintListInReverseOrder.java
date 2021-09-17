import java.util.Stack;

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
//方法一
class Solution {
    public  int[] reversePrint(ListNode head) {
//        ListNode node = head;
//        int count = 0;
//        while(node != null) {
//            ++count;
//            node = node.next;
//        }
//        int[] nums = new int[count];
//        node = head;
//        for(int i = count - 1; i >= 0; --i) {
//            nums[i] = node.val;
//            node = node.next;
//        }
//        return nums;
        //方法三：使用栈，和方法一差不多
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        int[] print = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            print[i] = stack.pop();
        }
        return print;
    }
}

//方法二
class Solution1 {
    public static void reversePrint(ListNode head) {
//        ListNode node = head;
//        if(node != null) {
//            if(node.next != null) {
//                reversePrint(node.next);
//            }
//            System.out.println(node.val);
//        }
    }
}

public class PrintListInReverseOrder {

    public static void main(String[] args) {
        ListNode data = new ListNode(3);
        ListNode data1 = new ListNode(2);
        ListNode data2 = new ListNode(1);
        data.next = data1;
        data1.next = data2;
        Solution solution = new Solution();
        int[] temp = solution.reversePrint(data);
        // Solution1.reversePrint(data);
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }
   }
}
