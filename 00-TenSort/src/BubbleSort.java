public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 6, 2, 15, 9, 4};
        int[] temp = bubblesort(arr);
        for (int i : temp) {
            System.out.println(i);
        }
    }

    // 用haschange判断里面的序列是否已经排过序，如果排了直接返回
    public static int[] bubblesort(int[] arr) {
        if (arr == null || arr.length < 1) return new int[]{};
        boolean hasChange = true;
        for (int i = 0; (i < arr.length - 1) && hasChange; i++) {
            hasChange = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    hasChange = true;
                }
            }
        }
        return arr;
    }

}
