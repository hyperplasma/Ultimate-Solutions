package PAT_A1003_Emergency;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int N = 510;
    static final int INF = 0x3f3f3f3f;

    static int n, m, S, T;
    static int[][] g = new int[N][N];
    static int[] w = new int[N];
    static int[] dist = new int[N];
    static int[] sum = new int[N];
    static int[] cnt = new int[N];
    static boolean[] st = new boolean[N];

    public static void dijkstra() {
        Arrays.fill(dist, INF);
        Arrays.fill(st, false);
        Arrays.fill(sum, 0);
        Arrays.fill(cnt, 0);
        dist[S] = 0;
        sum[S] = w[S];
        cnt[S] = 1;

        for (int i = 0; i < n - 1; ++i) {
            int t = -1;
            for (int j = 0; j < n; ++j)
                if (!st[j] && (t == -1 || dist[j] < dist[t]))
                    t = j;

            st[t] = true;

            for (int j = 0; j < n; ++j) {
                if (dist[j] > dist[t] + g[t][j]) {
                    dist[j] = dist[t] + g[t][j];
                    sum[j] = sum[t] + w[j];
                    cnt[j] = cnt[t];
                } else if (dist[j] == dist[t] + g[t][j]) {
                    cnt[j] += cnt[t];
                    if (sum[j] < sum[t] + w[j]) sum[j] = sum[t] + w[j];
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < N; ++i)
            Arrays.fill(g[i], INF);

        n = scanner.nextInt();
        m = scanner.nextInt();
        S = scanner.nextInt();
        T = scanner.nextInt();

        for (int i = 0; i < n; ++i)
            w[i] = scanner.nextInt();

        for (int i = 0; i < m; ++i) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int len = scanner.nextInt();
            g[a][b] = g[b][a] = Math.min(g[a][b], len);
        }

        dijkstra();
        System.out.printf("%d %d\n", cnt[T], sum[T]);

        scanner.close();
    }
}