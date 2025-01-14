package MC0010;

/**
 * 10. 小F的永久代币卡回本计划
 * 数学
 */
public class Main {
    public static int solution(int a, int b) {
        // 计算需要登录的天数
        return (a + b - 1) / b; // 使用整数除法向上取整
    }

    public static void main(String[] args) {
        System.out.println(solution(10, 1) == 10);
        System.out.println(solution(10, 2) == 5);
        System.out.println(solution(10, 3) == 4);
    }
}