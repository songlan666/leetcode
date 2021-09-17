public class SingleNumbers {

    public static void main(String[] args) {

        int[] a = {4,1,4,6};

        Solution solution = new Solution();
        int[] b = solution.singleNumbers(a);
//        for (int i : b) {
//            System.out.println(i);
//        }
    }

}

class Solution {
    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
            System.out.println(ret);
        }
        int div = 1;
        while ((div & ret) == 0) {
            div = div << 1;
            System.out.println(div);
        }
//        System.out.println(div);
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
}