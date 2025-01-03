package MC0004;

/**
 * 4. 数字分组求偶数和
 * 数学
 */
public class Main {
    public static int solution(int[] numbers) {
        // 统计每个数字组中奇数和偶数的数量
        int[][] count = new int[numbers.length][2];
        for (int i = 0; i < numbers.length; i++) {
            String numString = String.valueOf(numbers[i]);
            for (int j = 0; j < numString.length(); j++) {
                char c = numString.charAt(j);
                if ((c - '0') % 2 == 0) {
                    count[i][0]++; // 偶数
                } else {
                    count[i][1]++; // 奇数
                }
            }
        }

        // 使用动态规划计算符合条件的组合数量
        int[][] dp = new int[numbers.length + 1][2];
        dp[0][0] = 1; // 初始状态，选择0个数字，奇数个数为0
        dp[0][1] = 0; // 初始状态，选择0个数字，奇数个数为1

        for (int i = 1; i <= numbers.length; i++) {
            dp[i][0] = dp[i - 1][0] * count[i - 1][0] + dp[i - 1][1] * count[i - 1][1];
            dp[i][1] = dp[i - 1][0] * count[i - 1][1] + dp[i - 1][1] * count[i - 1][0];
        }

        // 返回符合条件的组合数量
        return dp[numbers.length][0];
    }

    public static void main(String[] args) {
        // Add your test cases here
        System.out.println(solution(new int[]{123, 456, 789})); // 输出：14
        System.out.println(solution(new int[]{123456789})); // 输出：4
        System.out.println(solution(new int[]{14329, 7568})); // 输出：10
    }
}