public class GetNumberK {
    public static void main(String[] args) {
        int[] temp = {0,1,2,3,4,5,6,8,9};
        Solution solution = new Solution();
        int count = solution.missingNumber(temp);
        System.out.println(count);
    }
}

class Solution {
    public int missingNumber(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != i) {
//                return i;
//            }
//        }
//        return -1;

        //方法二：二分查找
        if (nums.length <= 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (right >= left) {
            int mid = (right + left) / 2;

            if (nums[mid] != mid) {
                if (mid == 0 || nums[mid - 1] == mid - 1) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }



//            if (nums[mid] == mid) {
//                left = mid + 1;
//
//            } else {
//                right = mid - 1;
//            }
//        }
//        return left;
        }
        return -1;
    }
}