package MC0001;


/**
 * 1. 找单独的数
 * 哈希表
 */
public class Main {
    public static int solution(int[] cards) {
        final int n = 1010;
        int[] cnt = new int[n];

        for (int card : cards) {
            cnt[card]++;
        }

        int res = -1;
        for (int card : cards) {
            if (cnt[card] == 1) {
                res = card;
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        // Add your test cases here
        System.out.println(solution(new int[]{7, 3, 3, 7, 10}));
    }
}
