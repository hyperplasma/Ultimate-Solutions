package MC0014;

/**
 * 14. 数组元素之和最小化
 * 数学；贪心
 */
public class Main {
    public static int solution(int n, int k) {
        // 初始化数组元素之和
        int sum = 0;
        // 从 k 开始，逐步增加 k 的倍数
        for (int i = 0; i < n; i++) {
            sum += k * (i + 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 1) == 6); // 输出: true
        System.out.println(solution(2, 2) == 6); // 输出: true
        System.out.println(solution(4, 3) == 30); // 输出: true
    }
}
