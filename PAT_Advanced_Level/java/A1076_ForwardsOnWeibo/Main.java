package A1076_ForwardsOnWeibo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static final int N = 1010, M = N * 1000;

    private static int n, m;
    private static int[] h = new int[N];
    private static int[] e = new int[M];
    private static int[] ne = new int[M];
    private static int idx = 0;
    private static boolean[] st = new boolean[N];

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    private static int bfs(int u) {
        Arrays.fill(st, false);

        Queue<Integer> q = new LinkedList<>();
        q.offer(u);
        st[u] = true;

        int res = 0;
        for (int step = 0; step < m; ++step) {
            int size = q.size();
            res += size;
            while (size-- > 0) {
                int t = q.poll();
                for (int i = h[t]; i != -1; i = ne[i]) {
                    int j = e[i];
                    if (!st[j]) {
                        st[j] = true;
                        q.offer(j);
                    }
                }
            }
        }

        return res + q.size() - 1;
    }

    public static void main(String[] args) {
        Arrays.fill(h, -1);

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for (int i = 1; i <= n; ++i) {
            int k = scanner.nextInt();
            while (k-- > 0) {
                int a = scanner.nextInt();
                add(a, i);
            }
        }

        int k = scanner.nextInt();
        while (k-- > 0) {
            int a = scanner.nextInt();
            System.out.println(bfs(a));
        }
        scanner.close();
    }
}
