package MC0006;

/**
 * 6. 小E的怪物挑战
 * 贪心
 */
public class Main {
    public static int solution(int n, int H, int A, int[] h, int[] a) {
        // 创建一个数组来存储每个怪物是否可以被击败
        boolean[] canDefeat = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (h[i] < H && a[i] < A) {
                canDefeat[i] = true;
            }
        }

        // 动态规划数组，dp[i]表示以第i个怪物结尾的最长严格递增子序列的长度
        int[] dp = new int[n];
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            if (canDefeat[i]) {
                dp[i] = 1; // 初始化每个可击败的怪物为1
                for (int j = 0; j < i; j++) {
                    if (canDefeat[j] && h[j] < h[i] && a[j] < a[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                maxLength = Math.max(maxLength, dp[i]);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 4, 5, new int[]{1, 2, 3}, new int[]{3, 2, 1}) == 1);
        System.out.println(solution(5, 10, 10, new int[]{6, 9, 12, 4, 7}, new int[]{8, 9, 10, 2, 5}) == 2);
        System.out.println(solution(4, 20, 25, new int[]{10, 15, 18, 22}, new int[]{12, 18, 20, 26}) == 3);
        System.out.println(solution(4, 20, 25, new int[]{22, 18, 15, 10}, new int[]{26, 20, 18, 12}) == 1);
    }
}