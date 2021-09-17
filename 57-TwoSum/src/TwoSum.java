import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] temp = {1,3,5,10};
        int target = 9;
        Solution solution = new Solution();
        int[] count = solution.twoSum(temp, target);
        for (int i : count) {
            System.out.print(i + " ");
        }
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length <= 0 || nums == null || target <= 0)  return new int[]{0};

//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int diff = target - nums[i];
//            if (map.containsValue(nums[i])) {
//                return new int[]{diff, nums[i]};
//            }
//            map.put(i, diff);
//        }
//        return new int[]{0};

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) right--;
            else if (sum < target) left++;
            else  return new int[]{nums[left], nums[right]};
        }
        return new int[]{};

    }
}