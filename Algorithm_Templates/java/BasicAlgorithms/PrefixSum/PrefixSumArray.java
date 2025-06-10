package BasicAlgorithms.PrefixSum;

/**
 * 一维前缀和
 */
public class PrefixSumArray {
    static int n = 100010;
    static int[] a = new int[n + 1];
    static int[] s = new int[n + 1];    // 前缀和数组

    /**
     * 初始化前缀和数组
     */
    public static void init() {
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + a[i];
        }
    }

    /**
     * 求下标区间[l, r]上的片段和
     */
    public static int getPartialSum(int l, int r) {
        return s[r] - s[l - 1];
    }

    public static void main(String[] args) {
        init();
        System.out.println(getPartialSum(1, 3));
    }
}