package PAT_A1110_Complete_Binary_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int N = 30;
    static int n;
    static int[] l = new int[N];
    static int[] r = new int[N];
    static boolean[] hasFather = new boolean[N];
    static boolean isCBT = true;
    static int last = -1;

    static void bfs(int u) {
        int[] q = new int[N];
        int front = 1, rear = 1;
        q[rear++] = u;

        while (front != rear) {
            int t = q[front++];
            if (l[t] != -1) {
                q[rear++] = l[t];
            }
            if (r[t] != -1) {
                q[rear++] = r[t];
            }
        }

        for (int i = 1; i <= n / 2; ++i) {
            if (2 * i <= n && q[2 * i] != l[q[i]]) {
                isCBT = false;
            }
            if (2 * i + 1 <= n && q[2 * i + 1] != r[q[i]]) {
                isCBT = false;
            }
        }

        if (isCBT) {
            last = q[rear - 1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Arrays.fill(l, -1);
        Arrays.fill(r, -1);

        for (int i = 0; i < n; ++i) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            String lc = st.nextToken();
            String rc = st.nextToken();

            if (!lc.equals("-")) {
                int x = Integer.parseInt(lc);
                l[i] = x;
                hasFather[x] = true;
            }
            if (!rc.equals("-")) {
                int x = Integer.parseInt(rc);
                r[i] = x;
                hasFather[x] = true;
            }
        }

        int root = 0;
        while (hasFather[root]) {
            root++;
        }

        bfs(root);

        if (isCBT) {
            System.out.println("YES " + last);
        } else {
            System.out.println("NO " + root);
        }
    }
}
