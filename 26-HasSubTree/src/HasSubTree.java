class TreeNode {
    int val;
    TreeNode next = null;
    TreeNode right;
    TreeNode left;
    public TreeNode() {}
    public TreeNode(int val) {this.val = val;}
}


class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean result = false;

        if (A == null || B == null) {
            return result;
        }

        if (A.val == B.val) {
            if(DoesTreeA_HaveTreeB(A, B)) {
                result = true;

                return result;
            }
//            result = DoesTreeA_HaveTreeB(A, B);
//            return result;
//            return DoesTreeA_HaveTreeB(A, B);

        }
        if (!result) {
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
//        if (!result) {

//            return isSubStructure(A.right, B);
//        }

        return result;
    }

    public boolean DoesTreeA_HaveTreeB(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.val != B.val) {
            return false;
        }
        return DoesTreeA_HaveTreeB(A.left, B.left) && DoesTreeA_HaveTreeB(A.right, B.right);
    }

}

public class HasSubTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        //node4.right = node5;
        Solution node = new Solution();
        boolean bool = node.isSubStructure(node1, node6);
        System.out.println(bool);
        // printTree(node1);

    }

//    private static void printTree(TreeNode node) {
//        if(node != null) {
//            System.out.println(node.val);
//            printTree(node.left);
//            printTree(node.right);
//        }
//    }

}