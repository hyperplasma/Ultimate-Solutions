package A1102_InvertABinaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int N = 20;
    static int n;
    static int[] l = new int[N];
    static int[] r = new int[N];
    static boolean[] hasFa = new boolean[N];
    static boolean isFirst = true;

    static void invert(int u) {
        if (u != -1) {
            invert(l[u]);
            invert(r[u]);
            int temp = l[u];
            l[u] = r[u];
            r[u] = temp;
        }
    }

    static void bfs(int u) {
        int[] q = new int[N];
        int front = 0, rear = 0;
        q[rear++] = u;

        while (front != rear) {
            int t = q[front++];
            if (l[t] != -1) q[rear++] = l[t];
            if (r[t] != -1) q[rear++] = r[t];
        }

        for (int i = 0; i < rear; ++i) {
            if (i > 0) System.out.print(" ");
            System.out.print(q[i]);
        }
        System.out.println();
    }

    static void dfs(int u) {
        if (u != -1) {
            dfs(l[u]);

            if (isFirst) isFirst = false;
            else System.out.print(" ");
            System.out.print(u);

            dfs(r[u]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Arrays.fill(l, -1);
        Arrays.fill(r, -1);

        for (int i = 0; i < n; ++i) {
            String[] line = br.readLine().split(" ");
            String lChild = line[0];
            String rChild = line[1];

            if (lChild.equals("-")) l[i] = -1;
            else {
                int son = Integer.parseInt(lChild);
                l[i] = son;
                hasFa[son] = true;
            }

            if (rChild.equals("-")) r[i] = -1;
            else {
                int son = Integer.parseInt(rChild);
                r[i] = son;
                hasFa[son] = true;
            }
        }

        int root = 0;
        while (hasFa[root]) root++;

        invert(root);
        bfs(root);
        dfs(root);
    }
}