public class MyPower {
    public static void main(String[] args) {
        Solution solution = new Solution();
        double b = solution.myPow(2,13);
        System.out.println(b);
    }
}

class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == -1) return 1 / x;
        double half = myPow(x, n / 2);
        double mod = myPow(x, n % 2);
        return half * half * mod;
    }
}

//class Solution {
//    public double myPow(double x, int n) {
//        if(x == 0) return 0;
//        long b = n;
//        double res = 1.0;
//        if(b < 0) {
//            x = 1 / x;
//            b = -b;
//        }
//        while(b > 0) {
//            if((b & 1) == 1) res *= x;
//            x *= x;
//            b >>= 1;
//        }
//        return res;
//    }
//}
