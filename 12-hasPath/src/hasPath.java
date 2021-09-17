public class hasPath{
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "";
        Solution solution = new Solution();
        boolean result = solution.exist(board, word);
        System.out.println(result);
    }
}

class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length <= 0 || board[0].length <= 0 || board == null || word == null || word.length() <= 0) return false;
        char[] ch = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, ch, 0)) return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, int i, int j, char[] ch, int k) {
        if (i > board.length - 1 || i < 0 || j > board[0].length - 1 || j < 0 || board[i][j] != ch[k]) return false;
        if (k == ch.length - 1) return true;
        board[i][j] = '\0';
        boolean res = dfs(board, i, j - 1, ch, k + 1) || dfs(board, i, j + 1, ch, k + 1) ||
                dfs(board, i - 1, j, ch, k + 1) || dfs(board, i + 1, j, ch, k + 1);
        board[i][j] = ch[k];
        return res;
    }

}