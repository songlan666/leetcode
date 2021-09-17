public class getMaxValue {
    public static void main(String[] args) {
        int[][] temp = {{1,10,3,8},{12,2,20,6},{5,7,4,11},{3,7,16,5}};
        Solution solution = new Solution();
        int count = solution.maxValue(temp);
        System.out.println(count);
    }
}
class Solution {
    public int maxValue(int[][] grid) {
        if (grid == null || grid[0] == null || grid.length <= 0 || grid[0].length <= 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 1; i < row; i++) { //初始化第一行
            grid[i][0] += grid[i-1][0];
        }
        for (int i = 1; i < col; i++) { //初始化第一列
            grid[0][i] += grid[0][i-1];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                grid[i][j] += Math.max(grid[i][j-1], grid[i-1][j]);
            }
        }
        return grid[row-1][col-1];
    }
}