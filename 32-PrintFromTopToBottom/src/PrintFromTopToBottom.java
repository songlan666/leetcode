import java.util.ArrayList;
import java.util.LinkedList;
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

//class Solution {
//    public int[] levelOrder(TreeNode root) {
//        if(root == null) return new int[0];
//        Queue<TreeNode> queue = new LinkedList<>(){{ add(root); }};
//        ArrayList<Integer> ans = new ArrayList<>();
//        while(!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            ans.add(node.val);
//            if(node.left != null) queue.add(node.left);
//            if(node.right != null) queue.add(node.right);
//        }
//        int[] res = new int[ans.size()];
//        for(int i = 0; i < ans.size(); i++)
//            res[i] = ans.get(i);
//        return res;
//    }
//}
class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> que = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        que.add(root);
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            arr.add(node.val);
            if (node.left != null) que.add(node.left);
            if (node.right != null) que.add(node.right);
        }
        int[] index = new int[arr.size()];
        for (int i = 0; i < index.length; i++) {
            index[i] = arr.get(i);
        }
        return index;
    }
}
public class PrintFromTopToBottom {
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

        Solution solution = new Solution();
        int[] temp = solution.levelOrder(node1);
        // boolean m = solution.isBalanced(node1);
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }
        int[] a = new int[5];
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

}
