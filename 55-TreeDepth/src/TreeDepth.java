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
    public boolean maxDepth(TreeNode root) {

        int depth = 0;
        return isBalanced(root, depth);
    }

    public boolean isBalanced(TreeNode root, int depth) {
        if (root == null) {
//            depth = 0;
            return true;
        }
        int nLeft = 0;
        int nRight = 0;
        if (isBalanced(root.left, nLeft) && isBalanced(root.right, nRight)) {
            int diff = nRight - nLeft;
            if (diff < 1 && diff > -1) {
//                depth = 1 + ((nLeft > nRight) ? nLeft : nRight);
                return true;
            }
        }
        return false;
    }
}

//class Solution {
//    public boolean isBalanced(TreeNode root) {
//        return recur(root) != -1;
//    }
//
//    private int recur(TreeNode root) {
//        if (root == null) return 0;
//        int left = recur(root.left);
//        if(left == -1) return -1;
//        int right = recur(root.right);
//        if(right == -1) return -1;
//        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
//    }
//}

public class TreeDepth {
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
        boolean m = solution.maxDepth(node1);
        // boolean m = solution.isBalanced(node1);
        System.out.println(m);
    }
}
