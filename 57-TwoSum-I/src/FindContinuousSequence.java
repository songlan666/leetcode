public class FindContinuousSequence {
    public static void main(String[] args) {
        int target = 6;
        Solution1 solution = new Solution1();
        solution.findContinuous(target);
    }
}
class Solution1 {
    public void findContinuous(int target) {
//        if (target < 3) return;
//        int small = 1;
//        int big = 2;
//        int middle = (1 + target) / 2;
//        int curSum = small + big;
//        while (small < middle) {
//            if (curSum == target) printContinuous(small, big);
//            while (curSum > target && small < middle) {
//                curSum -= small;
//                small++;
//                if (curSum == target) printContinuous(small, big);
//            }
//            big++;
//            curSum += big;
//        }

        if (target < 3) return;
        int small = 1;
        int big = 2;
        int middle = (target + 1) / 2;
        int curSum = small + big;
        while (small < middle) {
            if (curSum == target) printContinuous(small, big);
            while (curSum > target && small < middle) {
                small++;
                if (curSum == target) printContinuous(small, big);
            }
            big++;
            curSum += big;
        }

    }
    public void printContinuous(int small, int big) {
        for (int i = small; i <= big; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
