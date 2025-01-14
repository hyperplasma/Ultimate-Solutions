package BasicAlgorithms.PrefixSumAndDifference;

/**
 * 一维差分
 */
public class DifferenceArray {
    static int n = 100010;
    static int[] a = new int[n + 1];
    static int[] b = new int[n + 1];    // 差分数组

    /**
     * 给区间[l, r]上所有数加上c
     */
    public static void insert(int l, int r, int c) {
        b[l] += c;
        b[r + 1] -= c;
    }

    /**
     * 初始化差分数组
     */
    public static void init() {
        for (int i = 1; i <= n; i++) {
            insert(i, i, a[i]);
        }
    }

    /**
     * 将操作过的差分数组变为原数组（前缀和与差分互为逆运算）
     */
    public static void toOriginalArray() {
        for (int i = 1; i <= n; i++) {
            b[i] += b[i - 1];
        }
    }

    public static void main(String[] args) {
        init();
        toOriginalArray();
    }
}
