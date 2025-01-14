package H03_PrefixSum_Difference;

/**
 * 二维前缀和
 */
public class PrefixSumMatrix {
    static int n = 100010;
    static int m = 100010;
    static int[][] a = new int[n + 1][m + 1];
    static int[][] s = new int[n + 1][m + 1];   // 前缀和矩阵

    /**
     * 初始化前缀和矩阵
     */
    public static void init() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + a[i][j];
            }
        }
    }

    /**
     * 求以(x1, y1)为左上角、(x2, y2)为右下角的子矩阵（含边界）上的片段和
     */
    public static int getPartialSum(int x1, int y1, int x2, int y2) {
        return s[x2][y2] - s[x2][y1 - 1] - s[x1 - 1][y2] + s[x1 - 1][y1 - 1];
    }
}