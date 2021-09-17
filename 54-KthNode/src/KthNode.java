import java.util.List;

class TreeNode {
//    public static TreeNode left;
//    public static TreeNode right;
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
//    int res, k;
//    public int kthLargest(TreeNode root, int k) {
//        this.k = k;
//        dfs(root);
//        return res;
//    }
//    void dfs(TreeNode root) {
//        if(root == null) return;
//        dfs(root.right);
//        if(k == 0) return;
//        k--;
//        if(k == 0) res = root.val;
//        dfs(root.left);
//    }
//}

class Solution {
    int res,k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        kthLargestCode(root);
        return res;
    }
    public void kthLargestCode(TreeNode root) {
        if (root == null) return;
        if (root.right != null) kthLargestCode(root.right);
        if (k == 0) return;
        k--;
        if (k == 0) res = root.val;
        if (root.left != null) kthLargestCode(root.left);
    }
}

//class Solution {
//
//    public int kthLargest(TreeNode root, int k) {
//        return kthLargestCode(root,k);
//    }
//    public int kthLargestCode(TreeNode root, int k) {
////        int result = 0;
//        if (root == null) return 0;
//        if (root.right != null) kthLargestCode(root.right, k);
////        System.out.println(root.val);
//        k--;
//        System.out.println(root.val);
//        if (k == 0) {
//            System.out.println(root.val);
//            return root.val;
//
//        }
//        if (root.left != null) kthLargestCode(root.left, k);
//        return -1;
//    }
//}

public class KthNode {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(1);


        node1.left = node2;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;

        node1.right = node3;
        Solution solution = new Solution();
         int m = solution.kthLargest(node1, 2);
//        TreeNode m = solution.kthLargest(node1, 3);
        // boolean m = solution.isBalanced(node1);
         System.out.println(m);

    }
}
