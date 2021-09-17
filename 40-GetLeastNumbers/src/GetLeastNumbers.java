import java.util.Comparator;
import java.util.PriorityQueue;

public class GetLeastNumbers {
    public static void main(String[] args) {
        int[] nums = {3,2,1};
        Solution solution = new Solution();
        int[] s = solution.getLeastNumbers(nums, 2);
        for (int i : s) {
            System.out.println(i);
        }
    }
}
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] vec = new int[k];
        if (k == 0) { // 排除 0 的情况
            return vec;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });

        // lambda
//        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((num1, num2) -> num2 - num1);

        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]);
        }

        for (int i = k; i < arr.length; ++i) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; ++i) {
            vec[i] = queue.poll();
        }
        return vec;
    }
}
