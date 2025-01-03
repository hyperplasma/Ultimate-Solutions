package MC0025;

/**
 * 25. DNA序列编辑距离
 * 动态规划
 */
public class Main {
    public static int solution(String dna1, String dna2) {
        int m = dna1.length();
        int n = dna2.length();

        // 创建一个二维数组 dp
        int[][] dp = new int[m + 1][n + 1];

        // 初始化 dp 数组
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // 填充 dp 数组
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (dna1.charAt(i - 1) == dna2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        // 返回最终结果
        return dp[m][n];
    }

    public static void main(String[] args) {
        // Add your test cases here
        System.out.println(solution("AGCTTAGC", "AGCTAGCT") == 2);
        System.out.println(solution("AGCCGAGC", "GCTAGCT") == 4);
    }
}