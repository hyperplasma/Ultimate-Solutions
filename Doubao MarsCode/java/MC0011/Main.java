package MC0011;

/**
 * 11. 观光景点组合得分问题
 * 动态规划；贪心
 */
public class Main {
    public static int solution(int[] values) {
        int maxScore = 0;
        int maxI = values[0]; // 初始化最大值为第一个元素的值

        for (int j = 1; j < values.length; j++) {
            // 计算当前组合的得分
            int currentScore = maxI + values[j] - j;
            // 更新最大得分
            maxScore = Math.max(maxScore, currentScore);
            // 更新maxI，选择values[i] + i的最大值
            maxI = Math.max(maxI, values[j] + j);
        }

        return maxScore;
    }

    public static void main(String[] args) {
        // Add your test cases here
        System.out.println(solution(new int[]{8, 3, 5, 5, 6}) == 11 ? 1 : 0);
        System.out.println(solution(new int[]{10, 4, 8, 7}) == 16 ? 1 : 0);
        System.out.println(solution(new int[]{1, 2, 3, 4, 5}) == 8 ? 1 : 0);
    }
}