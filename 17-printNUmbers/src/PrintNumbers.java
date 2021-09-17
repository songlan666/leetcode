public class PrintNumbers {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num = solution.printNumbers(5);
        for (int i : num) {
            System.out.println(i);
        }
    }
}

class Solution {
    public int[] printNumbers(int n) {
        if (n == 0) return new int[]{};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append("9");
        }
        int num = Integer.valueOf(String.valueOf(sb));
        int[] res = new int[num];
        for (int i = 1; i <= num; i++) {
            res[i-1] = i;
        }
        return res;
    }
}