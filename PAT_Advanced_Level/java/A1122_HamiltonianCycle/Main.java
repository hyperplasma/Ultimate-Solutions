package A1122_HamiltonianCycle;

import java.io.*;
import java.util.*;

/**
 * 测试点4报错
 */
public class Main {
    static final int N = 210;

    static int n, m, k;
    static boolean[][] g = new boolean[N][N];
    static int[] seq = new int[N];
    static int[] cnt = new int[N];

    static boolean check() {
        if (seq[0] != seq[k - 1]) return false;

        Arrays.fill(cnt, 0);

        for (int i = 0; i < k - 1; ++i) {
            if (!g[seq[i]][seq[i + 1]]) return false;
            cnt[seq[i]]++;
        }

        for (int i = 1; i <= n; ++i) {
            if (cnt[i] != 1) return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        // 读取边的信息
        for (int i = 0; i < m; ++i) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            g[a][b] = g[b][a] = true;
        }

        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (Q-- > 0) {
            input = br.readLine().split(" ");
            k = Integer.parseInt(input[0]);

            // 读取序列
            for (int i = 0; i < k; ++i) {
                seq[i] = Integer.parseInt(input[i + 1]);
            }

            sb.append(check() ? "YES\n" : "NO\n");
        }

        System.out.print(sb);
        br.close();
    }
}