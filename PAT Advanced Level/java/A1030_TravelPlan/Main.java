package A1030_TravelPlan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    private static final int INF = 0x3f3f3f3f;
    private static final int N = 510;

    private static int n, m, S, T;
    private static int[][] g = new int[N][N], c = new int[N][N];
    private static int[] dist = new int[N], cost = new int[N], pre = new int[N];
    private static boolean[] st = new boolean[N];

    private static void dijkstra() {
        Arrays.fill(dist, INF);
        Arrays.fill(cost, INF);
        dist[S] = 0;
        cost[S] = 0;
        pre[S] = S;

        for (int i = 0; i < n; ++i) {
            int t = -1;
            for (int j = 0; j < n; ++j) {
                if (!st[j] && (t == -1 || dist[j] < dist[t])) t = j;
            }
            st[t] = true;

            for (int j = 0; j < n; ++j) {
                if (dist[j] > dist[t] + g[t][j]) {
                    dist[j] = dist[t] + g[t][j];
                    cost[j] = cost[t] + c[t][j];
                    pre[j] = t;
                } else if (dist[j] == dist[t] + g[t][j]) {
                    if (cost[j] > cost[t] + c[t][j]) {
                        cost[j] = cost[t] + c[t][j];
                        pre[j] = t;
                    }
                }
            }
        }
    }

    private static void print() {
        int[] stack = new int[N];
        int top = -1;
        int x = T;

        while (x != S) {
            stack[++top] = x;
            x = pre[x];
        }
        stack[++top] = S;

        while (top != -1) {
            System.out.print(stack[top--] + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        S = Integer.parseInt(input[2]);
        T = Integer.parseInt(input[3]);

        for (int[] row : g) {
            Arrays.fill(row, INF);
        }
        for (int[] row : c) {
            Arrays.fill(row, INF);
        }

        for (int i = 0; i < m; ++i) {
            input = reader.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int L = Integer.parseInt(input[2]);
            int W = Integer.parseInt(input[3]);
            g[a][b] = g[b][a] = L;
            c[a][b] = c[b][a] = W;
        }

        dijkstra();
        print();
        System.out.println(dist[T] + " " + cost[T]);
    }
}