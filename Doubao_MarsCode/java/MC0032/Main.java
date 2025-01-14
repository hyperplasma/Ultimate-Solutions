package MC0032;

/**
 * 32. 二分数字组合
 */
public class Main {
    public static int solution(int n, int A, int B, int[] array_a) {
        // dp[i][j][k]表示前i个数字，个位数分别为j和k时的划分方案数
        int[][][] dp = new int[n + 1][10][10];
        // 初始化dp数组
        dp[0][0][0] = 1;
        int sum = 0;
        // 第i个数
        for (int i = 1; i <= array_a.length; i++) {
            // 第一组
            for (int j = 0; j < 10; j++) {
                // 第二组
                for (int k = 0; k < 10; k++) {
                    // 加入第一组
                    dp[i][j][k] += dp[i - 1][((j + 10) - array_a[i - 1] % 10) % 10][k];
                    // 加入第二组
                    dp[i][j][k] += dp[i - 1][j][((k + 10) - array_a[i - 1] % 10) % 10];
                }
            }
            // 累加
            sum += array_a[i - 1];
        }
        // 总和个位数是否为A
        int a = sum % 10 == A ? 1 : 0;
        // 总和个位数是否为B
        int b = sum % 10 == B ? 1 : 0;
        return dp[n][A][B] + a + b;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 1, 1};
        int[] array2 = {1, 1, 1};
        int[] array3 = {1, 1};

        System.out.println(solution(3, 1, 2, array1) == 3);
        System.out.println(solution(3, 3, 5, array2) == 1);
        System.out.println(solution(2, 1, 1, array3) == 2);
    }
}
