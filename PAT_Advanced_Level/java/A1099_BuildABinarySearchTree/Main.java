package A1099_BuildABinarySearchTree;

import java.util.*;

public class Main {
    static final int N = 110;
    static int n;
    static int[] l = new int[N], r = new int[N], w = new int[N];
    static int[] val = new int[N];
    static boolean[] st = new boolean[N];
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        Arrays.fill(l, -1);
        Arrays.fill(r, -1);

        for (int i = 0; i < n; ++i) {
            int lChild = sc.nextInt();
            int rChild = sc.nextInt();

            l[i] = lChild;
            r[i] = rChild;
            if (lChild != -1) st[lChild] = true;
            if (rChild != -1) st[rChild] = true;
        }

        for (int i = 0; i < n; ++i) val[i] = sc.nextInt();
        Arrays.sort(val, 0, n);

        int root = 0;
        while (st[root]) root++;

        cnt = 0;
        dfs(root);
        bfs(root);

        sc.close();
    }

    private static void dfs(int u) {
        if (u != -1) {
            dfs(l[u]);
            w[u] = val[cnt++];
            dfs(r[u]);
        }
    }

    private static void bfs(int u) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(u);
        boolean isFirst = true;

        while (!queue.isEmpty()) {
            int t = queue.poll();

            if (isFirst) isFirst = false;
            else System.out.print(" ");
            System.out.print(w[t]);

            if (l[t] != -1) queue.offer(l[t]);
            if (r[t] != -1) queue.offer(r[t]);
        }
        System.out.println();
    }
}