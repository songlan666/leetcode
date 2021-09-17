public class HammingWeight {
    public static void main(String[] args) {
        int x = 17;
        int y = 20;
//        int m = x & y;
        int q = x & y;
        int m = (x & y) << 1;
        int n = 1 << (x & y);
        System.out.println(q);
        System.out.println(m);
        System.out.println(n);
//        Solution solution = new Solution();
//         int b = solution.hammingWeight(1222212121);
//         System.out.println(b);
    }
}
class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            // 方法一：
//            res += n & 1;
//            n = n >>> 1;

            // 方法二：
//             if ((n & 1 << i) != 0) res++;
             if ((n & 1 << i) != 0) res++;

        }

//方法三：
//        while (n > 0) {
//            n = n & (n - 1);
//            res++;
//        }

        return res;
    }
}