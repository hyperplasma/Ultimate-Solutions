package MC0020;

/**
 * 20. 比赛配对问题
 * 数学；模拟
 */
public class Main {
    public static int solution(int n) {
        // 初始化配对次数
        int pairs = 0;

        // 当队伍数大于1时，继续进行比赛
        while (n > 1) {
            // 如果队伍数为偶数
            if (n % 2 == 0) {
                // 计算当前轮的配对次数
                pairs += n / 2;
                // 更新队伍数为下一轮的队伍数
                n = n / 2;
            } else {
                // 如果队伍数为奇数
                // 计算当前轮的配对次数
                pairs += (n - 1) / 2;
                // 更新队伍数为下一轮的队伍数
                n = (n - 1) / 2 + 1;
            }
        }

        // 返回总的配对次数
        return pairs;
    }

    public static void main(String[] args) {
        System.out.println(solution(7) == 6);
        System.out.println(solution(14) == 13);
        System.out.println(solution(1) == 0);
    }
}