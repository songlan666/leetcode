public class GetNumberOfK {
    public static void main(String[] args) {
        int[] temp = {1};
        int target = 1;
        Solution solution = new Solution();
        int count = solution.search(temp,target);
        System.out.println(count);
    }
}

class Solution {
    public int search(int[] nums, int target) {
//        int leftIdx = binarySearch(nums, target, true);
//        int rightIdx = binarySearch(nums, target, false) - 1;
//        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
//            return rightIdx - leftIdx + 1;
//        }
//        return 0;
//    }
//
//    public int binarySearch(int[] nums, int target, boolean lower) {
//        int left = 0, right = nums.length - 1, ans = nums.length;
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            if (nums[mid] > target || (lower && nums[mid] >= target)) {
//                right = mid - 1;
//                ans = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return ans;
        int leftID = binarySearch(nums, target, true);
        int rightID = binarySearch(nums, target, false) - 1;
        if (rightID >= leftID && rightID < nums.length && nums[leftID] == target && nums[rightID] == target) {
            return rightID - leftID + 1;
        }
        return 0;
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;
        while (right >= left) {
            int mid = (right + left) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
