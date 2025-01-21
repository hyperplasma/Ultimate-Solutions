package PAT_A1066_Root_of_AVL_Tree;

import java.util.Scanner;

public class Main {
    static final int N = 30;

    static int n;
    static int[] l = new int[N];
    static int[] r = new int[N];
    static int[] w = new int[N];
    static int[] h = new int[N];
    static int idx = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        int root = 0;
        for (int i = 0; i < n; ++i) {
            int x = scanner.nextInt();
            root = insert(root, x);
        }

        System.out.println(w[root]);
        scanner.close();
    }

    static void update(int u) {
        h[u] = Math.max(h[l[u]], h[r[u]]) + 1;
    }

    static int getBF(int u) {
        return h[l[u]] - h[r[u]];
    }

    static int L(int u) {
        int p = r[u];
        r[u] = l[p];
        l[p] = u;
        update(u);
        update(p);
        return p;
    }

    static int R(int u) {
        int p = l[u];
        l[u] = r[p];
        r[p] = u;
        update(u);
        update(p);
        return p;
    }

    static int insert(int u, int x) {
        if (u == 0) {
            u = ++idx;
            w[u] = x;
            h[u] = 1; // Initialize height at 1
        } else if (x < w[u]) {
            l[u] = insert(l[u], x);
            if (getBF(u) == 2) {
                if (getBF(l[u]) == 1) {
                    u = R(u);
                } else if (getBF(l[u]) == -1) {
                    l[u] = L(l[u]);
                    u = R(u);
                }
            }
        } else {
            r[u] = insert(r[u], x);
            if (getBF(u) == -2) {
                if (getBF(r[u]) == -1) {
                    u = L(u);
                } else if (getBF(r[u]) == 1) {
                    r[u] = R(r[u]);
                    u = L(u);
                }
            }
        }

        update(u);
        return u;
    }
}