public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22 };
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后:");
        for (int i : arr) {
            System.out.println(i);
        }
    }


// 是对此函数递归，不断是getIndex
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int index = getIndex(arr, left, right);
            quickSort(arr, left, index - 1);
            quickSort(arr, index + 1, right);
        }
    }

    public static int getIndex(int[] arr, int left, int right) {
        int temp = arr[left];
        while (left < right) {
            while (left < right && temp <= arr[right]) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && temp >= arr[left]) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        return left;
    }

}
