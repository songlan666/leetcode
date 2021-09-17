import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode next = null;
    TreeNode random = null;
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
//        this.next =null;
//        this.random = null;
    }
}

class Solution {
    public TreeNode copyRandomList(TreeNode head) {
        if(head == null) return null;
        TreeNode cur = head;
        Map<TreeNode, TreeNode> map = new HashMap<>();
        // 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        while(cur != null) {
            map.put(cur, new TreeNode(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 4. 构建新链表的 next 和 random 指向
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 5. 返回新链表的头节点
        return map.get(head);
    }
}

public class Clone {
    public static void main(String[] args) {

    }
}
