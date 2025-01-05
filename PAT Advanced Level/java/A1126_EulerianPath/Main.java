package A1126_EulerianPath;

import java.io.*;

/**
 * 测试点6超时
 */
public class Main {
    static final int N = 510;

    static int n, m;
    static boolean[][] g = new boolean[N][N];  // 邻接矩阵
    static boolean[] st = new boolean[N];      // 访问标记
    static int[] deg = new int[N];            // 度数数组

    // DFS遍历计算连通分量大小
    static int dfs(int u) {
        st[u] = true;
        int res = 1;
        for (int i = 1; i <= n; i++) {
            if (!st[i] && g[u][i]) {
                res += dfs(i);
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 读取顶点数和边数
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        // 读取边并构建邻接矩阵
        for (int i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            g[a][b] = g[b][a] = true;
            deg[a]++;
            deg[b]++;
        }

        // 输出每个顶点的度数
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (i > 1) {
                sb.append(" ");
            }
            sb.append(deg[i]);
        }
        System.out.println(sb);

        // 判断图的类型
        int num = dfs(1);
        if (num < n) {
            System.out.println("Non-Eulerian");
        } else {
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (deg[i] % 2 == 1) {
                    cnt++;
                }
            }

            if (cnt == 0) {
                System.out.println("Eulerian");
            } else if (cnt == 2) {
                System.out.println("Semi-Eulerian");
            } else {
                System.out.println("Non-Eulerian");
            }
        }

        br.close();
    }
}