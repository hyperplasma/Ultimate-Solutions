package MC0039;

/**
 * 39. 计算从位置x到y的最少步数
 */
public class Main {
    public static int solution(int x, int y) {
        int dist = Math.abs(x - y);

        int flag = 0;
        int length = 1;
        int steps = 0;
        while (dist > 0) {
            if (flag == 2) {
                length++;
                flag = 0;
            }
            dist -= length;
            flag++;
            steps++;
        }

        return steps;
    }

    public static void main(String[] args) {
        // You can add more test cases here
        System.out.println(solution(12, 6) == 4);
        System.out.println(solution(34, 45) == 6);
        System.out.println(solution(50, 30) == 8);
    }
}
