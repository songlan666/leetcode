import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SingleNumber {

    public static void main(String[] args) {

        int[] a = {0, 2, 5, 4, 3};

        Solution solution = new Solution();
        int[] b = solution.constructArr(a);
        for (int i : b) {
            System.out.println(i);
        }
    }

}
//
//class Solution {
//    public int singleNumber(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i])) {
//                map.put(nums[i], map.get(nums[i]) + 1);
//            } else {
//                map.put(nums[i], 1);
//            }
//        }
//
//        Set<Integer> set = map.keySet();
//        for (Integer s : set) {
//
//            if (map.get(s) == 1) {
//                return s;
//            }
//        }
//            return -1;
//    }
//}

//
//class Solution {
//    public int majorityElement(int[] nums) {
//        if (nums == null || nums.length < 1) return 0;
//        int Number = 0;
//        int result = 0;
//        for (int i = 0; i < nums.length; i++) {
//
//            if (Number == 0) {
////                Number = 1;
//                result = nums[i];
//            }
//            if (nums[i] != result) Number--;
//            else Number++;
//        }
//        return result;
//    }
//}

// t66
class Solution {
    public int[] constructArr(int[] a) {
        int len = a.length;
        if(len == 0) return new int[0];
        int[] b = new int[len];
        b[0] = 1;
        int tmp = 1;
        for(int i = 1; i < len; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for(int i = len - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
}