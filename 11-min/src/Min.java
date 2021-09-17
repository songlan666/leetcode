public class Min {
    public static void main(String[] args) {
        int[] temp = {2,2,2,0,1};
        Solution solution = new Solution();
        int count = solution.minArray(temp);
        System.out.println(count);

    }
}
class Solution {

    public int minArray(int[] numbers) {

        if (numbers == null || numbers.length <= 0) {
            return 0;
        }
//        int minIndex = numbers[0];
//        int j = 0;
//        int i;
//        for (i = 0; i < numbers.length; i++) {
//            if (minIndex > numbers[i]) {
//                minIndex = numbers[i];
//                j = i;
//            }
//        }
//        return numbers[j];

        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right -= 1;
            }
        }
        return numbers[left];

    }
}