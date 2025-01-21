package PAT_A1021_Deepest_Root;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static final int N = 100010;
    static final int M = 2 * N;

    static int n;
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] ne = new int[M];
    static int[] p = new int[N];
    static int idx = 0;

    public static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static int dfs(int u, int father) {
        int depth = 0;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == father) continue;
            depth = Math.max(depth, dfs(j, u) + 1);
        }
        return depth;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(h, -1);

        n = Integer.parseInt(br.readLine().trim());
        for (int i = 1; i <= n; ++i) {
            p[i] = i;
        }

        int k = n;
        for (int i = 1; i < n; ++i) {
            String[] input = br.readLine().trim().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            if (find(a) != find(b)) {
                k--;
                p[find(a)] = find(b);
            }
            add(a, b);
            add(b, a);
        }

        if (k > 1) {
            System.out.printf("Error: %d components\n", k);
        } else {
            List<Integer> nodes = new ArrayList<>();
            int maxDepth = -1;

            for (int i = 1; i <= n; ++i) {
                int depth = dfs(i, -1);
                if (depth > maxDepth) {
                    maxDepth = depth;
                    nodes.clear();
                    nodes.add(i);
                } else if (depth == maxDepth) {
                    nodes.add(i);
                }
            }

            for (int node : nodes) {
                System.out.println(node);
            }
        }
    }
}
