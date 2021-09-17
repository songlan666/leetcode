public class PreorderTraversal {
    public static void main(String[] args) {
        int[] index = {8, 6, 5, 7, 10, 9, 11};
        // int[] index = {1,6,3,2,5};
        Sol node = new Sol();
        boolean bool = node.verifyPostorder(index, 0, index.length - 1);
        // boolean bool = node.verifyPostorder(index);
        System.out.println(bool);
    }
}
class Sol {
    public boolean verifyPostorder(int[] postorder, int start, int end) {
        if (postorder == null) return false;
        if (start >= end) return true;

        int root = postorder[start];
        int i = start + 1;
        for (; i < end; i++) {
            if (root < postorder[i]) break;
        }
        int j = i;
        for (; j < end; j++) {
            if (root > postorder[j]) return false;
        }
        return verifyPostorder(postorder, start + 1, i - 1) && verifyPostorder(postorder, i, end);
    }
}
