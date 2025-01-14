package H01_Sort;

/**
 * 快速排序
 */
public class QuickSort {
    /**
     * 快速排序 arr[l ... r]
     */
    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) return;

        int x = arr[l + (r - l) / 2];   // 枢轴（选择中间元素）
        int i = l - 1, j = r + 1;       // 双指针初始位于两侧外（追加1偏移量）

        while (i < j) {
            do {
                i++;
            } while (arr[i] < x);
            do {
                j--;
            } while (arr[j] > x);
            if (i < j) {
                swap(arr, i, j);
            }
        }

        quickSort(arr, l, j);       // 左子区间右端点必须为j
        quickSort(arr, j + 1, r);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}