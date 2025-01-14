package MC0021;

/**
 * 21. 环形数组中的最大贡献值
 * 动态规划；数学；模拟
 */
public class Main {
    public static int solution(int n, int[] a) {
        int maxContribution = 0;

        // 遍历所有可能的i和j组合
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    // 计算dist(i, j)
                    int dist = Math.min(Math.abs(i - j), n - Math.abs(i - j));
                    // 计算贡献值
                    int contribution = (a[i] + a[j]) * dist;
                    // 更新最大贡献值
                    maxContribution = Math.max(maxContribution, contribution);
                }
            }
        }

        return maxContribution;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, new int[]{1, 2, 3}) == 5);
        System.out.println(solution(4, new int[]{4, 1, 2, 3}) == 12);
        System.out.println(solution(5, new int[]{1, 5, 3, 7, 2}) == 24);
    }
}