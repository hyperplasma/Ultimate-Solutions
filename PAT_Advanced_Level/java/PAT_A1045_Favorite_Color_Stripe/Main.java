package PAT_A1045_Favorite_Color_Stripe;

import java.util.Scanner;

public class Main {
    static final int N = 210, M = 10010;
    static int n, m, l;
    static int[] p = new int[N];
    static int[] s = new int[M];
    static int[][] f = new int[N][M];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        m = sc.nextInt();
        for (int i = 1; i <= m; i++) {
            p[i] = sc.nextInt();
        }

        l = sc.nextInt();
        for (int i = 1; i <= l; i++) {
            s[i] = sc.nextInt();
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= l; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if (p[i] == s[j]) {
                    f[i][j] = Math.max(f[i][j], f[i][j - 1] + 1);
                }
            }
        }

        System.out.println(f[m][l]);
    }
}