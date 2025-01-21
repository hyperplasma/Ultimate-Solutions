package PAT_A1087_All_Roads_Lead_to_Rome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int N = 210;
    static int n, k;
    static int[] w = new int[N];
    static int[][] g = new int[N][N];
    static int[] dist = new int[N], happy = new int[N], cnt = new int[N], num = new int[N], pre = new int[N];
    static boolean[] st = new boolean[N];
    static String[] city = new String[N];
    static Map<String, Integer> mp = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());
        city[1] = tokenizer.nextToken();
        mp.put(city[1], 1);

        for (int i = 2; i <= n; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            city[i] = tokenizer.nextToken();
            w[i] = Integer.parseInt(tokenizer.nextToken());
            mp.put(city[i], i);
        }

        for (int[] row : g) Arrays.fill(row, 0x3f3f3f3f);
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[1] = 0;
        cnt[1] = 1;

        for (int i = 0; i < k; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            String a = tokenizer.nextToken();
            String b = tokenizer.nextToken();
            int cost = Integer.parseInt(tokenizer.nextToken());
            g[mp.get(a)][mp.get(b)] = g[mp.get(b)][mp.get(a)] = cost;
        }

        dijkstra();

        int T = mp.get("ROM");
        System.out.printf("%d %d %d %d%n", cnt[T], dist[T], happy[T], happy[T] / num[T]);

        Stack<Integer> stack = new Stack<>();
        for (int x = T; x != 1; x = pre[x]) {
            stack.push(x);
        }
        stack.push(1);

        System.out.print(city[stack.pop()]);
        while (!stack.isEmpty()) {
            System.out.print("->" + city[stack.pop()]);
        }
        System.out.println();
    }

    static void dijkstra() {
        for (int i = 0; i < n; ++i) {
            int t = -1;
            for (int j = 1; j <= n; ++j) {
                if (!st[j] && (t == -1 || dist[j] < dist[t])) {
                    t = j;
                }
            }
            st[t] = true;

            for (int j = 1; j <= n; ++j) {
                if (dist[j] > dist[t] + g[t][j]) {
                    dist[j] = dist[t] + g[t][j];
                    cnt[j] = cnt[t];
                    happy[j] = happy[t] + w[j];
                    num[j] = num[t] + 1;
                    pre[j] = t;
                } else if (dist[j] == dist[t] + g[t][j]) {
                    cnt[j] += cnt[t];
                    if (happy[j] < happy[t] + w[j]) {
                        happy[j] = happy[t] + w[j];
                        num[j] = num[t] + 1;
                        pre[j] = t;
                    } else if (happy[j] == happy[t] + w[j] && num[j] > num[t] + 1) {
                        num[j] = num[t] + 1;
                        pre[j] = t;
                    }
                }
            }
        }
    }
}
