package BasicAlgorithms.PrefixSumAndDifference;

/**
 * 二维差分
 */
public class DifferenceMatrix {
    static int n = 100010;
    static int m = 100010;
    static int[][] a = new int[n + 1][m + 1];
    static int[][] b = new int[n + 1][m + 1];    // 差分矩阵

    /**
     * 给以(x1, y1)为左上角、(x2, y2)为右下角的子矩阵（含边界）加上c
     */
    public static void insert(int x1, int y1, int x2, int y2, int c) {
        b[x1][y1] += c;
        b[x2 + 1][y1] -= c;
        b[x1][y2 + 1] -= c;
        b[x2 + 1][y2 + 1] += c;
    }

    /**
     * 初始化差分矩阵
     */
    public static void init() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                insert(i, j, i, j, a[i][j]);
            }
        }
    }

    /**
     * 将操作过的差分矩阵变为原矩阵：求差分矩阵的前缀和
     */
    public static void toOriginalMatrix() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                b[i][j] += b[i - 1][j] + b[i][j - 1] - b[i - 1][j - 1];
            }
        }
    }
}