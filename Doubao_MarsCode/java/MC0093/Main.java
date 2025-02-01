package MC0093;

/**
 * 93. 英雄升级与奖励最大化
 */
public class Main {
    public static int solution(int n, int k, int[] b, int[] c) {
        int[][] dp = new int[n + 1][k + 1];
        int[] step = new int[n + 1];    // 记录每个英雄达到目标所需要的升级次数

        // 计算每个英雄的升级次数
        for (int i = 1; i <= n; i++) {
            double a = 1;
            int x = 1;
            while (a != b[i - 1]) {
                if (a + Math.floor(a / x) <= b[i - 1]) {
                    step[i]++;
                    a = a + Math.floor(a / x);
                } else if (a + Math.floor(a / x) > b[i - 1]) {
                    x++;
                }
            }
        }

        // 初始化DP数组
        for (int i = 0; i <= k; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            if (step[i] == 0) {
                dp[i][0] = c[i - 1] + dp[i - 1][0];
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }

        // 动态规划计算最大奖励
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j < step[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - step[i]] + c[i - 1]);
                }
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) {
        // Add your test cases here
        System.out.println(solution(4, 4, new int[]{1, 7, 5, 2}, new int[]{2, 6, 5, 2}) == 9);
        System.out.println(solution(3, 0, new int[]{3, 5, 2}, new int[]{5, 4, 7}) == 0);
    }
}
