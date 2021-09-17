public class ShellSort {
    public static void main(String[] args) {
        int[] arr = { 49, 39, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22 };
        shellsort(arr);
        System.out.println("排序后:");
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void shellsort(int[] arr) {
        if (arr.length < 1 || arr == null) return;
        int d = arr.length / 2;
        while (d >= 1) {
            shellInsert(arr, d);
            d /= 2;
        }
    }

    public static void shellInsert(int[] arr, int d) {
        for (int i = d; i < arr.length; i += d) {
            int j = i - d;
            int temp = arr[i];
            while (j >= 0 && temp < arr[j]) {
                arr[j + d] = arr[j];
                j = j - d;
            }
            arr[j + d] = temp;
        }
    }

}
