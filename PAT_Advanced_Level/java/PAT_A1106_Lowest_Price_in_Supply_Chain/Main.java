package PAT_A1106_Lowest_Price_in_Supply_Chain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 测试点2、3、5、6、7超时
 */
public class Main {
    static final int N = 100010;
    static final int INF = 0x3f3f3f3f;

    static int n; // [0, n - 1]
    static double P, R;
    static List<Integer>[] tr = new ArrayList[N];
    static boolean[] isRetailer = new boolean[N], st = new boolean[N];
    static int[] depth = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        P = Double.parseDouble(tokenizer.nextToken());
        R = Double.parseDouble(tokenizer.nextToken());

        for (int i = 0; i < n; i++) {
            tr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int k = Integer.parseInt(tokenizer.nextToken());

            if (k == 0) {
                isRetailer[i] = true;
            }

            for (int j = 0; j < k; j++) {
                int son = Integer.parseInt(tokenizer.nextToken());
                tr[i].add(son);
                st[son] = true;
            }
        }

        int root = 0;
        for (int i = 0; i < n; i++) {
            if (!st[i]) {
                root = i;
                break;
            }
        }

        dfs(root, 0);

        int cnt = 0, minp = INF;
        for (int i = 0; i < n; i++) {
            if (isRetailer[i] && depth[i] < minp) {
                minp = depth[i];
                cnt = 1;
            } else if (isRetailer[i] && depth[i] == minp) {
                cnt++;
            }
        }

        System.out.printf("%.4f %d\n", P * Math.pow(1 + 0.01 * R, minp), cnt);
    }

    static void dfs(int u, int d) {
        depth[u] = d;
        for (int i : tr[u]) {
            dfs(i, d + 1);
        }
    }
}