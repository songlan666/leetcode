import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 200;
        Solution solution = new Solution();
        int m = solution.fib(n);
        System.out.println(m);
    }
}
class Solution {
    public int fib(int n) {
//方法一：递归，数字太大，超过时间限制
        // if (n < 0) return -1;
        // if (n == 0) return 0;
        // if (n == 1) return 1;
        // return fib(n -1 ) + fib(n -2);

//方法二：
        if (n < 0) return -1;
        int[] result = {0, 1};
        if (n < 2) return result[n];

        int firstNumber = 0;
        int secondNumber = 1;
        int fibN = 0;
        int m = 0;
        // Map<Integer,Integer> map = new HashMap<Integer, Integer>();

        for (int i = 2; i <= n; i++) {
            fibN = (firstNumber + secondNumber) % 1000000007;
            // m = (firstNumber + secondNumber) / 1000000007;

            // map.put(fibN, m);


            firstNumber = secondNumber;
            secondNumber = fibN;
        }
        return fibN;
    }
}