import java.util.*;

class TreeNode {
    int val;
    TreeNode next = null;
    TreeNode right;
    TreeNode left;
    public TreeNode() {}
    public TreeNode(int val) {this.val = val;}
}

class Solution {
    private HashMap<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
// 方法一： 效率低
//        执行用时：9 ms, 在所有 Java 提交中击败了17.53%的用户
//        内存消耗：87.1 MB, 在所有 Java 提交中击败了8.99%的用户
//         if (preorder.length == 0 || inorder.length == 0) {
//             return null;
//         }
//         int rootvlaue = preorder[0];
//         int rootindex = 0;
//         int preLength = preorder.length;
//         int inLength = inorder.length;
//         for (int i = 0; i < inorder.length; i++) {
//             if (rootvlaue == inorder[i]) {
//                 rootindex = i;
//                 break;
//             }
//         }
//         TreeNode rootNode = new TreeNode(rootvlaue);
//         rootNode.left = buildTree(Arrays.copyOfRange(preorder, 1, rootindex + 1), Arrays.copyOfRange(inorder, 0, rootindex));
//         rootNode.right = buildTree(Arrays.copyOfRange(preorder, rootindex + 1, preLength), Arrays.copyOfRange(inorder, rootindex + 1, inLength));
//         return rootNode;
//方法二：
//        if (preorder == null || preorder.length == 0) {
//            return null;
//        }
//        TreeNode root = new TreeNode(preorder[0]);
//        // System.out.println(preorder[3]);
//        Deque<TreeNode> stack = new LinkedList<TreeNode>();
//        stack.push(root);
//        int inorderIndex = 0;
//        for (int i = 1; i < preorder.length; i++) {
//            int preorderVal = preorder[i];
//            TreeNode node = stack.peek();
//            if (node.val != inorder[inorderIndex]) {
//                node.left = new TreeNode(preorderVal);
//                stack.push(node.left);
//            } else {
//                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
//                    node = stack.pop();
//                    inorderIndex++;
//                }
//                node.right = new TreeNode(preorderVal);
//                stack.push(node.right);
//            }
//        }
//        return root;
        //方法三
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

        public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
            if (preorder_left > preorder_right) {
                return null;
            }

            // 前序遍历中的第一个节点就是根节点
            int preorder_root = preorder_left;
            // 在中序遍历中定位根节点
            int inorder_root = indexMap.get(preorder[preorder_root]);

            // 先把根节点建立出来
            TreeNode root = new TreeNode(preorder[preorder_root]);
            // 得到左子树中的节点数目
            int size_left_subtree = inorder_root - inorder_left;
            // 递归地构造左子树，并连接到根节点
            // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
            root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
            // 递归地构造右子树，并连接到根节点
            // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
            root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
            return root;
    }
//        public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left,
//                                    int preorder_right, int inorder_left, int inorder_right) {
//            if(preorder_left > preorder_right) {
//                return null;
//            }
//
//            int preorder_root = preorder_left;
//            int inorder_root = indexMap.get(preorder[preorder_root]);
//            TreeNode root = new TreeNode(preorder[preorder_root]);
//            int size_left_subtree = inorder_root -inorder_left;
//
//            root.left = myBuildTree(preorder, inorder, preorder_left + 1,
//                    preorder_left + size_left_subtree, inorder_left, inorder_root -1);
//            root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1,
//                    preorder_right, inorder_root + 1, inorder_right);
//            return root;
//        }
}

public class BinaryTreeNode {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        Solution node = new Solution();
        TreeNode listNode = node.buildTree(preorder, inorder);

        printTree(listNode);
    }
    // 后序遍历递归打印
    private static void printTree(TreeNode list) {
        if(list != null) {
            printTree(list.left);
            printTree(list.right);
            System.out.println(list.val);
        }
    }

}