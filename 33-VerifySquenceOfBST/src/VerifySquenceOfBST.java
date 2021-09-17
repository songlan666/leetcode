import java.util.Arrays;
import java.util.Stack;

public class VerifySquenceOfBST {
    public static void main(String[] args) {
        int[] index = {1,3,2,6,5 };
        // int[] index = {1,6,3,2,5};
        Solution node = new Solution();
        // boolean bool = node.verifyPostorder(index, 0, index.length - 1);
        boolean bool = node.verifyPostorder(index);
        System.out.println(bool);
    }
}
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int parent = Integer.MAX_VALUE;
        System.out.println(parent);
        return true;

        // public boolean verifyPostorder(int[] postorder, int start, int end) {
//        if (postorder == null) {
//            return false;
//        }
//
//        if (start >= end)
//            return true;
//
//        int rootNode = postorder[end];
//        int i = start;
//        for (; i < end ; ++i) {
//            if (rootNode < postorder[i])  break;
//        }
//        int j = i;
//        for (; j < end; j++) {
//            if (rootNode > postorder[j]) return false;
//        }
//
//        return (verifyPostorder(postorder, start, i - 1) && verifyPostorder(postorder, i, end - 1));
//        if (postorder == null || postorder.length <= 0) {
//            return false;
//        }
//
//        int n = postorder.length - 1;
//        int rootNode = postorder[n];
//        int i = 0;
//        for (; i < n; ++i) {
//            if (rootNode < postorder[i]) {
//                // i--;
//                break;
//            }
//        }
//        int j = i;
//        for (; j < n; j++) {
//            if (rootNode > postorder[j]) return false;
//        }
//        boolean left = true;
//        if (i > 0) {
//            left = verifyPostorder(Arrays.copyOfRange(postorder, 0, i));
//        }
//        boolean right = true;
//        if (i < n) {
//            right = verifyPostorder(Arrays.copyOfRange(postorder, i, n ));
//        }
//        return (left && right);
    }
}