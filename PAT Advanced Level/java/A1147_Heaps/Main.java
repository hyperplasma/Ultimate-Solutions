package A1147_Heaps;

import java.io.*;
import java.util.*;

/**
 * 测试点4
 */
public class Main {
    static final int N = 1010;
    static int n, m;
    static int[] tr = new int[N];
    static boolean isGreater, isLess, isFirst;

    static void check(int u) {
        if (2 * u <= n && tr[u] >= tr[2 * u]) {
            isGreater = true;
        } else if (2 * u <= n && tr[u] <= tr[2 * u]) {
            isLess = true;
        }

        if (2 * u + 1 <= n && tr[u] >= tr[2 * u + 1]) {
            isGreater = true;
        } else if (2 * u + 1 <= n && tr[u] <= tr[2 * u + 1]) {
            isLess = true;
        }

        if (2 * u <= n) {
            check(2 * u);
        }
        if (2 * u + 1 <= n) {
            check(2 * u + 1);
        }
    }

    // 后序遍历
    static void dfs(int u, StringBuilder sb) {
        if (2 * u <= n) {
            dfs(2 * u, sb);
        }
        if (2 * u + 1 <= n) {
            dfs(2 * u + 1, sb);
        }

        if (isFirst) {
            isFirst = false;
        } else {
            sb.append(" ");
        }
        sb.append(tr[u]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        while (m-- > 0) {
            // 重置标志
            isGreater = false;
            isLess = false;
            isFirst = true;

            // 读取树的节点值
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                tr[i] = Integer.parseInt(st.nextToken());
            }

            // 检查堆的性质
            check(1);

            // 判断堆的类型并输出
            if (!isGreater && isLess) {
                System.out.println("Min Heap");
            } else if (isGreater && !isLess) {
                System.out.println("Max Heap");
            } else {
                System.out.println("Not Heap");
            }

            // 输出后序遍历结果
            isFirst = true;
            StringBuilder sb = new StringBuilder();
            dfs(1, sb);
            System.out.println(sb);
        }
    }
}