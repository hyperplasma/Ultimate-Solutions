package A1072_GasStation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

/**
 * 测试点4超时
 */
public class Main {
    static final int N = 1020;
    static final int INF = 0x3f3f3f3f;

    static int n, m, k, D;
    static int[][] g = new int[N][N];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int[] row : g) {
            Arrays.fill(row, INF);
        }

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());
        D = Integer.parseInt(tokenizer.nextToken());

        for (int i = 0; i < k; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            String a = tokenizer.nextToken();
            String b = tokenizer.nextToken();
            int d = Integer.parseInt(tokenizer.nextToken());

            int x = get(a);
            int y = get(b);
            g[x][y] = g[y][x] = Math.min(d, g[x][y]);
        }

        int res = -1, min = 0, sum = INF;
        for (int i = n + 1; i <= n + m; ++i) {
            int[] result = new int[2];
            dijkstra(i, result);

            int t1 = result[0];
            int t2 = result[1];

            if (t1 > min) {
                res = i;
                min = t1;
                sum = t2;
            } else if (t1 == min && t2 < sum) {
                res = i;
                sum = t2;
            }
        }

        if (res == -1) {
            System.out.println("No Solution");
        } else {
            System.out.printf("G%d\n%.1f %.1f\n", res - n, (double) min, (double) sum / n + 1e-8);
        }
    }

    static int get(String s) {
        if (s.charAt(0) == 'G') {
            return n + Integer.parseInt(s.substring(1));
        }
        return Integer.parseInt(s);
    }

    static void dijkstra(int S, int[] result) {
        Arrays.fill(dist, INF);
        Arrays.fill(st, false);
        dist[S] = 0;

        for (int i = 0; i < n + m; ++i) {
            int t = -1;
            for (int j = 1; j <= n + m; ++j) {
                if (!st[j] && (t == -1 || dist[j] < dist[t])) {
                    t = j;
                }
            }

            if (t == -1) break; // No more nodes to process
            st[t] = true;

            for (int j = 1; j <= n + m; ++j) {
                dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
            }
        }

        int min = INF, sum = 0;
        for (int i = 1; i <= n; ++i) {
            if (dist[i] > D) {
                result[0] = -INF;
                return;
            }
            min = Math.min(min, dist[i]);
            sum += dist[i];
        }
        result[0] = min;
        result[1] = sum;
    }
}