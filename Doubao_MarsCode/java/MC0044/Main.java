package MC0044;

/**
 * 44. 小E的射击训练
 */
public class Main {
    public static int solution(int x, int y) {
        for (int i = 1; i <= 10; i++) {
            if (x * x + y * y <= i * i) {
                return 11 - i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution(1, 0) == 10);
        System.out.println(solution(1, 1) == 9);
        System.out.println(solution(0, 5) == 6);
        System.out.println(solution(3, 4) == 6);
    }
}