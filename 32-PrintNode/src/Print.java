import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode right;
    TreeNode left;

    TreeNode() {}
    TreeNode(int val) {this.val = val;}
    TreeNode(int val, TreeNode right, TreeNode left) {
        this.val = val;
        this.right = right;
        this.left = left;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            ArrayList<Integer> tmp1 = new ArrayList<>();
            // List<Integer> tmp = new LinkedList<>();      使用ArrayList、List没有addLast、addFirst方法

            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if(res.size() % 2 == 0) tmp.addLast(node.val); // 偶数层 -> 队列头部
                else tmp.addFirst(node.val); // 奇数层 -> 队列尾部

//                if (res.size() == 2) {
//                    for (List<Integer> re : res) {
//                        System.out.println(re);
//                    }
//                }
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}

public class Print {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(8);
        TreeNode node7 = new TreeNode(13);
        TreeNode node8 = new TreeNode(9);

        node1.left = node2;
        node2.left = node3;
        node3.left = node4;
        node4.left = node5;

        node1.right = node6;
        node6.left = node7;
        node6.right = node8;
        TreeNode node12 = null;
        Solution solution = new Solution();
        List<List<Integer>> temp = solution.levelOrder(node12);
        // boolean m = solution.isBalanced(node1);
        for (List<Integer> integers : temp) {
            System.out.println(integers);
        }

    }

}
