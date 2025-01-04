package A1044_ShoppingInMars;

import java.util.Scanner;

/**
 * 测试点2、3、5超时
 */
public class Main {

    static final int N = 100010;
    static final int INF = 0x3f3f3f3f;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int M = sc.nextInt();
        int[] s = new int[N];

        for (int i = 1; i <= n; ++i) {
            s[i] = sc.nextInt();
            s[i] += s[i - 1];
        }

        int res = INF;
        for (int i = 1, j = 0; i <= n; ++i) {
            while (s[i] - s[j + 1] >= M) j++;
            if (s[i] - s[j] >= M) res = Math.min(res, s[i] - s[j]);
        }

        for (int i = 1, j = 0; i <= n; ++i) {
            while (s[i] - s[j + 1] >= M) j++;
            if (s[i] - s[j] == res) {
                System.out.println((j + 1) + "-" + i);
            }
        }

        sc.close();
    }
}