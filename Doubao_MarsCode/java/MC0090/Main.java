package MC0090;

/**
 * 90. 奇妙货币交易问题
 */
public class Main {
    public static String solution(int V, int W) {
        if (V <= 5) {
            return "YES";
        }

        while (W > 0) {
            int remainder = W % V;
            if (remainder <= 2) {
                W /= V;
            } else if (remainder >= V - 2) {
                W = W / V + 1;
            } else {
                return "NO";
            }
        }

        return "YES";
    }

    public static void main(String[] args) {
        // Add your test cases here
        System.out.println(solution(10, 9) == "YES");
        System.out.println(solution(200, 40199) == "YES");
        System.out.println(solution(108, 50) == "NO");
    }
}