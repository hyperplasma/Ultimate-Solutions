package MC0038;

public class Main {
    public static int solution(int m, int n, int[][] p) {
        // 初始化 dp 数组，表示到达每一天的最小花费
        int[] dp = new int[m + 1];
        // 将 dp 数组中的元素初始化为一个很大的数，表示初始状态为无穷大
        for (int i = 0; i <= m; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        // 第 0 天的花费为0
        dp[0] = 0;

        // 遍历每个补给站
        for (int[] station : p) {
            int day = station[0];
            int cost = station[1];
            // 更新从该天开始到最后一天的最小花费
            for (int j = day; j <= m; j++) {
                if (dp[day] != Integer.MAX_VALUE) { // 确保该天可达
                    dp[j] = Math.min(dp[j], dp[day] + (j - day) * cost);
                }
            }
        }

        return dp[m];
    }

    public static void main(String[] args) {
        // Add your test cases here

        System.out.println(solution(5, 4, new int[][]{{0, 2}, {1, 3}, {2, 1}, {3, 2}}) == 7);
    }
}
