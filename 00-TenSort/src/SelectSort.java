public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 6, 2, 15, 9, 4};
        int[] temp = selectSort(arr);
        for (int i : temp) {
            System.out.println(i);
        }
    }

    // 第二种：将最小值的坐标找出来，最后直接交换坐标
    // 第一种：直接比较然后交换，但是过于繁琐

    public static int[] selectSort(int[] arr) {
        if (arr.length < 1 || arr == null) return new int[]{};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

}
