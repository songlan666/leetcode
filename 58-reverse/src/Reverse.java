import javax.swing.tree.TreeNode;
import java.util.Queue;

public class Reverse {
    public static void main(String[] args) {
        String s = " ";
        String s1 = s.trim();
        System.out.print(s1);

//        Solution solution = new Solution();
//        String result = solution.reverseWords(s);
        // System.out.println(result);
    }
}
class Solution {
    public String reverseWords(String s) {
        s.trim();
        if (s.length() <= 1) return s;
        // int left = 0;
        int right = s.length() - 1;
        int left = right;
        StringBuilder sb = new StringBuilder();
        // for (int left = right; left >= 0; left--)
        while (left >= 0) {
            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }
            sb.append(s.substring(left + 1, right + 1) + ' ');
            while (left >= 0 && s.charAt(left) == ' ') left--;
            right = left;
        }
        return sb.toString().trim();
    }


    
}
