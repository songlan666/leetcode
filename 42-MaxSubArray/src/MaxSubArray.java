public class MaxSubArray {
    public static void main(String[] args) {
        int[] temp = {-2,1,-3,4,-1,2,1,-5,4};
        Solution solution = new Solution();
        int count = solution.maxSubArray(temp);
        System.out.println(count);
    }
}
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}