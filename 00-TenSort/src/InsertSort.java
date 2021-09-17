public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 6, 2, 15, 9, 4};
        // 3 5  6 8
        int[] temp = insertSort(arr);
        for (int i : temp) {
            System.out.println(i);
        }
    }

    public static int[] insertSort(int[] arr) {

        if (arr.length < 1 || arr == null) return new int[]{};

        for (int i = 1; i < arr.length; i++) {
            int j = i;

           // 将数据两两交换
//            while (arr[j] < arr[j - 1]) {
//            while (j > 0 && (arr[j] < arr[j - 1]))  {
//                int temp = arr[j];
//                arr[j] = arr[j - 1];
//                arr[j - 1] = temp;
////                if (j > 1) j--;
//                j--;


            // 将数据临时保存，找到位置了再放进去  TIP: j 的取值范围？？？？？？？？？？？？？？/
            int target = arr[j];
            while (j > 0 && (arr[j - 1] > target)) {
                arr[j] =  arr[j - 1];
                j--;
            }
            arr[j] = target;

        }

        return arr;
    }

}
