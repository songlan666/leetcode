import java.util.Arrays;
import java.util.Comparator;

public class MinNumber {
    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        Solution solution = new Solution();
        String s = solution.minNumber(nums);
        System.out.println(s);
    }
}

//class Solution {
//    public String minNumber(int[] nums) {
//        String[] arr = new String[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            arr[i] = String.valueOf(nums[i]);
//        }
////        Comparator cmp = new MyComparator();
//
//        Arrays.sort(arr, new MyComparator());
//
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < arr.length; i++) {
//            sb.append(arr[i]);
//        }
//        return sb.toString();
//    }
    private class MyComparator implements Comparator<String>{
//    private class MyComparator implements Comparator<String> {

//        @Override
//        public int compare(String o1, String o2) {
//            return (o1 + o2).compareTo(o2 + o1);
//        }
//    }
//}

 class Solution {
     public String minNumber(int[] nums) {
         String[] arr = new String[nums.length];
         for (int i = 0; i < nums.length; i++) {
             arr[i] = String.valueOf(nums[i]);
         }
//         Arrays.sort(arr, new Comparator<String>() {
//             public int compare(String o1, String o2) {
//                 return (o1 + o2).compareTo(o2 + o1);
//             }
//         });

         // lambda
         Arrays.sort(arr, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));


         StringBuilder sb = new StringBuilder();
         for (int i = 0; i < arr.length; i++) {
             sb.append(arr[i]);
         }
         return sb.toString();
     }
 }