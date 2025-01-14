package BasicAlgorithms.Sort;

/**
 * 归并排序
 */
public class MergeSort {
    /**
     * 二路归并排序 arr[l ... r]
     */
    public static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;

        int mid = l + r >> 1;
        mergeSort(arr, l, mid);     // 递归排序左半部分
        mergeSort(arr, mid + 1, r);     // 递归排序右半部分

        int[] temp = new int[r - l + 1];    // 辅助数组
        int i = l, j = mid + 1, k = 0;      // 初始化指针

        // 归并左右子区间为有序子区间
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // 并入区间剩余元素
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= r) {
            temp[k++] = arr[j++];
        }

        // 将排序后的结果复制回原始数组
        for (i = l, j = 0; i <= r; i++, j++) {
            arr[i] = temp[j];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 9, 2, 4, 1, 6, 3, 7, 8};
        mergeSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}