package H01_Sort;

/**
 * 插入排序
 */
public class InsertSort {
    /**
     * 直接插入排序
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 1 && arr[j] > arr[j - 1]; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}