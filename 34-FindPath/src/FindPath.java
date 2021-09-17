import java.util.LinkedList;
import java.util.List;

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
    LinkedList<List<Integer>>  res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
//        if (root == null) return null;
//        path.add(root.val);
//        sum -= root.val;
//        if (sum == 0 && root.left == null && root.right == null) {
//            res.add(new LinkedList<>(path));
//        }
//        pathSum(root.left,sum);
//        pathSum(root.right,sum);
//        path.removeLast();
//        return res;
//    }
        recur(root, sum);
        return res;
    }
    void recur(TreeNode root, int tar) {
        if (root == null) return;
        path.add(root.val);
        tar -= root.val;
        if (tar == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<>(path));
        }
        recur(root.left,tar);
        recur(root.right,tar);
        path.removeLast();
    }
}

public class FindPath {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(8);
        TreeNode node7 = new TreeNode(13);
        TreeNode node8 = new TreeNode(4);
        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(1);
        node1.left = node2;
        node2.left = node3;
        node3.left = node4;
        node3.right = node5;
        node1.right = node6;
        node6.left = node7;
        node6.right = node8;
        node8.left = node9;
        node8.right = node10;
        Solution solution = new Solution();
        List<List<Integer>> linkedList = solution.pathSum(node1, 22);
        for (List<Integer> integers : linkedList) {
            System.out.println(integers);
        }
    }
}
